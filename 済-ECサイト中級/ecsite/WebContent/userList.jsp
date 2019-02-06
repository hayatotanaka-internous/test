<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv ="Content-Type" content ="text/html; charset =utf-8" />
<meta http-equiv ="Content-Style-Type" content ="text/css" />
<meta http-equiv ="Content-Script-Type" content ="text/javascript" />
<meta http-equiv ="imagetoolbar" content ="no" />
<meta name ="description" content ="" />
<meta name ="keywords" content ="" />
<title>SHOWUSER画面</title>
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
margin:0 auto;
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
height:100%;
text-align:center;
}
#footer{
width:100%;
height:80px;
background-color:black;
clear:both;
}
#text-right{
display:inline-block;
text-align:right;
}
</style>
</head>
<body>
	<div id ="header">
		<div id ="pr"></div>
	</div>
	<div id ="main">
		<div id ="top">
			<p>ユーザー一覧</p>
		</div>
		<div>
			<s:if test ='userList == null'>
				<h3>ユーザー情報はありません。</h3>
			</s:if>
			<s:elseif test ='message == null'>
				<h3>ユーザー情報は以下になります。</h3>
				<table border ="1">
					<tr>
						<th>ID</th>
						<th>ログインＩＤ</th>
						<th>ログインＰＡＳＳ</th>
						<th>ユーザー名</th>
						<th>登録日</th>
						<th>更新日</th>
						<th>管理者</th>
					</tr>
					<s:iterator value ="userList">
					<tr>
						<td><s:property value ="id"/></td>
						<td><s:property value ="loginId"/></td>
						<td><s:property value ="loginPass"/></td>
						<td><s:property value ="userName"/><span>様</span></td>
						<td><s:property value ="insert_date"/></td>
						<td><s:property value="updated_date" /></td>
						<td><s:property value="adminFlg"/></td>
					</tr>
					</s:iterator>
				</table>
				<div>
				<br><p>一覧を削除する場合は<a href ='<s:url action ="UserListDeleteConfirmAction"/>'>こちら</a></p>
				</div>
			</s:elseif>
			<div id ="text-right">
				<p>管理者画面へ戻る場合は<a href ='<s:url action ="AdminAction"/>'>こちら</a></p>
			</div>
		</div>
	</div>
	<div id ="footer">
		<div id ="pr"></div>
	</div>
</body>
</html>