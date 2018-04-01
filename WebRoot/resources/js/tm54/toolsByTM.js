/*错误提示框(自动隐藏)*/
/*参数为提示信息,背景颜色，字体颜色,字体大小，完全消失时间*/
function errorAlertByTM(arg) {
	var number = /^[0-9]*[.]?[0-9]*$/;
	var size;
	//判断参数是否为集合，不是则改为空集合
	if(Object.prototype.toString.call(arg) != '[object Object]') {
		arg = {};
	}
	//判断是否有提示文字，没有则提示错误
	if(arg.message == null || arg.message == "" || arg.message == undefined) {
		arg.message = "错误";
	}
	//判断是否有正确的背景颜色，没有则默认#aaa
	if(arg.bgc == null || arg.bgc == "" || arg.bgc == undefined) {
		arg.bgc = "#aaa";
	}
	//判断是否有正确的背景颜色，没有则默认#aaa
	if(!number.test(arg.time)) {
		arg.time = 1.5;
	}
	//判断是否有正确的字体大小，没有则默认为中等(18px)
	if(arg.fontsize == "大") {
		size = 25;
	} else if(arg.fontsize == "小") {
		size = 15;
	} else {
		size = 18;
	}
	//如果第一次弹出则在body添加提示框
	if(jQuery("body").children(".TMByError").length<=0){
		var jQueryErrorAlert = jQuery("<div class='TMByError'><span>" + arg.message + "</span></div>");
	}
	jQuery("body").append(jQueryErrorAlert);
	//写入css样式
	jQuery(".TMByError").css({
		"transition": "opacity " + arg.time + "s",
		"background-color": arg.bgc,
		"display": "inline-block",
		"text-align": "center",
		"opacity": "1",
		"border-radius": "10%",
		"position": "fixed",
		"left": "45%",
		"top": "45%",
		"color": arg.color,
		"padding": "5px",
		"overflow": "auto",
		"font-size": size + "px",
		"font-weight": "bold"
	}).show();
	//arg.time/2秒后开始消失
	setTimeout(function() {
		jQuery(".TMByError").css("opacity", "0");
	}, arg.time * 500);
	//arg.time秒后完全消失
	setTimeout(function() {
		jQuery(".TMByError").hide();
	}, arg.time * 1000);
}