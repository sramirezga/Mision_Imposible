function agregar_usuario(){
    //recoger los datos de un input de tipo:  
    //text 
    let nombre = document.getElementById("nombre_apellido").value;
    console.log(nombre);
    let telefono = document.getElementById("telefono").value;
    //radio
    let vehiculo = "";
    if(document.querySelector("[name=vehiculo]:checked")!=null){
        vehiculo = document.querySelector("[name=vehiculo]:checked").value;
    }
    //datalist
    let tipo_examen = document.getElementById("tipo_examen").value;
    //select
    /*let tipo_examen2 = document.getElementById("tipo_examen2").value;
    switch (tipo_examen2){
        case "teorico":{
            tipo_examen2 = "Teórico";
            break;
        }
        case "pista":{
            tipo_examen2 = "Pista";
            break;
        }
        case "carretera":{
            tipo_examen2 = "Carretera";
            break;
        }
    }*/
    //checkbox
    let disponibilidad_cadena="";
    let disponibilidad_array = document.getElementsByName("disponibilidad");

    for (let i=0; i<disponibilidad_array.length; i++){

        if (disponibilidad_array[i].checked==true){
            disponibilidad_cadena = disponibilidad_cadena + disponibilidad_array[i].value + " ";
        }
    }
    //textarea
    let notas = document.getElementById("notas").value;

    /*escribir los datos del formulario en la tabla: 
    1. crear la nueva línea de la tabla con los datos del formulario
    2. coger el contenido anterior de la tabla
    3. cambiar el contenido de la tabla, para que sea el contenido anterior de la tabla más la nueva línea */

    /*let nueva_linea="<tr><td>" + nombre + "</td><td>" + telefono + "</td><td>" + vehiculo + 
    "</td><td>" + tipo_examen + "</td><td>" + tipo_examen2 + "</td><td>" + disponibilidad_cadena + "</td><td>" + notas + 
    "</td></tr>";*/

    let nueva_linea="<tr><td>" + nombre + "</td><td>" + telefono + "</td><td>" + vehiculo + 
    "</td><td>" + tipo_examen + "</td><td>" + disponibilidad_cadena + "</td><td>" + notas + 
    "</td></tr>";

    let contenido_anterior = document.getElementById("lista_usuarios").innerHTML;

    document.getElementById("lista_usuarios").innerHTML = contenido_anterior + nueva_linea;

    //ocultar este formulario y mostrar la lista de usuarios
    document.getElementById("formulario").style.display="none";
    document.getElementById("lista").style.display="block";
}

function volver(){

    //ocultar la lista de usuarios y mostrar la tabla de inscripción
    document.getElementById("formulario").style.display="block";
    document.getElementById("lista").style.display="none";
    /*dejar vacío el formulario - lo mismo que hace la función reset()
    Lo que viene a continuación lo puedo sustituir por: reset(); */
    document.getElementById("nombre_apellido").value = "";
    document.getElementById("telefono").value = "";
    document.querySelector("[name=vehiculo]:checked").checked = false;
    document.getElementById("tipo_examen").value = "";
    //document.getElementById("tipo_examen2").value = "";

    let disponibilidad_array = document.getElementsByName("disponibilidad");

    for (let i=0; i<disponibilidad_array.length; i++){

        if (disponibilidad_array[i].checked == true){
            disponibilidad_array[i].checked = false;
        }
    }

    document.getElementById("notas").value = "";
}

function reset(){
    document.getElementById("nombre_apellido").value = "";
    document.getElementById("telefono").value = "";
    document.querySelector("[name=vehiculo]:checked").checked = false;
    document.getElementById("tipo_examen").value = "";
    //document.getElementById("tipo_examen2").value = "";

    let disponibilidad_array = document.getElementsByName("disponibilidad");

    for (let i=0; i<disponibilidad_array.length; i++){

        if (disponibilidad_array[i].checked == true){
            disponibilidad_array[i].checked = false;
        }
    }

    document.getElementById("notas").value = "";
}