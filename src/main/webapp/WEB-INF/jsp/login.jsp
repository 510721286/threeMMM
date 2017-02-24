<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>登录</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="<%=basePath%>css/login.css">
<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/md5.js"></script>
<%-- <script type="text/javascript" src="<%=basePath%>js/login.js"></script> --%>
</head>
<body>
	<form action="SDK/saveMsg" method="post">
		<div>
			UserName:<input type="text" name="content" /> <br /> 
			status:<input type="text" name="status" /> <br /> 
			PassWord:<input type="text" name="type" /><br /> 
			from_userid:<input type="text" name="fromuserid" /><br /> 
			to_userid:<input type="text" name="touserid" /><br /> 
					<input type="submit" id="loginBtn" value="add"/>
		</div>
	</form>
</body>
</html>
