<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html> <!-- ENCODING HTML 5, necessary for bootstrap -->
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Example Application Spring and Bootstrap</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">


    <link rel="stylesheet" href="/resources/css/multi-select.css" />

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.12/datatables.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-multiselect/0.9.13/css/bootstrap-multiselect.css">
    <!-- Latest compiled and minified JavaScript -->
</head>
<script>

    function updateContactDetails(thiss) {
        var table = $('#tableClient ').DataTable();
        var data=table.row(thiss.closest('tr')).data();
        $("#contact_id").val(data[0])
       $("#newconname").val(data[1]);
       $("#newemailid").val(data[2]);
       $("#newphoneno").val(data[3]);
       $("#newcompanyname").val(data[4]);
       var d=data[5].substring(0,data[5].length);
       d=d.replace(/\s/g, '');
       var array=d.split(",");
        $("#updatecategoryname").multiselect("clearSelection");
        $("#updatecategoryname").multiselect("refresh");
            $('#updatecategoryname').multiselect('select', array);
        $('#updateContactModal').modal('show');
    }
    function deleteContactDetails(id) {
        $.ajax({
            url:"/deleteContact?id="+id,
            type:"Get",
            success: function (msg) {
                alert(msg);
            },
            error: function (msg) {
                alert(msg);
            }
        });

    }
</script>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-12">

            <header style="background-color:blue;color: white;height: 40%">
                <h2 style="display: inline;height: 30%">Contact Book</h2>
                <h2 style="float: right;clear: both;"><img src="/resources/profilepic/${userprofilepic}" class="img-circle" width="60px" height="60px">
                    <span>${username}</span></h2>
            </header>
        </div>
    </div>

    <form class="form-horizontal" role="form">
        <div class="form-group">
            <button type="button" id="buttonSearch" class="btn btn-info" data-toggle="modal" data-target="#modalForm">
                <span class="glyphicon glyphicon-plus-sign"></span></span> Add category
            </button>
            <a href="/showAllCategory"> <button type="button" id="buttonSearc" class="btn btn-info">
             Show All categories
            </button></a>
            <button type="button" id="button" class="btn btn-success" data-toggle="modal" data-target="#AddContactModal">
                <span class="glyphicon glyphicon-plus-sign"></span> Add Contact
            </button>
            <button type="button" id="buttonDelete" class="btn btn-warning">
                <span class="glyphicon glyphicon-minus-sign"></span> Delete
            </button>
        </div>
        <div>
            <table id="tableClient" class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th class="col-sm-0" data-field="id">id</th>
                    <th class="col-sm-2" data-field="name">Name</th>
                    <th class="col-sm-2" data-field="Email">Email</th>
                    <th class="col-sm-2" data-field="lastname">Phone No</th>
                    <th class="col-sm-2" data-field="dateBirth">Company</th>
                    <th class="col-sm-2" data-field="register">Category</th>
                    <th class="col-sm-2" data-field="Actions">Actions</th>
                </tr>
                </thead>
            </table>
        </div>
    </form>
</div>

<div class="modal fade" id="modalForm" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">Category Form</h4>
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span>
                    <span class="sr-only">Close</span>
                </button>

            </div>

            <!-- Modal Body -->
            <div class="modal-body">
                <p class="statusMsg"></p>
                <form role="form" id="addCategoryForm" action="/addCategory" method="POST">
                    <div class="form-group">
                        <label for="cname">Category Name *</label>
                        <input type="text" class="form-control" id="cname" required name="categoryName" placeholder="Such As Family"/>
                    </div>

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



