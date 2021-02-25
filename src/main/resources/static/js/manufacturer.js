$('document').ready(function (){

    $('table #editButton').on('click', function (event){
        event.preventDefault();

        //operators/findById/?id=1

        var href =$(this).attr("href");

        $.get(href,function (manufacturer, status){
            $('#idEdit').val(manufacturer.id);
            $('#nameOfCompanyEdit').val(manufacturer.nameOfCompany);
            $('#webSiteEdit').val(manufacturer.webSite);
            $('#countryEdit').val(manufacturer.country);
            $('#addressEdit').val(manufacturer.address);
            $('#telephoneEdit').val(manufacturer.telephone);
        });
        $('#editModal').modal();
    });

    $('table #deleteButton').on('click',function(event){
        event.preventDefault();
        var href =$(this).attr("href");

        $('#confirmDeleteButton').attr('href', href);

        $('#deleteModal').modal();

       alert("I am in manufacturer java script file");
        //print("My message here");
    });

    $('.table #detailsButton').on('click',function(event) {
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(manufacturer, status){
            $('#idDetails').val(manufacturer.id);
            $('#nameOfCompanyDetails').val(manufacturer.nameOfCompany);
            $('#webSiteDetails').val(manufacturer.webSite);
            $('#countryDetails').val(manufacturer.country);
            $('#addressDetails').val(manufacturer.address);
            $('#telephoneDetails').val(manufacturer.telephone);
            $('#lastModifiedByDetails').val(manufacturer.lastModifiedBy);
            $('#lastModifiedDateDetails').val(manufacturer.lastModifiedDate.substr(0,19).replace("T", " "));
        });
        $('#detailsModal').modal();
    });
});