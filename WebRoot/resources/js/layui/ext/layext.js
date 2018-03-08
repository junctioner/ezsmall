/*Date格式化*/
Date.prototype.format = function (fmt) { // 
	var o = {
		"M+": this.getMonth() + 1, //月份 
	    "d+": this.getDate(), //日 
	    "h+": this.getHours(), //小时 
	    "m+": this.getMinutes(), //分 
	    "s+": this.getSeconds(), //秒 
	    "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
	    "S": this.getMilliseconds() //毫秒 
	};
	if (/(y+)/.test(fmt)){
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	}
	for (var k in o){
	    if (new RegExp("("+k+")").test(fmt))
	    	fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
	}
	return fmt;
}

/*标签类型*/
var pfun = {
	setValue : function(obj,value){
		obj.is("input") ? obj.val(value) : obj.text(value);
	},
	setRadioValue : function(obj,value,name){
		if(obj.is("input")){//单标签除img外
			$("input[name='"+name+".id']").each(function(){
				if(value[name].id == $(this).val()){
					$(this).attr("checked","checked");
					return;//跳出each循环
				}
			});
		}else{//双标签
			obj.text(value[name].dictName);
		}
	},
	setCheckboxValue : function(obj,value,name){
		if(obj.is("input")){
			for(var i in value[name]){
				$("input[name='"+name+"id']").each(function(){
					if(value[name][i].id == $(this).val()){
						$(this).attr("checked","checked");
					}
				});
			}
		}else{
			var temp = "";
			for(var i in value[name]){
				temp += value[name][i].dictName;
			}
			obj.text(temp);
		}
	},
	setSelectValue : function(obj,value,name){
		if(obj.is("input")){
			$("select[name='"+name+".id'] option").each(function(){
				if(value[name].id == $(this).val()){
					$(this).attr("selected","selected");
					return;//跳出each循环
				}
			});
		}else{
			obj.text(value[name].dictName);
		}
	}
} 

layui.define(function(exports){
	var utils = {
		//简单表单赋值
		initForm:function(entity){
			//表单赋值
			for(var p in entity){
				if(typeof(entity[p])!="function" && $("#form-"+p)){
					$("#form-"+p).val(entity[p]);
				}
			}
		},
		//复杂表单赋值
		assign : function(obj){
			for(var name in obj){
				var _this = $("#form-"+name);
//				if(_this.length>0){ 
//				    alert(name + " is exist.");  
//				}else{  
//					alert(name + " not be found.");  
//					continue;
//				} 
				if(_this.length <= 0) continue;
				if(typeof(obj[name]) == "object"){
					//日期
					if(_this.attr("time")){
						pfun.setValue(_this,new Date(obj[name]["time"]).format(_this.attr("time")));
					}else if(_this.attr("formtype")){
						//单选
						if(_this.attr("formtype") == "radio"){
							pfun.setRadioValue(_this,obj,name);
						//复选
						}else if(_this.attr("formtype") == "checkbox"){
							pfun.setCheckboxValue(_this,obj,name);
						//下拉（单选）
						}else if(_this.attr("formtype") == "select"){
							pfun.setSelectValue(_this,obj,name);
						}
					}else{
						//一般对象，只允许套一层
						var parseAttr = _this.attr("parse");
						pfun.setValue(_this,obj[name][parseAttr]);
					}														
				}else{
					//非对象
					pfun.setValue(_this,obj[name]);
				}
				
			}
		}
	}
	exports('utils', utils);
});

/**
 * 定义表格相关属性
 */
