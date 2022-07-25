# 

2022-07-25
配置一个前端
git submodule add https://github.com/lmj01/meijie-react.git  src/main/webapp/mjreact

2022-07-22
链接数据库

2022-07-21
https://spring.io/quickstart
参考上面执行

重新在线配置环境，
com.meijie
mjapp
增加依赖
spring session
spring web
spring data jpa
spring boot dev tools
spring security

依赖spring data jpa
会强制需要配置数据库，没有配置设置
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})

依赖spring security会自动产生登录框
在org.springframework.boot.autoconfigure.security.reactive包中
ReactiveUserDetailsServiceAutoConfiguration中自动配置了这个东西

调试完PDF的初始化

增加依赖
Rest Repositories

2022-07-20
加入依赖com.itext
创建两个基本的类

2022-07-19

使用[在线配置](https://start.spring.io/)创建一个Java maven工程
packaging is war
Java is 8
spring boot is 2.7.1

