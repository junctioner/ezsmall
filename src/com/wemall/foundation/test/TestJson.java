package com.wemall.foundation.test;

import com.wemall.foundation.domain.virtual.TransContent;
import com.wemall.foundation.domain.virtual.TransInfo;
import java.io.PrintStream;
import org.nutz.json.Json;

public class TestJson {
    public static void main(String[] args) {
        String s = "{\"message\":\"ok\",\"status\":\"1\",\"state\":\"3\",\"data\":[{\"time\":\"2012-07-07 13:35:14\",\"context\":\"客户已签收\"},{\"time\":\"2012-07-07 09:10:10\",\"context\":\"离开 [北京石景山营业厅] 派送中，递送员[温]，电话[]\"},{\"time\":\"2012-07-06 19:46:38\",\"context\":\"到达 [北京石景山营业厅]\"},{\"time\":\"2012-07-06 15:22:32\",\"context\":\"离开 [北京石景山营业厅] 派送中，递送员[温]，电话[]\"},{\"time\":\"2012-07-06 15:05:00\",\"context\":\"到达 [北京石景山营业厅]\"},{\"time\":\"2012-07-06 13:37:52\",\"context\":\"离开 [北京_同城中转站] 发往 [北京石景山营业厅]\"},{\"time\":\"2012-07-06 12:54:41\",\"context\":\"到达 [北京_同城中转站]\"},{\"time\":\"2012-07-06 11:11:03\",\"context\":\"离开 [北京运转中心驻站班组] 发往 [北京_同城中转站]\"},{\"time\":\"2012-07-06 10:43:21\",\"context\":\"到达 [北京运转中心驻站班组]\"},{\"time\":\"2012-07-05 21:18:53\",\"context\":\"离开 [福建_厦门支公司] 发往 [北京运转中心_航空]\"},{\"time\":\"2012-07-05 20:07:27\",\"context\":\"已取件，到达 [福建_厦门支公司]\"}]}";
        TransInfo info = (TransInfo)Json.fromJson(TransInfo.class, s);
        System.out.println(info.getMessage());
        for (TransContent tc : info.getData())
            System.out.println(tc.getTime() + " " + tc.getContext());
    }
}




