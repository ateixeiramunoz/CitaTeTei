$(document).ready(function() {

    $("#botonCrearUsuario").on( "click", (function(event ) {

        alert("Entrando en la funcion")

        //Esto hace que el botón NO envíe el formulario y ese envío pueda ser controlado mediante AJAX -> JS
       // event.preventDefault();

        alert("Enviando el post")

        $.ajax({
            url: '/api/crearUsuario',
            type: 'POST',
            data: { email: $("#email").valueOf(), password: $("#password").valueOf() }
        });
        alert("Post Enviado")

    }))

})


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
