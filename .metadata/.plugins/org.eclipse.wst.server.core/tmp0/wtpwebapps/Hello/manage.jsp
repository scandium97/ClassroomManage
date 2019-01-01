<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ManagementPage</title>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">
</script>
</head>
<body>
<script src="manage.js"></script>
<h3>等候审核的申请</h3>
<table border="1" id="waiting">
</table>

<p id ="t"></p>
<h3>手动修改教室状态，需要先点击"查看状态"才能进行提交</h3>
<p>
选择<select id="cr"></select>教室，时间为<select id="week"></select> 周<select id="day"></select>
    第<select id="time"></select>大节
</p>
<p>状态：
<a id="state"></a>
</p>
<button id="query_state">查看状态</button>
<br/>
<p>修改方式<select id="update_method">
<option>空闲</option>
<option>有课</option>
</select>
</p>
<button id="update" >提交修改</button>
</body>
</html>