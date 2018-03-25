
package com.wemall.core.tools;

import com.alibaba.druid.filter.config.ConfigTools;

/**
阒块噷宸村反鏁版嵁搴揿姞瀵嗙畻娉曪紝灏嗘暟鎹簱瀵嗙爜鏄庢枃镟挎崲钬渞2vv5fcp钬濓紝杩愯main鏂规硶鍚庡皢镓揿嵃镄勫瘑鏂囧～鍦╦dbc.properties鍐?
*/
@SuppressWarnings("all")
public class DruidDecrypt {
	public static void main(String[] args){
		try {
			ConfigTools configTools = new ConfigTools ();
            System.out.println(configTools.encrypt("mysql"));
		//	System.out.println(configTools.encrypt("r2vv5fcp"));
		} catch (Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
