package com.px.partybuild.shiro;

import com.px.partybuild.util.DateUtils;
import com.px.partybuild.util.StringUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtUtils {

    @Value("${jwt-config.secret}")
    private String secret;

    @Value("${jwt-config.expire}")
    private int expire;

    @Value("${jwt-config.token-name}")
    private String tokenName;

    @Autowired
    private DateUtils dateUtils;

    @Autowired
    private StringUtils stringUtils;

    /**
     * 生成jwt token
     *
     * @param userId 用户ID
     * @return token
     */
    public String generateToken(String userId) {

        LocalDateTime dateTimeNow = LocalDateTime.now();
        LocalDateTime dateTimeExpiration = dateTimeNow.plusDays(this.expire);
        //LocalDateTime dateTimeExpiration = dateTimeNow.plusMinutes(5);
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
        // 后续获取 subject 是 userid
                .setSubject(userId)
                .setIssuedAt(dateUtils.DateTimeToDate(dateTimeNow))
                .setExpiration(dateUtils.DateTimeToDate(dateTimeExpiration))
        // 这里我采用的是 HS512 算法
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }


    /**
     * 解析 token，
     * 利用 jjwt 提供的parser传入秘钥，
     *
     * @param token token
     * @return 数据声明 Map<String, Object>
     */
    public Claims getClaimByToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * token是否过期
     *
     * @return true：过期
     */
    public boolean isTokenExpired(Date expiration) {
        return expiration.before(new Date());
    }

    /**
     * 获取请求的token
     */
    public String getRequestToken(HttpServletRequest httpRequest) {
        //从header中获取token
        String token = httpRequest.getHeader(tokenName);
        //如果header中不存在token，则从参数中获取token
        if (stringUtils.IsNullOrEmpty(token)) {
            token = httpRequest.getParameter(tokenName);
        }
        if (stringUtils.IsNullOrEmpty(token)) {
            // 从 cookie 获取 token
            Cookie[] cookies = httpRequest.getCookies();
            if (null == cookies || cookies.length == 0) {
                return null;
            }
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(tokenName)) {
                    token = cookie.getValue();
                    break;
                }
            }
        }
        return token;
    }

    /**
     * 根据 token 获取 userID
     *
     * @param token token
     * @return userId
     */
    public String getUserIdFromToken(String token) {

        if (stringUtils.IsNullOrEmpty(token)) {
            //throw new KCException("无效 token", HttpStatus.UNAUTHORIZED.value());
        }
        Claims claims = getClaimByToken(token);
        if (claims == null || isTokenExpired(claims.getExpiration())) {
            //throw new KCException(jwtUtils.getHeader() + "失效，请重新登录", HttpStatus.UNAUTHORIZED.value());
        }
        return claims.getSubject();
    }


    public String getSecret() {
        return secret;
    }

    public int getExpire() {
        return expire;
    }

    public String getTokenName() {
        return tokenName;
    }
}
