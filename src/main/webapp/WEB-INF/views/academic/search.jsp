<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
</head>
<body>
<h2>검색 목록</h2>
<table border="1" width="50%">
  <tr>
    <th>학번</th>
    <th>이름</th>
    <th>점수</th>
  </tr>
 
  <tr>
    <td>${list.ssn}</td>
    <td>${list.name}</td>
    <td>${list.score}</td>
  </tr>

</table>

</body>
</html>