<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Demos</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/css/bootstrap.css">

    <link rel="stylesheet" href="/resources/css/multi-select.css" />
</head>
<body>
<div class="container">
    <div class="form-group">
        <label>Email address</label>
        <input type="email" class="form-control" placeholder="Enter email">
    </div>

    <div class="form-group">
        <label>Month</label>
        <form action="/multi" method="post">
        <select id="ms" multiple="multiple" name="cat">
            <option value="1">January</option>
            <option value="2">February</option>
            <option value="3">March</option>
            <option value="4">April</option>
            <option value="5">May</option>
            <option value="6">June</option>
            <option value="7">July</option>
            <option value="8">August</option>
            <option value="9">September</option>
            <option value="10">October</option>
            <option value="11">November</option>
            <option value="12">December</option>
        </select>
            <input type="submit" value="submit">
        </form>
    </div>
</div>
<script src="http://code.jquery.com/jquery-3.3.1.js"></script>

<script src="/resources/js/multi-select.js"></script>
<script>
    $(function() {
        $('#ms').change(function() {
            console.log($(this).val());
        }).multipleSelect({
            width: '100%'
        });
    });
</script>
</body>
</html>