<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Score</title>
</head>
<body>
    <h1>Update Score</h1>
    
    <form action="update" method="POST">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>
        
        <label for="score">New SAT Score:</label>
        <input type="number" id="score" name="score" required><br>
        
        <input type="submit" value="Update Score">
    </form>
</body>
</html>
