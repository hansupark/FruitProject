<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
${error}
<form action = "FruitSellerRegister.do" method = "post">
appleCount : <input type = "text" name = "appleCount"><br>
applePrice : <input type = "text" name = "applePrice"><br>
<input type = "submit" value = "Register">
<a href = "fruitSellerMenu.jsp">go back</a>
</body>
</html>