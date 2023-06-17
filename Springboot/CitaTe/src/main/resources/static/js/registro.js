$(document).ready(function()
{

        var altaGenericaDTO;

        $("#botonCrearUsuario").on( "click", function(event )
        {
                event.preventDefault();
                var jqxhr = $.post( "/crearusuario", { email: $("#email").val(), pass: $("#pass").val() } , function(data) {
                    showCrearEmpresa();
                })
                .fail(function() {
                    alert( "error" );
                });
        });


        $('body').on('submit','#formularioAltaEmpresa', function(event){
            event.preventDefault();
            var postData = $(this).serialize();
            var jqxhr = $.post( "/crearEmpresa", postData , function(data) {
                window.empresa = data;
                showCrearEmpleadoJefe();
            })
            .fail(function() {
                alert( "error" );
            });

        });

        $('body').on('submit','#formularioAltaJefe', function(event){

                    event.preventDefault();

                    alert(JSON.stringify(window.empresa));

                    var jqxhr = $.post( "/crearJefeEmpresa",
                    { "nombreEmpleado": $("#nombreEmpleado").val(),
                      "apellido1Empleado": $("#apellido1Empleado").val(),
                       "apellido2Empleado": $("#apellido2Empleado").val() ,
                       "empresa" :  JSON.stringify(window.empresa) } ,
                        function(data) {
                        showOk();
                    })
                    .fail(function() {
                        alert( "error" );
                    });

                });

});


function showOk(){

$("#crearUsuario").hide();
$("#crearEmpresa").hide();
$("#crearJefeEmpresa").hide();
alert("Se han creado correctamente el usuario, el perfil de la empresa, y el empleado jefe");


if(confirm("Deseas continuar configurando los horarios y demás características?"))
{
alert("Empiezo a editar cosas ")
}
window.location.href="/login"

}

function showCrearEmpresa(){

$("#crearUsuario").hide();
$("#crearEmpresa").show();

}

function showCrearEmpleadoJefe() {

$("#crearUsuario").hide();
$("#crearEmpresa").hide();
$("#crearJefeEmpresa").show();

}




function validate(){

        if (!($("#email").val())) {
            output = false;
            $("#email-error").html("Name required!");
        }
        if (!($("#user-password").val())) {
            output = false;
            $("#password-error").html("Password required!");
        }

        if (!($("#confirm-password").val())) {
            output = false;
            $("#confirm-password-error").html("Confirm password required!");
        }

        if ($("#user-password").val() != $("#confirm-password").val()) {
            output = false;
            $("#confirm-password-error").html("Password not matched!");
        }

}
