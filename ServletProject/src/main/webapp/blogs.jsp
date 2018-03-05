<%
    if(session.getAttribute("uname")==null){
        response.sendRedirect("http://localhost:8090/index.jsp");
    }else {
        %>

<html>
<head>
    <title>Title</title>
    <style>
        #header{
            text-align: center;
            color: white;
            background-color:darkblue;
            height: 30%;
            font-size: 300%;
        }
        #id1
        {
            margin-left: 0%;
            background-color:beige;
            margin-top: 1%;
            margin-right: 50%;
            position: absolute;
            border: 2px solid black;
            border-radius: 5px;
            width: 50%;
            height: 60%;
            color: black;
        }
        textarea
        {
            margin-left: 1%;
            width: 98%;
            height: 40%;
            margin-top: 2%;
        }
        h4
        {

            text-align: center;
            font-size: 200%;
        }
        #sub
        {
            margin-left: 40%; border: 2px solid black;border-radius:5px;height: 30px;
        }
        h1
        {
            color: white;

        }
        #id2
        {
            background-color: beige;
            border-radius: 5px;
            border: 2px solid black;
            float: right;
            width: 48%;
            height: 61%;
            position: relative;
            margin-top: 1%;
            color: black;

        }
        .recent
        {
            margin: auto;
            height:280px; width:90%;
            overflow-y: auto;
            border:2px solid #444;
        }

        table{width:97%;}
        td{padding:15px; background:#eee;}




    </style>
</head>
<body>
<div id="header">
    <img src="ttn.jpg" width="210" height="203" style="float:left;margin-left: 2px;margin-top: 2px;">

    <span style="display: inline">
        <h5 style="display: inline">Bloggers@To The New </h5>
        <h5 style="display: inline;margin-left: 70px"><a href="/LogOut" style="color: white"> logout</a></h5>
    </span>
    <h2>Share Your Blogs Here</h2>

</div>
<div id="id1">

    <h4>Enter Your Blog Here</h4>
    <textarea name="ta" id="blog"></textarea>
    <br><br>
    <input type="submit" value="submit blog" id="sub" onclick="sendInfo()">

</div>
<div id="id2">
    <h4>Recent Blogs</h4>
    <div class="recent">

    </div>



</div>
<script type="text/javascript">
    var request;
    function sendInfo()
    {

        var v=document.getElementById('blog').value;

        var url="/AddBlog?val="+v;

        if(window.XMLHttpRequest){
            request=new XMLHttpRequest();
        }
        else if(window.ActiveXObject){
            request=new ActiveXObject("Microsoft.XMLHTTP");
        }

        try{

            request.onreadystatechange=getInfo;
            request.open("get",url,true);
            request.send();
        }catch(e){alert("Unable to connect to server");}
    }

    function getInfo(){
        if(request.readyState==4){
            var val=request.responseText;
            if(val=="Session Expired")
            {
                window.location.href="http://localhost:8090/index.jsp";
            }
            alert(val);
            document.getElementById('blog').value=null;
        }
    }


</script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script>
    function autoRefresh_div()
    {
        $(".recent").load("recentblogs");// a function which will load data from other file after x seconds
    }

    setInterval('autoRefresh_div()', 5000); // refresh div after 5 secs
</script>
</body>
</html>
<%
    }
%>