<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="fragments/headTag.jsp"/>
</head>
<body>
<section>
    <h2><a href="${pageContext.request.contextPath}/">Home</a></h2>
    <h3>${action == 'create' ? 'Create user' : 'Edit user'}</h3>
    <hr>
    <jsp:useBean id="user" type="com.nazjara.model.User" scope="request"/>
    <form method="post" action="users/createOrUpdate">
        <input type="hidden" name="id" value="${user.id}">
        <input type="hidden" name="roles" value="${user.roles}">
        <dl>
            <dt>Name:</dt>
            <dd><input type="text" value="${user.name}" name="name"></dd>
        </dl>
        <dl>
            <dt>Email:</dt>
            <dd><input type="email" value="${user.email}" name="email"></dd>
        </dl>
        <dl>
            <dt>Password:</dt>
            <dd><input type="password" value="${user.password}" name="password"></dd>
        </dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()">Cancel</button>
    </form>
</section>
</body>
</html>
