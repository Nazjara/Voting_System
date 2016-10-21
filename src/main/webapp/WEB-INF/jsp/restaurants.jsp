<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Restaurants</title>
</head>
<body>
    <h2><a href="${pageContext.request.contextPath}/">Home</a></h2>
    <h3>Restaurant list</h3>
    <form method="post" action="results">
    <c:forEach items="${restaurants}" var="restaurant">
        <jsp:useBean id="restaurant" scope="page" type="com.nazjara.model.Restaurant"/>
        <h4>${restaurant.name} - ${restaurant.votes}<input type="radio"
                                                           name="answer" value="${restaurant.id}"></h4>
        <ul>
            <c:forEach items="${restaurant.menu}" var="meal">
                <jsp:useBean id="meal" scope="page" type="com.nazjara.model.Meal"/>
                    <li>${meal.name} - $${meal.price}</li>
            </c:forEach>
        </ul>
    </c:forEach>
            <input type="submit" name="submit" value="Submit">
        </form>
</body>
</html>
