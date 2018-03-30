# ezsmall

* 技术框架
    * springMVC + spring(2.5.6) + hibernate

* JDK 1.5~1.7
* 其它
	Velocity
	SpringSecurity
* 版本控制（代码管理）
	svn/git---gitee

* 代码路径约定

|代码类型|路径|
|--|--|
|模板文件：订单管理 |WebRoot/WEB-INF/templates/zh_cn/system/admin/blue/order|
|模板文件：管理后台|WebRoot/WEB-INF/templates/zh_cn/system/admin/blue/base|
|模板文件：买家中心|WebRoot/WEB-INF/templates/zh_cn/shop/default/buyer|
|模板文件：供应商中心|WebRoot/WEB-INF/templates/zh_cn/shop/default/seller|
|action：订单管理|com.wemall.manage.order.action|
|action：管理后台|com.wemall.manage.admin.action|
|action：买家中心|com.wemall.manage.buyer.action|
|action：供应商中心|com.wemall.manage.seller.action|
|服务类：service|com.wemall.foundation.service|
|数据操作类：dao|com.wemall.foundation.dao|
|实体对象：domain|com.wemall.foundation.domain|
