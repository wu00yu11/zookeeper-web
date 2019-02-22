# zookeeper-web
  1. h2 配置 :
   ```properties
   spring.datasource.platform=h2
   spring.datasource.schema=classpath:config/h2/schema.sql
   spring.datasource.data=classpath:config/h2/data.sql
  ```
  2. 配置
  ```properties
  #重试次数
  curator.retryCount=5
  #重试间隔时间
  curator.elapsedTimeMs=5000
  #zookeeper 地址
  curator.connectString=192.168.91.140:2181
  #session超时时间
  curator.sessionTimeoutMs=60000
  # 连接超时时间
  curator.connectionTimeoutMs=5000
  ```
