$(document).ready(function() {
    $("#act_odontologo").submit(function(evt) {
        evt.preventDefault();

window.addEventListener('load', function () {
    const formulario = document.querySelector('#update_odontologo_form');
    formulario.addEventListener('submit', function (event) {
        let odontologoId = document.querySelector('#odontologo_id').value;

        const formData = {
            nombre : document.querySelector$("#nombre").value,
            apellido : document.querySelector$("#apellido").value,
            matricula: document.querySelector$("#matricula").value,
        }


        $.ajax({
            url: '/odontologos',
            type: 'PUT',
            contentType : "application/json",
            data: JSON.stringify(formData),
            dataType : 'json',
            async: false,
            cache: false,
            success: function (response) {
                let odontologo = response
               console.log(response)
                let successAlert = '<div class="alert alert-success alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong></strong> odontologo actualizado </div>'
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
        $("#matricula").val("");
    }

    (function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            $(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/odontologos.html") {
            $(".nav .nav-item a:last").addClass("active");
        }
    })();

    function find(id) {

              const url = '/odontologos'+"/"+id;
              const settings = {
                  method: 'GET'
              }
              fetch(url,settings)
              .then(response => response.json())
              .then(data => {
                  let pelicula = data;

                  $("#nombre").val(odontologo.nombre),
                  $("#apellido").val(odontologo.apellido),
                  $("#matricula").val(odontologo.matricula),
                  $("#div_pelicula_updating").css({"display": "block"});
              }).catch(error => {
                  console.log(error);
                  alert("Error -> " + error);
              })
          }


});