<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "com.fruit.vo.FruitSeller" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	FruitSeller seller = null;
	if(request.getAttribute("Inf") != null)
		 seller = (FruitSeller) request.getAttribute("Inf");
%>

AppleCount : <%=seller.getAppleCount() %> <br>
ApplePrice : <%=seller.getApplePrice() %><br>
Money : <%=seller.getMoney() %><br>
<a href = "fruitSellerMenu.jsp">go back</a>  
</body>
</html>