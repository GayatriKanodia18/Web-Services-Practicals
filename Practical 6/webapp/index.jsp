<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>calculator</title>
</head>

<body>

<h1>soap based calculator</h1>

<form method="post" action="calculate">

    numb1:<br>
    <input type="number" name="num1" required>
    <br>

    numb2:<br>
    <input type="number" name="num2" required>
    <br>

    operation<br>

    <select name="operation">
        <option value="add">addition</option>
        <option value="subtract">subtraction</option>
        <option value="multiply">multiplication</option>
        <option value="divide">division</option>
    </select>

    <input type="submit" value="calculate">

</form>

<%
    String result = (String) request.getAttribute("result");

    if (result != null) {
%>

<hr>

<h2>result=<%=result%></h2>

<%
    }
%>

</body>
</html>
