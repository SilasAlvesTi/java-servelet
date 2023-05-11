<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:url value="/entrada" var="linkEntradaServlet"/>
<fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy" var="dataAberturaEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="logout-parcial.jsp"></c:import>
	<form action="${ linkEntradaServlet }" method="POST">
		Nome: <input type="text" name="nome" value="${ empresa.nome }"/>
		Data Abertura: <input type="text" name="data" value="${ dataAberturaEmpresa }"/>
		<input type="hidden" name="id" value="${ empresa.id }">
		<input type="hidden" name="acao" value="AlteraEmpresa">
		<input type="submit"/>
	</form>
	
</body>
</html>