layui.define(function(exports){
	var table = {
		columns:[], //保存页面显示的表头
		options:{}, //与表格相关的参数options/data
		data:{},
		requestParam:{},
		init:function(param){
			var me = this;
			me.options = param;
			//初始化解析表格头部信息
			if(me.columns.length==0){
				var columns = $(param.tableName+">thead>tr>th");
				var column;
				for(var q=0,w=columns.length;q<w;q++){
					column = {};
					column.name = $(columns[q]).attr("name");
					column.display = $(columns[q]).css("display");
					if($(columns[q]).attr("onClick")) column.onClick = $(columns[q]).attr("onClick");
					if($(columns[q]).attr("formatter")) column.formatter = $(columns[q]).attr("formatter");
					if($(columns[q]).attr("dict")) column.dict = $(columns[q]).attr("dict");
					if($(columns[q]).attr("time")) column.time = $(columns[q]).attr("time");
					if($(columns[q]).attr("parse")) column.parse = $(columns[q]).attr("parse");
					me.columns.push(column);
				}
			}
			if(param.page){//如果分页初始化分页数据
				var pageOptions = {page:1,rows:10};
				$.extend(pageOptions ,me.options.pageOptions);
				$.extend(me.options,{pageOptions:pageOptions});
			}
			if(param.url){
				me.load({});
			}
			$(param.tableName).data("grid",me);
		},
		load: function(param){
			var me = this;
			$.extend(me.options,param);
			//加载表格数据
			var requestParam = {};
			$.extend(requestParam , me.options.pageOptions ,me.requestParam ,param.data);
			$.extend(me.requestParam,requestParam);
			$.extend(requestParam, me.requestParam ,param.filter);
			$.ajax({
				url:me.options.url,
				type:"post",
				dataType:"json",
				data:requestParam,
				success:function(data){
					if(data.code == "success"){
						me.data = data.data;
						var pages = data.data.data;
						var tr,td;
						$(me.options.tableName+">tbody").empty();
						for(var i=0,j=pages.length;i<j;i++){
							tr = $("<tr></tr>");
							var row = pages[i];
							for(var m=0,n=me.columns.length;m<n;m++){
								var field = me.columns[m];
								if(field.name == "checkbox"){
									td = $("<td></td>");
									td.html("<input class='selectClass' type='checkbox' name='selectbox'/>");
									tr.append(td);
								}else{
									td = $("<td style='display:"+field.display+";'></td>");
									if(field.name == "index"){
										td.text(i);
									}else{
										var val = row[field.name];
										if(val!=null && val != undefined) td.text(val);
									}
									if(field.onClick){
										td.html("<a class='a_btn_td' href='javascript:void(0);' onclick='"+field.onClick+"("+i+");' style='color:#3D71B5;'>"+td.text()+"</a>")
									}
									if(field.formatter){
										var formatter = eval(field.formatter);
										td.html(formatter(row[field.name],row));
									}
									if(field.parse){
										var value = field.parse;
										if(field.dict)
											td.html(row[field.name][value].dictName);
										else
											td.html(row[field.name][value]);
									}
									if(field.dict && !field.parse){
										td.html(row[field.name].dictName);
									}
									if(field.time){
										td.html(new Date(row[field.name].time).format(field.time));
									}
									tr.append(td);
								}
							}
							$(me.options.tableName+">tbody").append(tr);
							
							$(me.options.tableName+" .selectClass").change(function(){
								if($(this).get(0).checked){
									var mm = $(this).get(0);
									if(me.options.single){
										$(me.options.tableName + " .selectClass").each(function(){
											if($(this).get(0) != mm){
												$(this).get(0).checked = false;
												$(this).parent().parent().css({"background-color":"#fff","color":"#353535"});
											}
										});
									}
									$(this).parent().parent().css({"background-color":"#34A8FF","color":"white"});
								}else{
									$(this).parent().parent().css({"background-color":"#fff","color":"#353535"});
								}
							});
							
						}
					}
					if(me.options.page){
						me.showPageBar();
					}
					if($("pagebar-"+me.options.tableName)){
						var pagecount = me.data.total%me.options.pageOptions.rows>0?parseInt(me.data.total/me.options.pageOptions.rows)+1:parseInt(me.data.total/me.options.pageOptions.rows);
						layui.laypage({
						    cont: "pagebar-"+me.options.tableName,
						    pages: pagecount,//总页数
						    groups: 8,//连续显示条数
						    first: false,
						    curr:me.requestParam.page,
						    last: false,
						    jump: function(object, first){
						      if(!first){
						    	  me.load({data:{page:object.curr}});
						      }
						    }
						});
					}
				}
			});
		},
		getSelected:function(){
			var me = this;
			var selected = [];
			$(me.options.tableName+" .selectClass:checked").each(function(){
				selected.push(me.data.data[$(this).parent().next().text()]);
			});
			return selected;
		},
		showPageBar:function(){
			var me = this;
			if(me.options.page){
				var pagebar = $('<div id="pagebar-'+me.options.tableName+'"></div>');
				$(me.options.tableName).after(pagebar);
				var pagecount = me.data.total%me.options.pageOptions.rows>0?parseInt(me.data.total/me.options.pageOptions.rows)+1:parseInt(me.data.total/me.options.pageOptions.rows);
				layui.laypage({
				    cont: "pagebar-"+me.options.tableName,
				    pages: pagecount,//总页数
				    groups: 8,//连续显示条数
				    first: false,
				    last: false,
				    jump: function(object, first){
				      if(!first){
				    	  me.load({data:{page:object.curr}});
				      }
				    }
				});
				me.options.page = false;
			}
		}
	};
	exports('table', table);
});