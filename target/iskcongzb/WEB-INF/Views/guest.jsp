<!DOCTYPE html>
<html>
<head>
    <title>Bootstrap Popupmultiselect Example</title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js"></script>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://harshniketseta.github.io/popupMultiSelect/dist/stylesheets/multiselect.min.css">
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="http://harshniketseta.github.io/popupMultiSelect/dist/javascripts/multiselect.min.js"></script>
</head>
<body>


<div class="container">
    <h1>Bootstrap Popupmultiselect Example</h1>
    <form action="/multi" method="post">
    <select multiple name="cat" id="my-language">

        <option value="1">Laravel</option>
        <option value="2">PHP</option>
        <option value="3">Codeigniter</option>
        <option value="4">JQuery</option>
        <option value="5">HTML</option>
        <option value="6">CSS</option>
        <option value="7">AngularJS</option>
    </select>
        <input type="submit" value="submit">
    </form>
</div>


<script type="text/javascript">
    $("#my-language").multiselect();

</script>


</body>