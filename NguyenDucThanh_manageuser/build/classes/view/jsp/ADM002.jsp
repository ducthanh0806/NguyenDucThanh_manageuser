<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="view/css/style.css" rel="stylesheet" type="text/css" />

<title>ユーザ管理</title>
</head>
<body>
	<!-- Begin vung header -->	
		<jsp:include page="header.jsp" />  
    <!-- End vung header -->	

<!-- Begin vung dieu kien tim kiem -->	
<form action="listUser.do" method="get" name="mainform">
	<table  class="tbl_input" border="0" width="90%"  cellpadding="0" cellspacing="0" >		
		<tr>
			<td>
				&nbsp;
			</td>
		</tr>
		<tr>
			<td>
				会員名称で会員を検索します。検索条件無しの場合は全て表示されます。 
			</td>
		</tr>
		<tr>
			<td width="100%">
				<table class="tbl_input" cellpadding="4" cellspacing="0" >
					<tr>
						<td class="lbl_left">氏名:</td>
						<td align="left">
						<input class="txBox" type="text" name="name" value="${ name }"
							size="20" onfocus="this.style.borderColor='#0066ff';"
							onblur="this.style.borderColor='#aaaaaa';" />
						</td>
						<td></td>
					</tr>
					<tr>
						<td class="lbl_left">グループ:</td>
						<td align="left" width="80px">
							<select name="group_id" >
								<option value="0">全て</option>
								 <c:forEach var="mst_group" items="${listMstGroup}">
								     <option value="${ mst_group.getGroupId() }"
								     	${ mst_group.getGroupId() == selectGroupId ? 'selected="selected"' : ''}	
								     > ${ mst_group.getGroupName() } 
								     </option>
								 </c:forEach>							
							</select>							
						</td>
						<td align="left">
							<input class="btn" type="button" value="検索" />
							<input class="btn btn_wider" type="button" value="新規追加" />							
						</td>
					</tr>
				</table>
			</td>
		</tr>		
	</table>
	<!-- End vung dieu kien tim kiem -->
</form>
	<!-- Begin vung hien thi danh sach user -->
	<table class="tbl_list" border="1" cellpadding="4" cellspacing="0" width="80%">
		<tr class="tr2">
			<th align="center" width="20px">ID</th>
			<th align="left">氏名 ▲▽</th>
			<th align="left">生年月日</th>
			<th align="left">グループ</th>
			<th align="left">メールアドレス</th>
			<th align="left" width="70px">電話番号</th>
			<th align="left">日本語能力▲▽</th>
			<th align="left">失効日▲▽</th>
			<th align="left">点数</th>
		</tr>
		<c:forEach  items="${listUserInfor}" var="userInfor">
			<tr>
			<td align="right">
				<c:out value="${fn:escapeXml(userInfor.getUserId())}"/>
			</td>
			<td>
				<c:out value="${fn:escapeXml(userInfor.getFullName())}"/>
			</td>
			<td align="center">
				<c:out value="${fn:escapeXml(userInfor.getBirthday())}"/>
			</td>
			<td>
				<c:out value="${fn:escapeXml(userInfor.getGroupName())}"/>
			</td>
			<td>
				<c:out value="${fn:escapeXml(userInfor.getEmail())}"/>
			</td>
			<td>
				<c:out value="${fn:escapeXml(userInfor.getTel())}"/>
			</td>
			<td>
				<c:out value="${fn:escapeXml(userInfor.getNameLevel())}"/>
			</td>
			<td align="center">
				<c:out value="${fn:escapeXml(userInfor.getEndDate())}"/>
			</td>
			<td align="right">
				<c:out value="${fn:escapeXml(userInfor.getTotal())}"/>
			</td>
		</tr>
		</c:forEach>
	</table>
	<!-- End vung hien thi danh sach user -->
	
	<!-- Begin vung paging -->
	123>
	<!-- End vung paging -->

	<!-- Begin vung footer -->
	<jsp:include page="footer.jsp" />  
	<!-- End vung footer -->

</body>

</html>