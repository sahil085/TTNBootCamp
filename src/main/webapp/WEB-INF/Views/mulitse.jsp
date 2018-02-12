<!DOCTYPE html>
<html>
<head>
    <script src="https://code.jquery.com/jquery.min.js"></script>
    <link href="https://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" type="text/css" />
    <script src="https://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.0.0.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-multiselect/0.9.13/css/bootstrap-multiselect.css" rel="stylesheet" type="text/css" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-multiselect/0.9.13/js/bootstrap-multiselect.min.js"></script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width">
    <title>JS Bin</title>


<body>
<select id="example-getting-started" multiple="multiple">
    <option value="cheese">Cheese</option>
    <option value="tomatoes">Tomatoes</option>
    <option value="mozarella">Mozzarella</option>
    <option value="mushrooms">Mushrooms</option>
    <option value="pepperoni">Pepperoni</option>
    <option value="onions">Onions</option>
</select>
</body>
<script>
    $(document).ready(function() {
        $('#example-getting-started').multiselect();

        $('#example-getting-started').multiselect('select', ['cheese', 'pepperoni']);
    });
</script>
</html>