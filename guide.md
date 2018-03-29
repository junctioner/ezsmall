# 搭建环境

1. clone代码
   https://github.com/junctioner/ezsmall.git
2. 配置 Maven
      拷贝settings.xml到C:\Users\${你的电脑用户名}\.m2\settings.xml
3. 熟悉代码结构
   * html
      * 目录 WebRoot/WEB-INF/template/zh_cn/
   * Controller
      * 目录 com.wemall.manage.buyer.action
      * @Controller 相当于servlet
      * @RequestMapping 相当于请求路径
      * @RequestParam SpringMVC注入请求参数
      * ModelAndView 指定html页面和数据
   * Server
      * com.wemall.foundation.service
   * Dao
       * com.wemall.foundation.dao
4. 其它
* [平台管理后台入口：http://localhost:8080/wemall2/admin/index.htm](http://localhost:8080/wemall2/admin/index.htm)