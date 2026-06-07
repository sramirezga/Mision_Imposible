


/*   */

async function LogIn() {


    const resp = await fetch("datos/usuarios.json");
    const usuarios = await resp.json();

    let user = document.getElementById("usuario").value;

    let pass = document.getElementById("password").value;

    // alert(usuarios[0].id);

    let encontrado = false;
    let esAdmin = false;



    for (let i = 0; i < usuarios.length; i++) {
        if (user == usuarios[i].usuario && pass == usuarios[i].password) {
            encontrado = true;
            if (usuarios[i].usuario == "admin") {
                esAdmin = true;
            }
        }
    }

    if (encontrado && esAdmin) {
        window.location.href = "administrador.html";
    } else if (encontrado) {
        window.location.href = "catalogo.html";
    } else {
        alert("ERROR: Usuario-Contraseña desconocido")
    }


}


async function mostrarUsuarios() {
    const resp = await fetch("datos/usuarios.json");
    const usuarios = await resp.json();

    let lista = "";

    for (let i = 0; i < usuarios.length; i++) {
        lista += "<p>" + usuarios[i].id + " - " + usuarios[i].usuario + "</p>";
    }

    document.getElementById("listaUsuarios").innerHTML = lista;

}

async function verPerfil() {

    const resp = await fetch("datos/usuarios.json");
    const usuarios = await resp.json();

    let idUser = Number(document.getElementById("idUsuario").value);
    //alert("hola");

    let perfil = "";
    let encontrado = false;


    for (let i = 0; i < usuarios.length; i++) {

        if (idUser == usuarios[i].id) {

            encontrado = true;
            perfil += "<p> <img src='img/" + usuarios[i].avatar + "'> </p>";
            // alert(usuarios[i].avatar)
            perfil += "<p>ID" + usuarios[i].id + "</p>";
            perfil += "<p> USUARIO: " + usuarios[i].usuario + "</p>";
            perfil += "<p> PASSWORD" + usuarios[i].password + "</p>";
        }

    }

    if (!encontrado) {
        alert("ERROR: ");
    }

    document.getElementById("perfilUsuario").innerHTML = perfil;
}

function salir() {
    window.location.href = "index.html";
}


async function cargarInstrumentos() {
    const resp = await fetch("datos/instrumentos.json");
    const instrumentos = await resp.json();


    let tabla = "<table border='1'>";

    tabla += "<tr>";
    tabla += "<td>Posicion</td>";
    tabla += "<td>Nombre</td>";
    tabla += "<td>Imagen</td>";
    tabla += "<td>Precio</td>";
    tabla += "<td>Material</td>";
    tabla += "<td>Color</td>";
    tabla += "</tr>";


    for (let i = 0; i < instrumentos.length; i++) {

        tabla += "<tr>";
        tabla += "<td>" + instrumentos[i].posicion + "</td>";
        tabla += "<td>" + instrumentos[i].nombre + "</td>";
        tabla += "<td><img src='img/" + instrumentos[i].imagen + "'> </td>";
        tabla += "<td>" + instrumentos[i].origen + "</td>";
        tabla += "<td>" + instrumentos[i].precio + "</td>";
        tabla += "<td>" + instrumentos[i].material + "</td>";
        tabla += "</tr>";
    }



    tabla += " </table>";

    document.getElementById("tablaInstrumentos").innerHTML = tabla;


    document.getElementById("btnPrecio").style.color = "black";
    document.getElementById("btnTodos").style.color = "red";
    document.getElementById("btnPar").style.color = "black";

}

async function filtarPar() {
    const resp = await fetch("datos/instrumentos.json");
    const instrumentos = await resp.json();


    let tabla = "<table border='1'>";

    tabla += "<tr>";
    tabla += "<td>Posicion</td>";
    tabla += "<td>Nombre</td>";
    tabla += "<td>Imagen</td>";
    tabla += "<td>Precio</td>";
    tabla += "<td>Material</td>";
    tabla += "<td>Color</td>";
    tabla += "</tr>";


    for (let i = 0; i < instrumentos.length; i++) {


        if (instrumentos[i].posicion % 2 == 0) {
            tabla += "<tr>";
            tabla += "<td>" + instrumentos[i].posicion + "</td>";
            tabla += "<td>" + instrumentos[i].nombre + "</td>";
            tabla += "<td><img src='img/" + instrumentos[i].imagen + "'> </td>";
            tabla += "<td>" + instrumentos[i].origen + "</td>";
            tabla += "<td>" + instrumentos[i].precio + "</td>";
            tabla += "<td>" + instrumentos[i].material + "</td>";
            tabla += "</tr>";
        }

    }



    tabla += " </table>";
    btnPar
    document.getElementById("tablaInstrumentos").innerHTML = tabla;
    document.getElementById("btnPrecio").style.color = "black";
    document.getElementById("btnTodos").style.color = "black";
    document.getElementById("btnPar").style.color = "red";

}


async function filtarPrecio() {
    const resp = await fetch("datos/instrumentos.json");
    const instrumentos = await resp.json();

    let coste = parseInt(document.getElementById("precio").value);
    let tabla = "<table border='1'>";

    tabla += "<tr>";
    tabla += "<td>Posicion</td>";
    tabla += "<td>Nombre</td>";
    tabla += "<td>Imagen</td>";
    tabla += "<td>Precio</td>";
    tabla += "<td>Material</td>";
    tabla += "<td>Color</td>";
    tabla += "</tr>";



    for (let i = 0; i < instrumentos.length; i++) {


        if (instrumentos[i].precio < coste) {

           //alert(instrumentos[i].precio);
            tabla += "<tr>";
            tabla += "<td>" + instrumentos[i].posicion + "</td>";
            tabla += "<td>" + instrumentos[i].nombre + "</td>";
            tabla += "<td><img src='img/" + instrumentos[i].imagen + "'> </td>";
            tabla += "<td>" + instrumentos[i].origen + "</td>";
            tabla += "<td>" + instrumentos[i].precio + "</td>";
            tabla += "<td>" + instrumentos[i].material + "</td>";
            tabla += "</tr>";
        }

    }




    tabla += " </table>";
    btnPar
    document.getElementById("tablaInstrumentos").innerHTML = tabla;
    document.getElementById("btnPrecio").style.color = "red";
    document.getElementById("btnTodos").style.color = "black";
    document.getElementById("btnPar").style.color = "black";

}