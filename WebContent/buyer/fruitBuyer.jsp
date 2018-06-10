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
<form action = "FruitBuyerLogin.do" method = "post">
loginID : <input type = "text" name = "Buyer_ID"><br>
pwd : <input type = "password" name = "Buyer_PWD"><br>
<input type = "submit" value = "Login">
<a href = "../index.jsp">go back</a>
</body>
</html>