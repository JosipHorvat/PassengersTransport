
$('document').ready(function() {

    $('.table #editButton').on('click',function(event){
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(vehicle, status){
            $('#idEdit').val(vehicle.id);
            $('#ddlManufacturerEdit').val(vehicle.manufacturerId);
            $('#nameEdit').val(vehicle.name);
            $('#modelEdit').val(vehicle.model);
            $('#registrationPlateEdit').val(vehicle.registrationPlate);
            $('#totalKilometersPassedEdit').val(vehicle.totalKilometersPassed);
            $('#numberOfSeatsEdit').val(vehicle.numberOfSeats);

            var dateOfManufacturing = vehicle.dateOfManufacturing.substr(0,10);
            $('#dateOfManufacturingEdit').val(dateOfManufacturing);

        });
        $('#editModal').modal();
    });

    $('.table #deleteButton').on('click',function(event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#deleteModal #delRef').attr('href', href);
        $('#deleteModal').modal();
    });

    $('.table #detailsButton').on('click',function(event){
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(vehicle, status){
            $('#idDetails').val(vehicle.id);
            $('#ddlManufacturerDetails').val(vehicle.manufacturerId);
            $('#nameDetails').val(vehicle.name);
            $('#modelDetails').val(vehicle.model);
            $('#registrationPlateDetails').val(vehicle.registrationPlate);
            $('#totalKilometersPassedDetails').val(vehicle.totalKilometersPassed);
            $('#numberOfSeatsDetails').val(vehicle.numberOfSeats);

            var dateOfManufacturing = vehicle.dateOfManufacturing.substr(0,10);
            $('#dateOfManufacturingDetails').val(dateOfManufacturing);

            $('#lastModifiedByDetails').val(state.lastModifiedBy);
            $('#lastModifiedDateDetails').val(state.lastModifiedDate.substr(0,19).replace("T", " "));
        });
        $('#detailsModal').modal();
    });


});
