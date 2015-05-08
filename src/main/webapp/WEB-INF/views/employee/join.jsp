<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
</head>
<body>
<h2>사원 등록 화면</h2>

<form action="/employee/join" method="post">
사원번호 : <input type="text" name="employeeId" value="${employee.employeeId}"><br>
포스트네임 : <input type="text" name="firstName" value="${employee.firstName}"><br>
라스트네임 : <input type="text" name="lastName" value="${employee.lastName}"><br>
급여 : <input type="text" name="salary" value="${employee.salary}"><br>
<input type="submit" value="등록">
</form>
<c:forEach var="error" items="${errors.allErrors}">
	<font color="red">${error.defaultMessage}</font><br>
</c:forEach>
</body>
</html>






