<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->


<!DOCTYPE html>
<html>
<head>
    <title>Login page</title>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="style.css" media="all"/>
    <link rel="stylesheet" type="text/css" href="demo.css" media="all"/>
</head>
<body>
<div class="container">
    <!-- freshdesignweb top bar -->
    <div class="freshdesignweb-top">
        <%--<a href="index.jsp" target="_blank">Home</a>--%>

        <img src="ttn.jpg" width="80" height="80">
        <div class="clr"></div>
    </div><!--/ freshdesignweb top bar -->
    <header>
        <h1><span>Login here</span></h1>
    </header>
    <div class="form">
        <form id="contactform" action="/Authenticate" method="post">
            <p class="contact"><label for="name"> USER NAMES</label></p>
            <input id="uname" name="name" placeholder="First and last name" required="" tabindex="1" type="text">


            <p class="contact"><label for="password">Password</label></p>
            <input type="password" id="upassword" name="pass" required="">


            <input class="buttom" name="submit" id="submitform" tabindex="5" value="Login" type="submit">
        </form>
    </div>
<br/>
    <h1 style="color: white;align-self: center;text-align: center">Sign Up here</h1>

    <div class="form">
        <form id="Signupform" action="/SignUp" method="post">
            <p class="contact"><label for="name"> USER NAME</label></p>
            <input id="name" name="uname" placeholder="First and last name" required="" tabindex="1" type="text">


            <p class="contact"><label for="password">Password</label></p>
            <input type="password" id="password" name="pass" required="">


            <input class="buttom" name="submit" id="submit" tabindex="5" value="Login" type="submit">
        </form>
    </div>

</div>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.2.2/jquery.form.min.js"
        integrity="sha384-FzT3vTVGXqf7wRfy8k4BiyzvbNfeYjK+frTVqZeNDFl8woCbF0CYG6g2fMEFFo/i"
        crossorigin="anonymous"></script>

<script>
    $(document).ready(function () {
        $('#Signupform').ajaxForm({
            success: function (msg) {
                alert(msg);
            },
            error: function (msg) {
                alert(msg);
            }
        });
    });
</script>
</body>
</html>


<!--<html>
<head>
<title>TODO supply a title</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<form action="logincontroller" method="post">
user name <input type="text" name="uname"/>
password <input type="password" name="pass"/>
<input type="submit" value="login"/>
</form>
</body>
</html>
-->
