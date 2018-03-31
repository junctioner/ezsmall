/*错误提示框(自动隐藏)*/
/*参数为提示信息,背景颜色，字体颜色*/
function errorAlertByTM(message, bgc, color) {
	var $ErrorAlert = jQuery("<div id='TMByError'><h3>" + message + "</h3></div>");
	jQuery("body").append($ErrorAlert);
	jQuery("#TMByError").css({
		"transition": "opacity 1.5s",
		"background-color": bgc,
		"display": "inline-block",
		"text-align": "center",
		"opacity": "1",
		"border-radius": "10%",
		"position": "fixed",
		"left": "45%",
		"top": "45%",
		"color": color,
		"padding": "5px",
		"overflow": "auto"
	}).show();
	setTimeout(function() {
		jQuery("#TMByError").css("opacity", "0");
	}, 1500);
	setTimeout(function() {
		jQuery("#TMByError").remove();
	}, 3000);
}