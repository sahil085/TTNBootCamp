<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>ALl Categories/h2>

    <%
        int flag=0;
    %>
    <c:if test="${fn:length(categoryList) gt 0}">
    <%
        flag=1;
    %>
    <table class="table" border="1px">
        <thead>
        <tr>
            <th>Category Name</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${categoryList}" var="cat">
        <tr>
            <td>${cat.categoryName}</td>
            <td>
                <a href='#' style='margin-right: 15px' class='fa fa-pencil-square-o' aria-hidden='true' onclick='updateCategoryName("${cat.id}","${cat.categoryName}")'></a>
                <a href='#' style='margin: auto' class='fa fa-trash' aria-hidden='true' onclick='deleteCategory("${cat.id}")'></a>

            </td>
        </tr>
        </c:forEach>

        </tbody>
    </table>
    </c:if>
    <%
        if(flag==1)
        {
            %>
    <p>No Categories Found</p>
    <%
    }
    %>
    <div class="modal fade" id="updateCategoryModal" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title" id="myModalLabel">Update Category Details</h4>
                    <button type="button" class="close" data-dismiss="modal">
                        <span aria-hidden="true">&times;</span>
                        <span class="sr-only">Close</span>
                    </button>

                </div>

                <!-- Modal Body -->
                <div class="modal-body">
                    <p class="statusMsg"></p>
                    <form role="form" id="updateCategoryForm" action="/updateCategory" method="POST">
                        <div class="form-group">
                            <label for="newcname">New Category Name</label>
                            <input type="text" class="form-control" id="newcname" name="categoryName" />
                        </div>
                        <input type="hidden" name="id" id="catid">
                        <input type="hidden"
                               name="${_csrf.parameterName}"
                               value="${_csrf.token}"/>
                        <button type="submit" class="btn btn-primary submitBtn" >SUBMIT</button>
                    </form>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>

                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.2.2/jquery.form.min.js" integrity="sha384-FzT3vTVGXqf7wRfy8k4BiyzvbNfeYjK+frTVqZeNDFl8woCbF0CYG6g2fMEFFo/i" crossorigin="anonymous"></script>

<script>
    $(document).ready(function() {
        $('#updateCategoryForm').ajaxForm({
            success: function (msg) {
                alert(msg);
            },
            error: function (msg) {
                alert(msg);
            }
        });
    });
    function updateCategoryName(id,categoryName) {
        $("#newcname").val(categoryName);
        $("#catid").val(id);
        $("#updateCategoryModal").modal("show");

    }
    function deleteCategory(id) {
        $.ajax({
            url:"/deleteCategory?id="+id,
            type:"Post",
            success: function (msg) {
                alert(msg);
            },
            error: function (msg) {
                alert(msg);
            }
        })

    }


</script>
</body>
</html>
