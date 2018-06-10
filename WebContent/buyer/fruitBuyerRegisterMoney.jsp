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
<form action = "FruitBuyerRegisterMoney.do" method = "post">
money : <input type = "text" name = "BuyerMoney"><br>
<input type = "submit" value = "register">
<a href = "fruitBuyerMenu.jsp">go back</a>
</form>
</body>
</html>