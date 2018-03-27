package com.wemall.manage.admin.tools;

import java.util.List;

import org.springframework.stereotype.Component;

import com.wemall.core.tools.MapTools;
import com.wemall.core.tools.bean.ColumnEc;

@Component
public class ColumnTool {
  public boolean getChek(String key,String json){
	  boolean bool = false;
	  List<ColumnEc> columnEcs = MapTools.getColumnStr(json);
	  if(columnEcs!=null){
		  for(ColumnEc columnEc:columnEcs){
			  if(columnEc.getRemarkValue()!=null&&!"".equals(columnEc.getRemarkValue())&&columnEc.getRemarkValue().indexOf(key)!=-1){
				  bool = true; 
				  break;
			  }
		  }
	  }
	  return bool;
  }
}
