
$('document').ready(function (){

    $('table #editButton').on('click', function (event){
        event.preventDefault();

        //operators/findById/?id=1

        var href =$(this).attr("href");

        $.get(href,function (operator, status){
            $('#idEdit').val(operator.id);
            $('#firstNameEdit').val(operator.firstName);
            $('#lastNameEdit').val(operator.lastName);
            $('#oibEdit').val(operator.oib);
            $('#emailEdit').val(operator.email);
            $('#roleEdit').val(operator.role);
            $('#passwordEdit').val(operator.password);
        });
        $('#editModal').modal();
    });

    $('table #deleteButton').on('click',function(event){
        event.preventDefault();
        var href =$(this).attr("href");

        $('#confirmDeleteButton').attr('href', href);

        $('#deleteModal').modal();

        alert("I am in operator java script file");
        print("My message here");
    });
});