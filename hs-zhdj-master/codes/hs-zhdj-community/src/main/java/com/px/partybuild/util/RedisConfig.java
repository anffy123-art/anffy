package com.px.partybuild.util;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.*;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;

//@EnableCaching
@Configuration
public class RedisConfig {

    private final Logger logger;
    @Resource
    private LettuceConnectionFactory lettuceConnectionFactory;


    public RedisConfig() {
        logger = LoggerFactory.getLogger(this.getClass());
    }

    @Bean
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuffer sb = new StringBuffer();
                sb.append(target.getClass().getSimpleName());
                sb.append(".");
                sb.append(method.getName());
                sb.append("[");
                for (Object obj : params) {
                    //由于参数可能不同, 缓存的key也需要不一样
                    sb.append(obj.toString());
                }
                sb.append("]");
                return sb.toString();
            }
        };
    }

    // 缓存管理器
    @Bean
    @Primary
    public CacheManager cacheManager() {
        logger.info("初始化 -> [{}]", "Redis CacheManager");
        // 设置序列化
        RedisSerializer<String> stringSerializer = keySerializer();
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = valueSerializer();

        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(stringSerializer))
                // value序列化方式
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer))
                .disableCachingNullValues()
                // 缓存过期时间
                .entryTtl(Duration.ofMinutes(5));

        RedisCacheManager.RedisCacheManagerBuilder builder = RedisCacheManager.RedisCacheManagerBuilder
                .fromConnectionFactory(lettuceConnectionFactory)
                .cacheDefaults(config)
                .transactionAware();
        @SuppressWarnings("serial")
        Set<String> cacheNames = new HashSet<String>() {
            {
                add("codeNameCache");
            }
        };
        builder.initialCacheNames(cacheNames);
        return builder.build();
    }

    /**
     * RedisTemplate配置
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory lettuceConnectionFactory) {

        logger.info("初始化 -> [{}]", "Redis RedisTemplate");
        // 设置序列化
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = valueSerializer();
        RedisSerializer<?> stringSerializer = keySerializer();

        // 配置redisTemplate
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setConnectionFactory(lettuceConnectionFactory);
        redisTemplate.setKeySerializer(stringSerializer);// key序列化
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);// value序列化
        redisTemplate.setHashKeySerializer(stringSerializer);// Hash key序列化
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);// Hash value序列化
        redisTemplate.afterPropertiesSet();

        return redisTemplate;
    }

    private RedisSerializer<String> keySerializer() {
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        return redisSerializer;
    }

    private Jackson2JsonRedisSerializer valueSerializer() {
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(
                Object.class);
        ObjectMapper om=getJsonMapper();
        jackson2JsonRedisSerializer.setObjectMapper(om);

        return jackson2JsonRedisSerializer;
    }

    private ObjectMapper getJsonMapper(){
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        //om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        om.activateDefaultTyping(LaissezFaireSubTypeValidator.instance ,ObjectMapper.DefaultTyping.NON_FINAL); //, JsonTypeInfo.As.PROPERTY
        om.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        om.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        //过滤类的属性id
        om.setFilterProvider(new SimpleFilterProvider().setFailOnUnknownId(false));
        //在序列化时，只有那些值为null或被认为为空的值的属性才不会被包含在内。
        om.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        //若要将日期序列化为ISO字符串
        om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        om.setTimeZone(TimeZone.getDefault());
        return om;
    }


}

