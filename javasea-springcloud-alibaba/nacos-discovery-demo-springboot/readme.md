## 安装nacos：
### 单机：
http://www.iocoder.cn/Nacos/the-tutorial/?self
### 集群：
http://www.iocoder.cn/Nacos/install/?self

### 配置mysql数据库(默认是内置数据库，最好修改)
* conf/nacos-mysql.sql脚本用来初始化数据库
* conf/application.properties添加数据库配置：
```sql
# 数据源为 MySQL
spring.datasource.platform=mysql
# 数据源的数量。因为这里我们只配置一个数据源，所以设置为 1。
db.num=1
# 第 0 个数据源的配置
db.url.0=jdbc:mysql://127.0.0.1:3306/nacos-example?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true
# 数据库的账号密码
db.user=root
db.password=
```

### 服务器开通端口：
  [root@zhirui-base bin]# firewall-cmd --state
  running
  [root@zhirui-base bin]# firewall-cmd --zone=public --add-port=8848/tcp --permanent
  success
  [root@zhirui-base bin]# firewall-cmd --reload
  success
  [root@zhirui-base bin]#

### 启动服务：
sh bin/startup.sh -m standalone

测试：
ConsumerController：
模拟消费者
ProviderController：
模拟提供者
访问：http://localhost:8080/consumer/demo，会请求到provider的接口返回的数据
参考：http://www.iocoder.cn/Spring-Boot/registry-nacos/?self
