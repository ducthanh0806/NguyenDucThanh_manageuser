<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="view/css/style.css" rel="stylesheet" type="text/css" />
<title>ユーザ管理</title>
</head>
<body align="center">
<form action="login.do" method="post">
<center>
	<table class="tbl_input" cellpadding="4" cellspacing="0" width="400px">
		<tr>
			<th width="120px">&nbsp;</th><th></th>
		</tr>
		<tr>
			<th colspan="2" align="left">アカウント名およびパスワードを入力してください</th>
		</tr>
		
		<c:forEach items="${listError}" var="listError">  
			<tr>
				<td class="errMsg" colspan="2">&nbsp;<c:out value="${listError}"/></td>
			</tr>
        </c:forEach> 	
		<tr align="left">
					<td class="lbl_left">アカウント名:</td>
					<td align="left"><input class="txBox" type="text" name="loginName"
						value="<c:out value="${loginName}"/>" size="20"
						onfocus="this.style.borderColor='#0066ff';"
						onblur="this.style.borderColor='#aaaaaa';" /></td>
				</tr>
				<tr>
					<td class="lbl_left">パスワード:</td>
					<td align="left"><input class="txBox" type="password"
						name="password" value="" size="22"
						onfocus="this.style.borderColor='#0066ff';"
						onblur="this.style.borderColor='#aaaaaa';" /></td>
				</tr>
		<tr>
			<td></td>
			<td align="left">
				<input class="btn btn_wider" type="submit" value="ログイン" />				
			</td>
		</tr>
	</table>
	</center>
</form>
</body>
</html>