

function agregarUsuario() {

    //Obtener datos del formulario
    let nombre = document.getElementById("nombre_apellido").value;
    let telefono = document.getElementById("telefono").value;
    //Busco el input con el nombre vehiculo que este seleccionado
    let vehiculoSelect = document.querySelector('input[name="vehiculo"]:checked');
    let vehiculo = " ";

    if (vehiculoSelect != null) {
        vehiculo = vehiculoSelect.value;
    }

    let tipoExamen = document.getElementById("tipo_examen").value;

    //Obtengo los valores de checbox
    let cajas = document.getElementsByName("disponibilidad");
    let disponibilidad = [];

    for (let i = 0; i < cajas.length; i++) {
        //Miro si estan seleccionados
        if (cajas[i].checked) {
            //Agrego a mi array
            disponibilidad.push("  " + cajas[i].value);

        }
    }

    let nota = document.getElementById("notas").value;

    // alert(nombre + " " + telefono + " " + vehiculo + " " + tipoExamen + " " + disponibilidad +  " " + nota);


    let nuevo_registro = "<tr><td>" + nombre + "</td> <td>" + telefono + "</td> <td>" + vehiculo + "</td> <td>" + tipoExamen +
        "</td> <td>" + disponibilidad + "</td> <td>" + nota + "</td> </tr>";

    let registro_anterior = document.getElementById("tabla_registros").innerHTML;

    document.getElementById("tabla_registros").innerHTML = registro_anterior + nuevo_registro;

    //Ocultar formulario
    document.getElementById("formulario").style.display = "none";
    //Mostar tabla actualizada
    document.getElementById("registros").style.display = "block";

}

function volver() {
    //Ocultar tabla
    document.getElementById("registros").style.display = "none";
    //Mostar formulario
    document.getElementById("formulario").style.display = "block";

    limpiar();

}

function limpiar() {

    //Poner los valores vacios
    document.getElementById("nombre_apellido").value = "";
    document.getElementById("telefono").value = "";
    let vehiculo = document.querySelector('input[name="vehiculo"]:checked');

    //Verifico que no es nulo para que no rompa la funcion
    if (vehiculo != null) {
        vehiculo.checked = false;
    }
    document.getElementById("tipo_examen").value = "";


    let cajas = document.getElementsByName("disponibilidad");

    for (let i = 0; i < cajas.length; i++) {
        cajas[i].checked = false;
    }

    let nota = document.getElementById("notas").value = "";

}