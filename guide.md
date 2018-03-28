# 搭建环境

1. clone代码
   https://github.com/junctioner/ezsmall.git
2. 配置 Maven
      拷贝settings.xml
3. 熟悉代码结构
   * html
      * 目录 WebRoot/WEB-INF/template/zh_cn/
   * controller
      * 目录 com.wemall.manage.buyer.action
      * @Controller 相当于servlet
      * @RequestMapping 相当于请求路径
      * @RequestParam SpringMVC注入请求参数
      * ModelAndView 指定html页面和数据
    * server
      * com.wemall.foundation.service
    * dao
       * com.wemall.foundation.dao