function checkAltaCliente() {
    document.getElementById("myCheckaltacliente").checked = true;
    document.getElementById("myCheckaltaempleado").checked = false;
    document.getElementById("myCheckaltaempresa").checked = false;
    ul = document.getElementById("signup-step")
    ul.innerHTML = ""
    var entry = document.createElement('li');
    entry.id = "usuario"
    entry.className = "active"
    entry.textContent = "Datos del usuario"
    ul.appendChild(entry)
    var entrysec = document.createElement('li');
    entrysec.id = "cliente"
    entrysec.textContent = "Cliente"
    ul.appendChild(entrysec)
    document.getElementById("tipoalta").value = "cliente"

}


function checkAltaEmpleado() {
    document.getElementById("myCheckaltacliente").checked = false;
    document.getElementById("myCheckaltaempleado").checked = true;
    document.getElementById("myCheckaltaempresa").checked = false;
    ul = document.getElementById("signup-step")
    ul.innerHTML = ""
    var entry = document.createElement('li');
    entry.id = "usuario"
    entry.className = "active"
    entry.textContent = "Datos del usuario"
    ul.appendChild(entry)
    var entrysec = document.createElement('li');
    entrysec.id = "empleado"
    entrysec.textContent = "Empleado"
    ul.appendChild(entrysec)
    document.getElementById("tipoalta").value = "empleado"
}


function checkAltaEmpresa() {
    document.getElementById("myCheckaltacliente").checked = false;
    document.getElementById("myCheckaltaempleado").checked = false;
    document.getElementById("myCheckaltaempresa").checked = true;
    ul = document.getElementById("signup-step")
    ul.innerHTML = ""

    var entry = document.createElement('li');
    entry.id = "usuario"
    entry.className = "active"
    entry.textContent = "Datos del usuario"
    ul.appendChild(entry)


    var entrysec = document.createElement('li');
    entrysec.id = "empleado"
    entrysec.textContent = "Empleado"
    ul.appendChild(entry)

    var entrysec1 = document.createElement('li');
    entrysec1.id = "empresa"
    entrysec1.textContent = "Empresa"
    ul.appendChild(entrysec1)


    var entrysec2 = document.createElement('li');
    entrysec2.id = "empresa2"
    entrysec2.textContent = "Empresa 2"
    ul.appendChild(entrysec2)

    var entrysec3 = document.createElement('li');
    entrysec3.id = "empresa3"
    entrysec3.textContent = "Empresa 3"
    ul.appendChild(entrysec3)

    var entrysec4 = document.createElement('li');
    entrysec4.id = "empresa4"
    entrysec4.textContent = "Empresa 4"
    ul.appendChild(entrysec4)

    var entrysec5 = document.createElement('li');
    entrysec5.id = "empresa5"
    entrysec5.textContent = "Empresa 5"
    ul.appendChild(entrysec5)

    var entrysec6 = document.createElement('li');
    entrysec6.id = "empresa6"
    entrysec6.textContent = "Empresa 6"
    ul.appendChild(entrysec6)

    var entrysec7 = document.createElement('li');
    entrysec7.id = "empresa7"
    entrysec7.textContent = "Empresa 7"
    ul.appendChild(entrysec7)

    var entrysec8 = document.createElement('li');
    entrysec8.id = "empresa8"
    entrysec8.textContent = "Empresa 8"
    ul.appendChild(entrysec8)

    var entrysec9 = document.createElement('li');
    entrysec9.id = "empresa9"
    entrysec9.textContent = "Empresa 9"
    ul.appendChild(entrysec9)
    if (entrysec9.id === "empresa9") {
        var finishBtn = document.getElementById("finish-btn-empresa9");
        finishBtn.style.display = "block";
    }





    document.getElementById("tipoalta").value = "empresa"
}


function validate() {
    var output = true;
    $(".signup-error").html('');

    if ($("#usuario-field").css('display') != 'none') {
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

    if ($("#cliente-field").css('display') != 'none') {
        if (!($("#telefono").val())) {
            output = false;
            $("#telefono-error").html("Telefono obligatorio!");
        }

        if (!($("#nombreCliente").val())) {
            output = false;
            $("#nombreCliente-error").html("nombreCliente obligatorio!");
        }
        if (!($("#apellido1Cliente").val())) {
            output = false;
            $("#apellido1Cliente-error").html("apellido1Cliente obligatorio!");
        }
        if (!($("#apellido2Cliente").val())) {
            output = false;
            $("#apellido2Cliente-error").html("apellido2Cliente obligatorio!");
        }
    }
    if ($("#empleado-field").css('display') != 'none') {
        if (!($("#nombreEmpleado").val())) {
            output = false;
            $("#nombreEmpleado-error").html("nombreEmpleado obligatorio!");
        }
        if (!($("#apellido1Empleado").val())) {
            output = false;
            $("#apellido1Empleado-error").html("apellido1Empleado obligatorio!");
        }
        if (!($("#apellido1Empleado").val())) {
            output = false;
            $("#apellido2Empleado-error").html("apellido1Empleado obligatorio!");
        }
    }
    if ($("#empleado-field").css('display') != 'none') {
        if (!($("#nombreEmpresa").val())) {
            output = false;
            $("#nombreEmpresa-error").html("nombreEmpresa obligatorio!");
        }
        if (!($("#cif").val())) {
            output = false;
            $("#cif-error").html("cif obligatorio!");
        }

    }
    return output;
}

$(document).ready(function() {
    $("#next").click(function() {
        console.log("Siguiente pestaña" );
        var output = validate();
        if (output === true) {
            var current = $(".active");
            var next = $(".active").next("li");
            if (next.length > 0) {
                $("#" + current.attr("id") + "-field").hide();
                console.log("Siguiente pestaña:" + next.attr("id") )
                $("#" + next.attr("id") + "-field").show();
                $("#back").show();
                $("#finish").hide();
                $(".active").removeClass("active");
                next.addClass("active");
                if ($(".active").attr("id") == $("li").last().attr("id")) {
                    $("#next").hide();
                    $("#finish").show();
                }
            }
        }
    });

    $("#back").click(function() {
        var current = $(".active");
        var prev = $(".active").prev("li");


        if (prev.length > 0) {
            $("#" + current.attr("id") + "-field").hide();
            $("#" + prev.attr("id") + "-field").show();
            $("#next").show();
            $("#finish").hide();
            $(".active").removeClass("active");
            prev.addClass("active");
            if ($(".active").attr("id") == $("li").first().attr("id")) {
                $("#back").hide();
            }
        }
    });

    $("#finish-btn").click(function(e) {
        var output = validate();
        var current = $(".active");

        if (output === true) {
            window.location.href = "/";
        } else {
            // Prevent refresh
            e.preventDefault();
            $("#" + current.attr("id") + "-field").show();
            $("#back").show();
            $("#finish-btn").show();
        }

        $("#finish").show();
        $("#next").hide();
    });

});