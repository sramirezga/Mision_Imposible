


//LogIn
async function logIn() {
    //Obtener datos del json accounts
    const rest = await fetch("json/accounts/accounts.json");
    const usuarios = await rest.json();

    //console.log(usuarios);

    //Leer valores de los campo del formuario
    let usuario = document.getElementById("username").value;
    let pass = document.getElementById("password").value;


    let encontrado = false;
    let esAdmin = false;


    for (let i = 0; i < usuarios.length; i++) {
        if (usuario == usuarios[i].username && pass == usuarios[i].password) {
            encontrado = true;

            if (usuario == "admin") {
                esAdmin = true;
            }
        }
    }

    //Abrir pagina según usuario
    if (encontrado && esAdmin) {
        window.location.href = "registro_vuelos.html"
    } else if (encontrado) {
        window.location.href = "reserva_vuelos.html"
    } else {
        alert("Usuario o contraseña incorrecta inténtelo otra vez!")
    }


}


//Añadir vuelo
function anadirVuelo() {
    let origen = document.getElementById("departure_city").value;
    let destino = document.getElementById("destination_city").value;
    let precio = document.getElementById("flight_price").value;

    if (precio > 0) {
        let nuevo_vuelo = {
            origen: origen,
            destino: destino,
            precio: precio
        };

        let vuelos;

        //Miro si vuelos no esta vacio y si esta vadcio creo un array para 
        //poder hacer push del nuevo vuelo
        if (localStorage.getItem("vuelos") == null) {
            vuelos = [];
        } else {
            //Convertir vuelos a array para porder hacer push del nuevo objeto "nuevo_vuelo"
            vuelos = JSON.parse(localStorage.getItem("vuelos"));
        }


        vuelos.push(nuevo_vuelo);

        //Coverto el array a string
        localStorage.setItem("vuelos", JSON.stringify(vuelos));


        mostrarVuelosAdmin();
        alert("Vuelo añadido");

    } else {
        alert("El precio tiene que ser mayor que 0")
    }

}


//Mostra vuelo
function mostrarVuelosAdmin() {

    //Obtener los vuelos guarddos den la memoria
    let vuelos = JSON.parse(localStorage.getItem("vuelos"));

    if (vuelos == null) {
        document.getElementById("display").innerHTML = "<h4>No hay vuelos disponible</h4>";
    } else {
        let tabla = "<table id='tabla_result'>";
        tabla += "<tr>";
        tabla += "<td> Origen  <td>";
        tabla += "<td>  Destino <td>";
        tabla += "<td> Precio <td>";
        tabla += "</tr>";
        tabla += "<hr>";

        for (let i = 0; i < vuelos.length; i++) {

            tabla += "<tr>";
            tabla += "<td>" + vuelos[i].origen + "  <td>";
            tabla += "<td>" + vuelos[i].destino + "   <td>";
            tabla += "<td>" + vuelos[i].precio + "  <td>";
            tabla += "</tr>";
        }

        tabla += "</table>";

        document.getElementById("display").innerHTML = tabla;
    }




}

function mostrarVuelosUsuarios() {

    //Obtener los vuelos guarddos den la memoria
    let vuelos = JSON.parse(localStorage.getItem("vuelos"));

    if (vuelos == null) {
        document.getElementById("vuelosDisponibles").innerHTML = "<h4>No hay vuelos disponible</h4>";
    } else {
        let tabla = "<table id='tabla_result'>";
        tabla += "<tr>";
        tabla += "<td> Origen  <td>";
        tabla += "<td>  Destino <td>";
        tabla += "<td> Precio <td>";
        tabla += "<td> Cantidad <td>";
        tabla += "</tr>";
        tabla += "<hr>";

        for (let i = 0; i < vuelos.length; i++) {

            tabla += "<tr>";
            tabla += "<td>" + vuelos[i].origen + "  <td>";
            tabla += "<td>" + vuelos[i].destino + "   <td>";
            tabla += "<td>" + vuelos[i].precio + "  <td>";
            tabla += "<td><input type='text' id='cantidad" + i + "'> <td>";
            tabla += "<td><button onclick='anadirCantidadVuelos(" + i  +" )'>Añadir</button>   <td>";

            tabla += "</tr>";
        }

        tabla += "</table>";

        document.getElementById("vuelosDisponibles").innerHTML = tabla;
    }




}

function anadirCantidadVuelos(){


    alert("Pedido añadido correctamente")
}

function pago() {
    window.location.href = "pedido.html";
}


//LogOut
function LogOut() {
    //Borro el array de vuelos que estám en memoria
    //localStorage.removeItem("vuelos");
    window.location.href = "index.html";
}