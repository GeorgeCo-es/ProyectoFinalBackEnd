$(document).ready(function() {
    $("#act_paciente").submit(function(evt) {
        evt.preventDefault();

window.addEventListener('load', function () {
    const formulario = document.querySelector('#update_paciente_form');
    formulario.addEventListener('submit', function (event) {
        let pacienteId = document.querySelector('#paciente_id').value;

        const formData = {
            nombre : document.querySelector$("#nombre").value,
            apellido : document.querySelector$("#apellido").value,
            dni: document.querySelector$("#dni").value,
            fechaIngreso: document.querySelector$("#fechaIngreso").value,
        }


        $.ajax({
            url: '/paciente',
            type: 'PUT',
            contentType : "application/json",
            data: JSON.stringify(formData),
            dataType : 'json',
            async: false,
            cache: false,
            success: function (response) {
                let paciente = response
               console.log(response)
                let successAlert = '<div class="alert alert-success alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong></strong> paciente actualizado </div>'
                $("#response").append(successAlert);
                $("#response").css({"display": "block"});

                resetUploadForm();
            },
            error: function (response) {
                let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong> Error intente nuevamente</strong> </div>'
                $("#response").append(errorAlert);
                $("#response").css({"display": "block"});

                resetUploadForm();
            }
        });
    });

    function resetUploadForm(){
        $("#nombre").val("");
        $("#apellido").val("");
        $("#dni").val("");
        $("#fechaIngreso").val("");
    }

    (function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            $(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/paciente.html") {
            $(".nav .nav-item a:last").addClass("active");
        }
    })();

    function find(id) {

              const url = '/paciente'+"/"+id;
              const settings = {
                  method: 'GET'
              }
              fetch(url,settings)
              .then(response => response.json())
              .then(data => {
                  let paciente = data;

                  $("#nombre").val(paciente.nombre),
                  $("#apellido").val(paciente.apellido),
                  $("#dni").val(paciente.dni),
                  $("#fechaIngreso").val(paciente.fechaIngreso),
                  $("#div_pelicula_updating").css({"display": "block"});
              }).catch(error => {
                  console.log(error);
                  alert("Error -> " + error);
              })
          }


});