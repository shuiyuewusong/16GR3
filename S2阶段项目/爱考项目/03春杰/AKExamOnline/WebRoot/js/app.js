//对Date的扩展，将 Date 转化为指定格式的String  
//月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，   
//年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)   
Date.prototype.Format = function (fmt) { //author: meizz   
	var o = {  
			"M+": this.getMonth() + 1, //月份   
			"d+": this.getDate(), //日   
			"H+": this.getHours(), //小时   
			"m+": this.getMinutes(), //分   
			"s+": this.getSeconds(), //秒   
			"q+": Math.floor((this.getMonth() + 3) / 3), //季度   
			"S": this.getMilliseconds() //毫秒   
	};  
	if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));  
	for (var k in o)  
		if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));  
	return fmt;  
}

/**
 * 倒计时，参数分钟
 * timer(pTime);
 * */
function timer(pTime){
	var intDiff = parseInt(pTime)*60;//倒计时总秒数量
	    window.setInterval(function(){
		    var day=0,
		        hour=0,
		        minute=0,
		        second=0;//时间默认值        
		    if(intDiff > 0){
			        day = Math.floor(intDiff / (60 * 60 * 24));
			        hour = Math.floor(intDiff / (60 * 60)) - (day * 24);
			        minute = Math.floor(intDiff / 60) - (day * 24 * 60) - (hour * 60);
			        second = Math.floor(intDiff) - (day * 24 * 60 * 60) - (hour * 60 * 60) - (minute * 60);
			}
		    if (minute <= 9) minute = '0' + minute;
		    if (second <= 9) second = '0' + second;
		    $('#hour_show').html('<s id="h"></s>'+hour+'时');
		    $('#minute_show').html('<s></s>'+minute+'分');
		    $('#second_show').html('<s></s>'+second+'秒');
		    intDiff--;
			if(intDiff == 60*10){
				//TODO 考试时间剩余10分钟
			}
			if(intDiff == 0){
				//TODO 考试结束，自动提交表单数据
			}
		    }, 1000);
} 

