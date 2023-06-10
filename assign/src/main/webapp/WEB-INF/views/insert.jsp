<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert Data</title>
</head>
<body>
    <h1>Insert Data</h1>
    
    <form action="insert.jsp" method="POST">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>
        
        <label for="address">Address:</label>
        <input type="text" id="address" name="address" required><br>
        
        <label for="city">City:</label>
        <input type="text" id="city" name="city" required><br>
        
        <label for="country">Country:</label>
        <input type="text" id="country" name="country" required><br>
        
        <label for="pincode">Pincode:</label>
        <input type="text" id="pincode" name="pincode" required><br>
        
        <label for="score">SAT Score:</label>
        <input type="number" id="score" name="score" required><br>
        
        <input type="submit" value="Submit">
    </form>
</body>
</html>
