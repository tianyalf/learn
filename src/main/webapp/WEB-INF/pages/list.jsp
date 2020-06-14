<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%--%>
    <%--String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";--%>
<%--%>--%>
<html>
<head>
    <%--<base href="<%=basePath%>">--%>
    <title>Title</title>
</head>
<body>
    <h2>查询所有的账户</h2>
<c:forEach items="${list}" var="account">
    ${account.name}
    ${account.money}
</c:forEach>
</body>
</html>
