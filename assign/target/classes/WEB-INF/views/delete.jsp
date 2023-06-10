<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Record</title>
</head>
<body>
    <h1>Delete Record</h1>
    
    <form action="delete" method="POST">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>
        
        <input type="submit" value="Delete Record">
    </form>
</body>
</html>
