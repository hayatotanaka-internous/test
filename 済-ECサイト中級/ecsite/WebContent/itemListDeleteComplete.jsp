<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta http-equiv ="Content-Script-Type" content ="text/javascript"/>
<meta http-equiv ="Content-Style-Type" content ="text/css"/>
<meta http-equiv ="imagetoolbar" content ="no"/>
<meta name ="description" content =""/>
<meta name ="keywords" content =""/>
<title>ITEMLISTDELETECOMPLETE画面</title>

<style type ="text/css">
body{
margin:0;
padding:0;
line-height:1.6;
letter-spacing:1px;
font-family:Verdana,Helvetica,sans-serif;
font-size:12px;
color:#333;
background:#fff;
}
table{
text-align:center;
margin:50px auto;
padding:0 50px 0 50px;
border:1px solid #333;
}
#top{
width:780px;
margin:30px auto;
border:1px solid #333;
}
#header{
width:100%;
height:80px;
background-color:black;
}
#main{
width:100%;
height:350px;
text-align:center;
}
th{
width:50%;
margin:0px auto;
padding:0 50px 0 50px;
text-align:center;
}
#footer{
width:100%;
height:80px;
background-color:black;
clear:both;
}
</style>
</head>
<body>
	<div id ="header">
		<div id ="pr">
		</div>
	</div>
	<div id ="main">
		<div id ="top">
			<p>商品削除完了画面</p>
		</div>
		<div>
			<h3>商品を削除しました。</h3>
		</div>
		<div>
			<p>管理者画面は<a href ='<s:url action ="AdminAction" />'>こちら</a></p>
		</div>
	</div>
	<div id ="footer">
		<div id ="pr">
		</div>
	</div>
</body>
</html>