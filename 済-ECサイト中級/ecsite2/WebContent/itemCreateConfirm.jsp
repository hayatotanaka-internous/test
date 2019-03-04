<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset =utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<title>ITEMCREATE確認画面</title>

<style type="text/css">
body {
	margin: 0;
	padding: 0;
	line-height: 1.6;
	letter-spacing: 1px;
	font-family: Verdana, Helvetica, sans-serif;
	font-size: 12px;
	color: #333;
	background: #fff;
}

table {
	text-align: center;
	margin: 0 auto;
}

#top {
	width: 780px;
	margin: 30px auto;
	border: 1px solid #333;
}

#header {
	width: 100%;
	height: 80px;
	background-color: black;
}

#main {
	width: 100%;
	height: 50px;
	text-align: center;
}

#footer {
	width: 100%;
	height: 80px;
	background-color: black;
	clear: both;
}
</style>

</head>
<body>
	<div id="header">
		<div id="pr"></div>
	</div>
	<div id="main">
		<div id="top">
			<p>商品登録確認</p>
		</div>
	</div>
	<div>
		<h3 style="text-align: center">登録は以下でよろしいですか？</h3>
		<table>
			<s:form action="ItemCreateCompleteAction">
				<tr id="box">
					<td><label>アイテム名：</label></td>
					<td><s:property value="itemName" escape="false" /></td>
				</tr>
				<tr id="box">
					<td><label>アイテム価格：</label></td>
					<td><s:property value="itemPrice" escape="false" /></td>
					<td><label>円</label></td>
				</tr>
				<tr id="box">
					<td><label>アイテム在庫量：</label></td>
					<td><s:property value="itemStock" escape="false" /></td>
					<td><label>個</label></td>
				</tr>

				<tr>
					<td><s:submit value="完了" /></td>
				</tr>
			</s:form>
		</table>
	</div>
	<div id="footer">
		<div id="pr"></div>
	</div>
</body>
</html>