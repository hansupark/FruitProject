<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "com.fruit.vo.FruitSeller" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	ArrayList<FruitSeller> list = (ArrayList<FruitSeller>) request.getAttribute("sellerList");
	for(FruitSeller fs : list)
	{
		out.println("sellerId : " + fs.getId() + " appleCount : " + fs.getAppleCount() + " applePrice : " + fs.getApplePrice());
		out.println("<br>");
	}
%>
${error}
<form action = "BuyerBuyFruit.do" method = "post">
sellerId : <input type = "text" name = "sellerId"><br>
AppleCount : <input type = "text" name = "appleCount"><br>
<input type = "submit" value = "buy">
<a href = "fruitBuyerMenu.jsp">go back</a>
</form>
</body>
</html>