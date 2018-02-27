package com.wemall.manage.seller.tools;

import org.nutz.json.Json;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
<<<<<<< HEAD:src/com/wemall/manage/seller/tools/MenuTools.java
 * �˵��������
=======
 * 菜单工具组件
>>>>>>> 652716ebb6962ffc6f3e3cf166724fe7f4de983c:src/com/wemall/manage/seller/tools/MenuTools.java
 */
@Component
public class MenuTools {
    public List<Map> generic_seller_quick_menu(String menu_json){
        List list = new ArrayList();
        if ((menu_json != null) && (!menu_json.equals(""))){
            list = (List)Json.fromJson(List.class, menu_json);
        }

        return list;
    }
}




