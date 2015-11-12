<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
    <%@page import="control.*, persistence.*"%>
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>Login</title>  
</head>  
<body>  
    <form action="ControleLogin" method="post">  
        <fieldset style="width: 300px">  
            <legend> Login </legend>  
            <table>  
                <tr>  
                    <td>Usuario</td>  
                    <td><input type="text" name="username" required="required" /></td>  
                </tr>  
                <tr>  
                    <td>Password</td>  
                    <td><input type="password" name="userpass" required="required" /></td>  
                </tr>  
                <tr>  
                    <td><input type="submit" value="Login" /></td>  
                </tr>  
            </table>  
        </fieldset>  
    </form>  
</body>  
</html>  