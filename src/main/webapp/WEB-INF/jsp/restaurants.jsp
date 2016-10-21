<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Restaurants</title>
</head>
<body>
    <h2><a href="${pageContext.request.contextPath}/">Home</a></h2>
    <h3>Restaurant list</h3>
    <c:forEach items="${restaurants}" var="restaurant">
        <jsp:useBean id="restaurant" scope="page" type="com.nazjara.model.Restaurant"/>
        <h4>${restaurant.name} - ${restaurant.votes}</h4>
        <ul>
            <c:forEach items="${restaurant.menu}" var="meal">
                <jsp:useBean id="meal" scope="page" type="com.nazjara.model.Meal"/>
                    <li>${meal.name} - $${meal.price}</li>
            </c:forEach>
        </ul>
    </c:forEach>
</body>
</html>
