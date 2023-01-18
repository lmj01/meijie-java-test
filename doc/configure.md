# 配置说明 

# 功能点

2023-01-09
增加pdf的指定宽高
http://localhost:9090/pdf?type=bagLabel

2022-08-04
配置安全属性
禁用自动配置安全后，出现不能启动的机制，是因为SecurityFilterAutoConfiguration问题
itext的字体问题

2022-08-03
配置messageresource时默认的字符编码不一样
增加一个portable pdf

2022-08-02
配置messageresource，Java的i18n
增加思源字体显示中文，直接在GitHub上下载

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

