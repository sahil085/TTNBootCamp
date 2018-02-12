$(document).ready(function(){
    // Activated the table
    var tableClient = $('#tableClient').DataTable({
        "autoWidth": false,
        "columnDefs": [
            {"targets": [ 0 ],
                "visible": false,
                "searchable": true,
                "processing": true,
                "serverSide": true,
                "deferLoading": 57
            }
        ],
        "ajax": {
            "url": "/getAllContacts",
            "type": "POST",
            "dataType": "json",
            "cache": false,
            "processing": true,
            "serverSide": true,
            "deferLoading":20,
            "contentType": "application/json; charset=utf-8",
            "success" :  function(data){
if(data==null)
{
    alert("hi");
    $("#tableClient").DataTable().row.add([
        "No Data Found",
        "No Data Found"
    ]).draw();

}
                $.each(data, function(ind, obj){
var catname="";
                    $.each(obj.categories, function(index, cat) {
                      catname=" "+cat.categoryName+","+catname;
                    });
                    catname=catname.substring(0,catname.length-1);
                        $("#tableClient").DataTable().row.add([

                            obj.id,
                            obj.name,
                            obj.emailId,
                            obj.phoneNo,
                            obj.company,
                            catname,
                            "<a href='#' style='margin-right: 15px' class='fa fa-pencil-square-o' aria-hidden='true' onclick='updateContactDetails(this)' &nbsp;></a>" +
                            "<a href='#' style='margin: auto' class='fa fa-trash' aria-hidden='true' onclick='deleteContactDetails("+obj.id+")'></a>"
                        ]).draw();

                });
            }
        },
    });



    $("#buttonInsert").click(function(){
        $(this).callAjax("insertClient", "");

        $(".form-control").val("");

    });

    $("#buttonDelete").click(function(){

        var valuesChecked = $("#tableClient input[type='checkbox']:checkbox:checked").map(
            function () {
                return this.value;
            }).get().join(",");

        $(this).callAjax("deleteClient", valuesChecked);

    });

    $.fn.callAjax = function( method, checkeds ){
        $.ajax({
            type: "POST",
            url: "/BootstrapSpringProject/" + method,
            dataType: "json",
            timeout : 100000,
            data: { name: $("#name").val(), lastname: $("#lastname").val(), dateBirth: $("#dateBirth").val(),
                register: $("#register").val(), checked: checkeds },

            success: function(data){
                tableClient.clear().draw();
                tableClient.ajax.reload();
            },
            error: function(e){
                alert("ERROR: ", e);
            }
        });
    }

});