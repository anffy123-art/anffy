<br/>

<div align="center" >
    <img src="https://www.haishi.net.cn/img/17f49ecef80e4c6248070c401a94c032.0ff19479.png" />
<br/>
</div>

<div align="center">
<br/>
<h1>智慧党建</h1>

<a href="https://code.haishi.net.cn/">产品介绍官网</a> ｜ <a href="https://zhdj.haishi.net.cn/">在线体验</a> 

<br/>

</div>



## 项目说明

智慧党建开源版是一套基于Spring Boot的综合性党建信息化管理系统，旨在通过信息化手段提升党组织管理效率和党员服务质量。系统集成了党组织管理、党员管理、党费管理、活动管理、经费管理以及微信集成等多项功能，为基层党组织提供全面的信息化解决方案。



### 系统功能结构

![](./images/swdt.png)

### 系统功能说明

本系统主要功能包括：1. 登录和首页展示；2. 党组织信息和换届选举管理；3. 党员基本情况、党费管理及评先管理；4. 入党申请审核及发展对象管理；5. 组织生活和民主集中制管理；6. 党员学习教育及宣传阵地管理；7. 任务信息收集与材料模板管理；8. 门户信息管理与统计分析；9. 考试管理及在线考试功能。

## 系统主要界面

![image1.png](http://codeimg.haishi.net.cn/JY-ZHDJ-GZDJ_1.png)
![image2.png](http://codeimg.haishi.net.cn/JY-ZHDJ-GZDJ_2.png)
![image3.png](http://codeimg.haishi.net.cn/JY-ZHDJ-GZDJ_3.png)
![image4.png](http://codeimg.haishi.net.cn/JY-ZHDJ-GZDJ_4.png)
![image5.png](http://codeimg.haishi.net.cn/JY-ZHDJ-GZDJ_5.png)
![image6.png](http://codeimg.haishi.net.cn/JY-ZHDJ-GZDJ_6.png)
![image7.png](http://codeimg.haishi.net.cn/JY-ZHDJ-GZDJ_7.png)
![image8.png](http://codeimg.haishi.net.cn/JY-ZHDJ-GZDJ_8.png)
![image9.png](http://codeimg.haishi.net.cn/JY-ZHDJ-GZDJ_9.png)
![image10.png](http://codeimg.haishi.net.cn/JY-ZHDJ-GZDJ_10.png)



### 适用对象

本系统适用于各级党组织，特别是基层党委、党支部等组织，帮助其实现党务工作信息化、规范化和高效化。系统支持PC端和移动端，方便党员和党务工作者随时随地使用。

### 开源协议

本项目采用 GNU Affero General Public License v3.0 (AGPL-3.0) 开源协议。

## 项目结构说明

本项目采用标准的Spring Boot项目结构，遵循MVC架构模式，主要目录结构如下：

```
hs-zhdj-community/
├── lib/                        # 本地依赖库
├── src/                        # 源代码目录
│   ├── main/                   # 主要源代码
│   │   ├── java/               # Java代码
│   │   │   └── com/px/partybuild/
│   │   │       ├── controller/ # 控制器层
│   │   │       ├── mapper/     # MyBatis映射接口
│   │   │       ├── model/      # 数据模型
│   │   │       ├── service/    # 服务层
│   │   │       ├── shiro/      # Shiro安全框架配置
│   │   │       ├── util/       # 工具类
│   │   │       ├── vo/         # 视图对象
│   │   │       ├── AppConfig.java  # 应用配置类
│   │   │       └── ZhdjApplication.java # 应用入口
│   │   └── resources/          # 资源文件
│   │       ├── mapping/        # MyBatis映射XML文件
│   │       ├── static/         # 静态资源
│   │       ├── application.yml # 应用主配置
│   │       └── logback-spring.xml # 日志配置
├── pom.xml                     # Maven项目配置
├── mvnw                        # Maven包装器脚本(Unix)
└── mvnw.cmd                    # Maven包装器脚本(Windows)
```

### 核心包说明

1. **controller包**：控制器层，处理HTTP请求，实现API接口。
   - 按功能模块划分为多个控制器类，如`UserController`、`PartyUserController`等。
   - `partyExpand`子包包含党建扩展功能的控制器。
   - `workresourcelibrary`子包包含工作资源库相关控制器。

2. **model包**：数据模型层，定义数据实体类。
   - `Cf`前缀的类为系统配置相关模型，如`CfUsers`、`CfRoles`等。
   - `Dj`前缀的类为党建业务相关模型，如`DjTask`、`DjFundsbudget`等。
   - 每个模型类都有对应的`Example`类，用于MyBatis条件查询。

3. **mapper包**：数据访问层，定义MyBatis接口。
   - 对应model包中的实体类，提供数据库操作方法。
   - 复杂查询通过XML映射文件实现。

4. **service包**：业务逻辑层，实现业务处理。
   - 每个Service接口都有对应的实现类。
   - 封装复杂的业务逻辑，提供事务管理。

5. **shiro包**：安全框架配置。
   - 包含Shiro配置类、JWT工具类、自定义Realm等。
   - 实现认证和授权逻辑。

6. **util包**：工具类集合。
   - 包含各种通用工具，如日期处理、加密解密、HTTP请求等。

7. **vo包**：视图对象，用于数据传输和展示。
   - 定义前端交互的数据结构。

## 项目技术选型

本项目采用了现代化的Java Web技术栈，主要技术选型如下：

### 后端技术

| 技术 | 版本 | 说明 |
|------|------|------|
| Spring Boot | 2.3.4.RELEASE | 应用开发框架 |
| MySQL | 8.0+ | 关系型数据库 |
| MyBatis | 2.0.0 | ORM框架 |
| PageHelper | 1.2.5 | MyBatis分页插件 |
| Druid | 1.1.22 | 数据库连接池 |
| Redis | 6.0+ | 缓存数据库 |
| Apache Shiro | 1.4.0 | 安全框架 |
| JWT | 0.9.1 | JSON Web Token认证 |
| Lombok | 1.18.2 | Java代码简化工具 |
| FreeMarker | 2.3.30 | 模板引擎 |
| FastJSON | 1.2.47 | JSON处理库 |

### 环境要求

| 环境 | 版本 |
|------|------|
| JDK | 1.8+ |
| Maven | 3.5+ |
| MySQL | 5.7+ |
| Redis | 5.0+ |

### 安全框架

项目使用Shiro结合JWT实现认证和授权：

- **认证流程**：用户登录 -> 验证身份 -> 生成JWT令牌 -> 返回客户端
- **授权机制**：基于角色的访问控制(RBAC)
- **安全防护**：防XSS攻击、SQL注入防护、请求限流

### 缓存策略

使用Redis实现多级缓存：

- 用户信息缓存
- 菜单权限缓存
- 系统参数缓存
- 业务数据缓存

### 持久层设计

采用MyBatis作为ORM框架：

- 使用MyBatis Generator自动生成代码
- 基础CRUD操作自动生成
- 复杂查询通过自定义SQL实现
- PageHelper实现分页查询

## 项目开发说明

本节提供项目开发的相关指导，包括环境准备、本地开发、代码规范等内容。

### 开发环境准备

#### 基础环境

1. **JDK 1.8+**：安装并配置环境变量
2. **Maven 3.5+**：安装并配置环境变量
3. **Git**：版本控制工具
4. **IDE**：推荐使用IntelliJ IDEA或Eclipse
5. **MySQL 5.7+**：数据库服务
6. **Redis 5.0+**：缓存服务

#### 开发工具

1. **数据库管理工具**：如Navicat、MySQL Workbench等
2. **Redis客户端**：如Redis Desktop Manager等
3. **API测试工具**：如Postman、Insomnia等
4. **Maven仓库浏览器**：如Nexus Repository Browser等

### 本地开发步骤

1. **克隆代码**

   ```bash
   git clone <repository-url>
   cd hs-zhdj-community
   ```

2. **初始化数据库**

   - 创建数据库：`party_build_db`
   - 导入初始化SQL脚本（位于 `docs/sql` 目录下）

3. **配置本地环境**

   创建或修改 `src/main/resources/application-dev.yml` 文件，配置本地开发环境：

   ```yaml
   spring:
     datasource:
       druid:
         url: jdbc:mysql://localhost:3306/party_build_db?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai
         username: your_username
         password: your_password
     redis:
       host: localhost
       port: 6379
       password: 
   ```

4. **启动项目**

   使用IDE导入项目，或通过命令行启动：

   ```bash
   # 使用Maven Wrapper
   ./mvnw spring-boot:run
   
   # 或使用已安装的Maven
   mvn spring-boot:run
   ```

5. **访问接口**

   默认接口地址：`http://localhost:8062/`

### 代码规范

本项目遵循以下代码规范：

1. **Java代码规范**：
   - 遵循阿里巴巴Java开发手册规范
   - 使用统一的代码格式化配置
   - 变量命名采用驼峰命名法
   - 注释规范，方法和类必须有Javadoc注释

2. **API设计规范**：
   - RESTful API设计风格
   - 统一的返回格式
   - 合理的HTTP状态码使用
   - 完善的API文档

3. **数据库规范**：
   - 表名使用小写，单词间用下划线分隔
   - 字段名使用小写，单词间用下划线分隔
   - 必须有主键，建议使用自增ID
   - 表和字段必须有注释

### 常见问题解决

1. **依赖问题**：如果出现依赖问题，可尝试清理Maven缓存：
   ```bash
   mvn clean install -U
   ```

2. **数据库连接问题**：
   - 检查数据库服务是否启动
   - 检查用户名密码是否正确
   - 检查防火墙设置
   - 检查MySQL用户权限

3. **Redis连接问题**：
   - 检查Redis服务是否启动
   - 检查Redis配置是否正确
   - 如使用密码认证，检查密码是否正确

4. **自定义Jar包问题**：
   - 本项目使用了本地Jar包(如aspose-words)，确保lib目录下有对应Jar包
   - 使用Maven命令时需要包含系统依赖：`mvn clean install -DincludeSystemScope=true`

## 项目部署说明

本节提供项目的生产环境部署指南，包括环境准备、部署步骤、配置说明等内容。

### 部署环境要求

#### 服务器要求

| 配置项 | 最低配置 | 推荐配置 |
|------|---------|---------|
| CPU  | 2核     | 4核及以上 |
| 内存  | 4GB     | 8GB及以上 |
| 磁盘  | 50GB    | 100GB及以上 |
| 操作系统 | CentOS 7+/Ubuntu 18.04+/Windows Server 2016+ | CentOS 7+/Ubuntu 20.04+ |
| 网络带宽 | 5Mbps | 10Mbps及以上 |

#### 软件环境

| 软件 | 版本 | 说明 |
|------|------|------|
| JDK/JRE | 1.8+ | Java运行环境 |
| MySQL | 8.0+ | 数据库服务 |
| Redis | 5.0+ | 缓存服务 |
| Nginx | 1.18+ | Web服务器（可选） |

### 部署方式

本项目支持以下几种部署方式，可根据实际需求选择：

1. **独立JAR包部署**：直接运行打包后的JAR文件（推荐）
2. **Docker容器部署**：使用Docker和Docker Compose进行容器化部署
3. **传统WAR包部署**：打包为WAR包部署到Tomcat等Web容器中

### 部署步骤（JAR包方式）

#### 1. 准备工作

- 安装JDK 1.8+：`sudo apt install openjdk-8-jdk`（Ubuntu系统）
- 安装MySQL 5.7+：`sudo apt install mysql-server`（Ubuntu系统）
- 安装Redis 5.0+：`sudo apt install redis-server`（Ubuntu系统）
- 创建应用目录：`mkdir -p /app/zhdj`

#### 2. 数据库准备

1. 创建数据库和用户

   ```sql
   CREATE DATABASE party_build_db CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
   CREATE USER 'zhdj'@'%' IDENTIFIED BY 'YourStrongPassword';
   GRANT ALL PRIVILEGES ON party_build_db.* TO 'zhdj'@'%';
   FLUSH PRIVILEGES;
   ```

2. 导入初始化SQL脚本

   ```bash
   mysql -u zhdj -p party_build_db < init.sql
   ```

#### 3. 打包应用

在项目根目录下执行打包命令：

```bash
mvn clean package -DskipTests -DincludeSystemScope=true
```

打包完成后，在target目录下可以找到生成的JAR文件：`ZHDJ-0.0.1.jar`

#### 4. 配置生产环境

1. 创建配置目录和文件

   ```bash
   mkdir -p /app/zhdj/config
   touch /app/zhdj/config/application-prod.yml
   ```

2. 编辑生产环境配置文件 `/app/zhdj/config/application-prod.yml`

   ```yaml
   server:
     port: 8062
     tomcat:
       max-connections: 10000
   
   spring:
     datasource:
       druid:
         url: jdbc:mysql://localhost:3306/party_build_db?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai
         username: zhdj
         password: YourStrongPassword
         initial-size: 5
         min-idle: 5
         max-active: 50
     redis:
       host: localhost
       port: 6379
       password: YourRedisPassword
       timeout: 10000
   
   appconfig:
     uploadfile-url: /app/data/zhdj/sitefile
     desKey: YourDesKey
     payCert-url: /app/data/zhdj/certs
     fileMgr-url: /app/data/zhdj/sitefile/docs
     
   logging:
     file:
       path: /app/logs/zhdj
       max-size: 10MB
       max-history: 30
   ```

3. 创建文件存储目录

   ```bash
   mkdir -p /app/data/zhdj/sitefile
   mkdir -p /app/data/zhdj/certs
   mkdir -p /app/data/zhdj/sitefile/docs
   mkdir -p /app/logs/zhdj
   ```

#### 5. 部署应用

1. 将打包好的JAR文件复制到服务器

   ```bash
   cp target/ZHDJ-0.0.1.jar /app/zhdj/
   ```

2. 创建启动脚本 `/app/zhdj/start.sh`

   ```bash
   #!/bin/bash
   
   java -jar \
     -Xms512m -Xmx1024m \
     -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=256m \
     -Dspring.profiles.active=prod \
     -Dspring.config.location=/app/zhdj/config/ \
     /app/zhdj/ZHDJ-0.0.1.jar >> /app/logs/zhdj/startup.log 2>&1 &
   
   echo $! > /app/zhdj/app.pid
   ```

3. 赋予执行权限

   ```bash
   chmod +x /app/zhdj/start.sh
   ```

4. 创建停止脚本 `/app/zhdj/stop.sh`

   ```bash
   #!/bin/bash
   
   PID=$(cat /app/zhdj/app.pid)
   kill -15 $PID
   rm -f /app/zhdj/app.pid
   ```

5. 赋予执行权限

   ```bash
   chmod +x /app/zhdj/stop.sh
   ```

6. 启动应用

   ```bash
   cd /app/zhdj
   ./start.sh
   ```

#### 6. 配置Nginx反向代理（可选）

1. 安装Nginx：`sudo apt install nginx`（Ubuntu系统）

2. 创建Nginx配置文件 `/etc/nginx/conf.d/zhdj.conf`

   ```nginx
   server {
       listen 80;
       server_name your-domain.com;
       
       access_log /var/log/nginx/zhdj_access.log;
       error_log /var/log/nginx/zhdj_error.log;
       
       location / {
           proxy_pass http://localhost:8062;
           proxy_set_header Host $host;
           proxy_set_header X-Real-IP $remote_addr;
           proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
           proxy_set_header X-Forwarded-Proto $scheme;
       }
       
       # 静态资源缓存配置
       location ~* \.(js|css|png|jpg|jpeg|gif|ico)$ {
           proxy_pass http://localhost:8062;
           proxy_set_header Host $host;
           expires 7d;
           add_header Cache-Control "public, max-age=604800";
       }
   }
   ```

3. 重新加载Nginx配置：`sudo nginx -s reload`

### 配置HTTPS（可选）

1. 获取SSL证书（例如通过Let's Encrypt）

2. 更新Nginx配置

   ```nginx
   server {
       listen 80;
       server_name your-domain.com;
       return 301 https://$server_name$request_uri;
   }
   
   server {
       listen 443 ssl;
       server_name your-domain.com;
       
       ssl_certificate /path/to/cert.pem;
       ssl_certificate_key /path/to/key.pem;
       ssl_protocols TLSv1.2 TLSv1.3;
       ssl_ciphers HIGH:!aNULL:!MD5;
       
       # 其他配置同上...
   }
   ```

### 系统监控与维护

#### 1. 日志管理

- 应用日志路径：`/app/logs/zhdj/`
- 使用 `tail -f /app/logs/zhdj/startup.log` 查看启动日志
- 使用 `tail -f /app/logs/zhdj/spring.log` 查看运行日志

#### 2. 性能监控

建议使用如下工具进行系统监控：

- **JVM监控**：JConsole、VisualVM、Arthas
- **应用监控**：Spring Boot Actuator、Prometheus、Grafana
- **服务器监控**：Zabbix、Nagios、Prometheus

#### 3. 数据备份

定期备份数据库：

```bash
# 创建备份脚本 /app/zhdj/backup.sh
#!/bin/bash
BACKUP_DIR="/app/backup/zhdj"
DATE=$(date +%Y%m%d_%H%M%S)
mkdir -p $BACKUP_DIR
mysqldump -u zhdj -p'YourStrongPassword' party_build_db > $BACKUP_DIR/party_build_db_$DATE.sql
```

添加到crontab定时执行：

```
0 2 * * * /app/zhdj/backup.sh >> /app/logs/zhdj/backup.log 2>&1
```

### 常见部署问题

1. **端口被占用**
   - 检查端口是否被其他进程占用：`netstat -nltp | grep 8062`
   - 如果有占用，可以修改配置文件中的端口或终止占用端口的进程

2. **内存不足**
   - 调整JVM参数：减小 `-Xms` 和 `-Xmx` 值
   - 增加服务器内存
   - 监控JVM内存使用情况，调整GC策略

3. **文件权限问题**
   - 确保应用运行用户对相关目录有读写权限
   - 使用 `chown -R` 和 `chmod -R` 命令调整权限

4. **数据库连接问题**
   - 检查MySQL服务是否运行：`systemctl status mysql`
   - 检查数据库用户权限
   - 检查防火墙设置

5. **启动失败**
   - 查看日志文件排查错误
   - 检查配置文件格式是否正确
   - 检查JDK版本是否兼容 


## 系统版本说明

智慧党建系统提供三个不同版本，满足不同场景的需求：

### 开源版

- **获取方式**：直接从本仓库下载使用
- **特点**：包含基础党建功能，完全开源，适合学习和小型党组织内部使用
- **协议**：AGPL-3.0开源协议，任何修改和网络分发需遵循该协议要求，商用请购买商用版本
- **功能**：基础党组织管理、党员管理、党费管理、活动管理等核心功能

### 商用版

- **获取方式**：请扫码添加客服微信咨询
- **特点**：功能全面、稳定性高、持续更新、提供技术支持
- **包含功能**：
  - 开源版全部功能
  - 高级统计分析功能
  - 更多模板与主题
  - 多端适配优化
  - 性能优化
  - 安全性增强
  - 专业技术支持

### 信创版

- **获取方式**：请扫码添加客服微信咨询
- **特点**：符合信创标准要求，支持国产化环境
- **适用场景**：政府、事业单位等对信创要求较高的组织
- **技术支持**：提供专业的部署、适配和运维服务

## 系统演示/商用咨询

请扫码添加客服微信获取演示地址和系统详细资料。

![](./images/kf.png)

如果您想基于智慧党建进行商业化交付或定制开发服务，我们提供有偿的技术服务支持，合作模式不限，欢迎沟通！

公司官网地址： <a href="https://www.haishi.net.cn/">https://www.haishi.net.cn</a>

联系客服获取专业回答。


## 使用须知

1. 本项目开源版遵循AGPL-3.0协议，修改代码后需要以相同协议开源。

2. 商用版和信创版需获得版权所有者的授权才能使用。

3. 未经允许本项目代码不允许二次出售。

<hr/>

![](./images/gsjj.png)