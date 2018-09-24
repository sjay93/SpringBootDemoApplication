<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Login Form</title>
    </head>
    <body>
        <form action="/authenticateUser" method="post">
            <div>
                <h2>Login Page</h2>
                <h1>Please Provide your Credentials here</h1>
                <br>
                <div style="margin-top: 20px;">
                    User Name
                </div>
                <div style="margin-top: 20px;">
                    <input type="text" name="userName" class="form-login" title="UserName" value=""/>
                </div>
                <div>Password</div>
                <div>
                    <input type="password" name="password" class="form-login" title="password" value=""/>
                </div>
                <br/>
                New User?
                <a href="/register" style="margin-left: 30px; color: orange;">Register Here</a>
                <br><br>
                <input type="submit" value="Login" style="margin-left:100px;"/>
            </div>
        </form>
    </body>
</html>