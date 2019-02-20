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
<title>buyItem画面</title>

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

select {
	position: relative;
	top: -23px;
}

#top {
	width: 98%;
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
			<p>BuyItem</p>
		</div>
	</div>
	<div>
		<s:form action="BuyItemAction">
			<table>
				<tr>
					<td><span>商品名</span></td>


					<s:if test="session.buyItem_Name ==null">
						<td><span style="margin-left: 20px">商品はありません。</span></td>
					</s:if>
					<s:else>
						<td><s:property value="session.buyItem_Name" /><br></td>
					</s:else>
				</tr>
				<tr>
					<td><span>値段</span></td>
					<s:if test="session.buyItem_Price ==null">
						<td><s:property value="session.buyItem_Price" /><span>null</span>
						</td>
					</s:if>
					<s:else>
						<td><s:property value="session.buyItem_Price" /><span>円</span>
						</td>
					</s:else>
				</tr>

				<s:if test="session.buyItem_Stock <1">
					<tr>
						<td><span>在庫数</span></td>
						<td><span style="margin-left: 20px">在庫はありません。</span></td>
					</tr>
				</s:if>
				<s:else>

					<tr>
						<td><span>在庫数</span></td>
						<td><s:property value="session.buyItem_Stock" /><span>個</span>
						</td>
					</tr>
					<tr>
						<td><span>購入個数</span> <s:select name="count"
								list="itemStockList" selected="selected"></s:select></td>
					</tr>
					<tr>
						<td><span>支払い方法</span></td>
						<td><label><input type="radio" name="pay" value="1"
								checked="checked">現金払い</label> <label><input
								type="radio" name="pay" value="2">クレジットカード</label></td>
					</tr>
					<tr>
						<td><s:submit value="購入" /></td>
					</tr>
				</s:else>
			</table>
		</s:form>
		<div>
			<p>
				前画面に戻る場合は<a href='<s:url action ="GoHomeAction" />'>こちら</a>
			</p>
			<p>
				マイぺージは<a href='<s:url action ="MyPageAction" />'>こちら</a>
			</p>
		</div>
	</div>
	<div id="footer">
		<div id="pr"></div>
	</div>

</body>
</html>
