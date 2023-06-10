<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Get Rank</title>
</head>
<body>
    <h1>Get Rank</h1>
    
    <form action="getRank" method="GET">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>
        
        <input type="submit" value="Get Rank">
    </form>
    
    <c:if test="${not empty rank}">
        Rank: ${rank}
    </c:if>
</body>
</html>
