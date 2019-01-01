<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main Page</title>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">
</script>
<style>
	ul li{
		width:60px;
    	float:left;
    	list-style:none;
	}
</style>
<script>
function userbook(){
	$.get("UserBook",function(data){
		var x = JSON.parse(data);
		if (x.num>0){
			var cr = x.booking[0].crid;
			var w = x.booking[0].weekno;
			var d = x.booking[0].dayno;
			var t = x.booking[0].timeNo;
			$("#a").html(cr+"  第"+w+"周 &nbsp "+ "星期"+d+"&nbsp&nbsp第"+t+"小节 ");
		}
		else{
			$("#a").html("您当前没有正在审核的预约");
		}		
	});
}
function addlink(){
	$("li a").each(function(){
		var x = $(this).text();
		$(this).attr('href','classroom.jsp?id='+x)
	});
}
$(document).ready(function(){
	userbook();	
	addlink();
});
</script>

</head>
<body>
	<p>您好，您现在可以看到您的预约信息和四教的教室列表</p>
	<p>如果您想要预约教室，您需要点开该教室的详细信息</p>
	<p>如果您想要删除自己的预约，点击后面的删除按钮就好</p>
	<p>感谢您的使用！</p>
	<br/>
	<p>审核中</p>
	<p id= "a"></p>
	<br/>
	<p>一楼</p>
	<ul>
		<li><a>4101</a></li>
		<li><a>4102</a></li>
		<li><a>4103</a></li>
		<li><a>4104</a></li>
		<li><a>4105</a></li>
		<li><a>4106</a></li>
	</ul>
	<br/>
	<p>二楼</p>
	<ul>
		<li><a>4201</a></li>
		<li><a>4202</a></li>
		<li><a>4203</a></li>
		<li><a>4204</a></li>
		<li><a>4205</a></li>
		<li><a>4206</a></li>
	</ul>
	<br/>
	<p>三楼</p>
	<ul>
		<li><a>4301</a></li>
		<li><a>4302</a></li>
		<li><a>4303</a></li>
		<li><a>4304</a></li>
		<li><a>4305</a></li>
		<li><a>4306</a></li>
	</ul>
</body>
</html>