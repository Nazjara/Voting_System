<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <jsp:include page="fragments/headTag.jsp"/>
</head>
<body>
<h2><a href="${pageContext.request.contextPath}/">Home</a></h2>
<h3>User list</h3>
<a href="users/create">Add User</a>
<table border="1" cellpadding="8" cellspacing="0">
    <thead>
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Roles</th>
        <th>Registered</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <c:forEach items="${users}" var="user">
        <jsp:useBean id="user" scope="page" type="com.nazjara.model.User"/>
        <tr>
            <td><c:out value="${user.name}"/></td>
            <td><a href="mailto:${user.email}">${user.email}</a></td>
            <td>${user.roles}</td>
            <td><fmt:formatDate value="${user.registered}" pattern="dd-MMMM-yyyy"/></td>
            <td><a href="users/update?id=${user.id}">Update</a></td>
            <td><a href="users/delete?id=${user.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
