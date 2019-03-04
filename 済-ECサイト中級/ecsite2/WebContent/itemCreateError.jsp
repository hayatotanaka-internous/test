<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>UserCreate画面</title>

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
</style>

</head>
<body>
	<div id ="header">
		<div id ="pr"></div>
	</div>
	<div id ="main">
		<div id ="top"><p>商品登録</p></div>
	</div>
	<div id ="main">
		<h3>必要事項が抜けているか、使用できない文字が含まれています。</h3>
		<h3>もう一度入力してください。</h3>
	</div>
	<div>
		<s:if test ="errorMassage !=''">
			<s:property value ="errorMassage" escape ="false"/>
		</s:if>
		<s:form action ="ItemCreateConfirmAction">
			<table>
				<tr>
					<td>
						<label>アイテム名：</label>
					</td>
					<td>
						<input type ="text" name ="itemName" value =""/>
					</td>
				</tr>
				<tr>
					<td>
						<label>アイテム価格：</label>
					</td>
					<td>
						<input type ="text" name ="itemPrice" value =""/>
					</td>
					<td>
						<label>円</label>
					</td>
				</tr>
				<tr>
					<td>
						<label>アイテム在庫量：</label>
					</td>
					<td>
						<select name ="itemStock">
							<% for(int i=1; i<(50+1); i++){ %>
								<option value = <%=i %> selected ="selected"><%=i %></option>
							<% } %>
						</select>
					</td>
					<td>
						<label>個</label>
					</td>
				</tr>
				<s:submit value ="登録"/>
			</table>
		</s:form>
		<div>
			<p>管理者画面に戻る場合は<a href ='<s:url action ="AdminAction"/>'>こちら</a></p>
		</div>
	</div>
	<div id ="footer">
		<div id ="pr"></div>
	</div>
</body>
</html>