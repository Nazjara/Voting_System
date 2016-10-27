<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="fragments/headTag.jsp"/>
</head>
<body>
    <h2><a href="${pageContext.request.contextPath}/">Home</a></h2>
    <h3>Thanks for your vote!</h3>
    <h4>Your vote is for ${restaurant.name}. ${restaurant.name} has ${restaurant.users.size()} vote(s) now !</h4>
</body>
</html>
