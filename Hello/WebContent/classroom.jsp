<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CLASSROOM</title>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">
</script>
</head>
<body>
<script src="classroom.js"></script>
<input type="hidden" value="<%=request.getParameter("id")%>" id='CID'/>
<h3></h3>

<p>2020-2021秋季</p>
<p>
	第<select id="week"></select>周<button>确认</button>
</p>


<table border="1" width="600" height="300">
<tr class="weekday">
<td>一</td><td>二</td><td>三</td><td>四</td><td>五</td><td>六</td><td>七</td>
</tr>
<tr class="period" >
<td></td><td></td><td></td><td></td><td></td><td></td><td></td>
</tr>
<tr class="period">
<td></td><td></td><td></td><td></td><td></td><td></td><td></td>
</tr>
<tr class="period">
<td></td><td></td><td></td><td></td><td></td><td></td><td></td>
</tr>
<tr class="period">
<td></td><td></td><td></td><td></td><td></td><td></td><td></td>
</tr>
<tr class="period">
<td></td><td></td><td></td><td></td><td></td><td></td><td></td>
</tr>
<tr class="period">
<td></td><td></td><td></td><td></td><td></td><td></td><td></td>
</tr>
</table>
<p id="user_select">&nbsp;</p>
<button id="submit">提交预约</button>

</body>
</html>