<%--Modal To Add Contact--%>
<div class="modal fade" id="AddContactModal" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title" id="Contact">Contact Form</h4>
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span>
                    <span class="sr-only">Close</span>
                </button>

            </div>

            <!-- Modal Body -->
            <div class="modal-body">
                <p class="statusMsg"></p>
                <form role="form" id="addContactForm" action="/addContact" method="POST">
                    <div class="form-group">
                        <label for="cname">Contact Name *</label>
                        <input type="text" class="form-control" required id="contactname" name="name" placeholder="Such As Family"/>
                    </div>

                    <div class="form-group">
                        <label for="cname">EmailId </label>
                        <input type="email" class="form-control" id="emailid" name="emailId" placeholder="Such As Family"/>
                    </div>
                    <div class="form-group">
                        <label for="cname">Company Name</label>
                        <input type="text" class="form-control" id="companyname" name="company" placeholder="Such As Family"/>
                    </div>
                    <div class="form-group">
                        <label for="cname">Phone No. </label>
                        <input type="" class="form-control" id="phno" name="phoneNo" placeholder="Such As Family"/>
                    </div>

                    <div class="form-group">
                        <select id="ms" multiple="multiple" name="categoryNames">
                            <c:forEach items="${categoryNames}" var="catname">
                            <option value="${catname.categoryName}">${catname.categoryName}</option>
                            </c:forEach>
                        </select>
                    </div>

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




<%--Modal To Add Contact Ends Here--%>




<%--Modal To Update Contact Info --%>

<div class="modal fade" id="updateContactModal" role="dialog">
    <div class="modal-dialog" style="z-index: 1">
        <div class="modal-content" style="z-index: 1">
            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title" id="update">Update Contact Form</h4>
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span>
                    <span class="sr-only">Close</span>
                </button>

            </div>

            <!-- Modal Body -->
            <div class="modal-body" style="z-index: 1">
                <p class="statusMsg"></p>
                <form role="form" id="updateContactForm" action="/updateContact" method="POST">
                    <div class="form-group">
                        <label for="newconname">Contact Name *</label>
                        <input type="text" class="form-control" required id="newconname" name="name" />
                    </div>

                    <div class="form-group">
                        <label for="newemailid">EmailId </label>
                        <input type="email" class="form-control" id="newemailid" name="emailId"/>
                    </div>
                    <div class="form-group">
                        <label for="newcompanyname">Company Name</label>
                        <input type="text" class="form-control" id="newcompanyname" name="company" />
                    </div>
                    <div class="form-group">
                        <label for="newphoneno">Phone No. </label>
                        <input type="" class="form-control" id="newphoneno" name="phoneNo" />
                    </div>

                    <div class="form-group">
                        <select id="updatecategoryname" multiple="multiple" name="categoryNames" class="cat data">
                            <c:forEach items="${categoryNames}" var="catname">
                                <option value="${catname.categoryName}">${catname.categoryName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <input type="hidden" name="id" id="contact_id">

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


<%--Modal To update Contact Ends Here--%>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>

<%--<script src="/resources/js/multi-select.js"></script>--%>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.2.2/jquery.form.min.js" integrity="sha384-FzT3vTVGXqf7wRfy8k4BiyzvbNfeYjK+frTVqZeNDFl8woCbF0CYG6g2fMEFFo/i" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-multiselect/0.9.13/js/bootstrap-multiselect.js"></script>

<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.20.1/locale/en-au.js"></script>--%>
<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.12/datatables.min.js"></script>
<script src="/resources/js/addCategory.js"></script>
<script src="/resources/js/contactlist.js"></script>

<script>
    $(document).ready(function() {
        // bind 'myForm' and provide a simple callback function
        // $('#ms').change(function() {
        //
        // }).multipleSelect({
        //     width:'100%'
        // });

        $("#updatecategoryname").multiselect(
            {
                includeSelectAllOption: true
            }
        );


        $('#addCategoryForm').ajaxForm({
            success: function (msg) {
                alert(msg);
            },
            error: function (msg) {
                alert(msg);
            }
        });
        $('#addContactForm').ajaxForm({
            success: function (msg) {
                alert(msg);
            },
            error: function (msg) {
                alert(msg);
            }
        });
        $('#updateContactForm').ajaxForm({
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
