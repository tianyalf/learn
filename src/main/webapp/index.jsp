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
    <a href="account/findAll">测试springmvc查询</a>

    <h3>测试</h3>
<form action="account/save" method="post">
    姓名：<input type="text" name="name"/><br/>
    金额：<input type="text" name="money"/><br/>
    <input type="submit" value="保存"/>
</form>
</body>
</html>
