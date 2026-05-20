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
        //Guardo en memoria el usuario actual
        localStorage.setItem("usuarioActual", usuario);
        window.location.href = "registro_vuelos.html"
    } else if (encontrado) {
        localStorage.setItem("usuarioActual", usuario);
        window.location.href = "reserva_vuelos.html"
    } else {
        alert("Usuario o contraseña incorrecta inténtelo otra vez!")
    }

}

//Añadir vuelo
function anadirVuelo() {
    //Valores de los input para añadir vuelos
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

        //Compruebo si ya hay vuelos guardadados en local store
        if (localStorage.getItem("vuelos") == null) {
            //Si no hay creo array para hacer push del nuevo_vuelo
            vuelos = [];
        } else {
            //Si hay, los convierto en un array para hacer push del nuevo_vuelo
            vuelos = JSON.parse(localStorage.getItem("vuelos"));
        }

        vuelos.push(nuevo_vuelo);

        //Covierto el array a string "local store guarda texto"
        localStorage.setItem("vuelos", JSON.stringify(vuelos));

        
        alert("Vuelo añadido");
        //Muestra el vuelo añadido
        mostrarVuelosAdmin();

    } else {
        alert("El precio tiene que ser mayor que 0")
    }

}

//Mostra vuelos Admin
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
            tabla += "<td>" + vuelos[i].precio + "€  <td>";
            tabla += "</tr>";
        }

        tabla += "</table>";

        //Pinto la tabla en el elmento con este id
        document.getElementById("display").innerHTML = tabla;
    }
}

//Mostra vuelos disponibles en usuarios
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
            tabla += "<td>" + vuelos[i].precio + "€ <td>";
            tabla += "<td><input type='number' id='cantidad-" + i + "' min='1' max='5'><td>";
            tabla += "<td><button onclick='anadirCantidadVuelos(" + i + ")'>Añadir</button><td>";
            tabla += "</tr>";
        }

        tabla += "</table>";

        //Pinto la tabla en el elmento con este id
        document.getElementById("vuelosDisponibles").innerHTML = tabla;
    }




}

//cantidad de vuelos
function anadirCantidadVuelos(i) {

    //Obtengo los vuelos
    let vuelos = JSON.parse(localStorage.getItem("vuelos"));

    //guardo que vuelo esta seleciionaddo
    let vueloElegido = vuelos[i];

    //obtengo la cantidad de billetes
    let cantidad = document.getElementById("cantidad-" + i).value;


    let usuarioActual = localStorage.getItem("usuarioActual");
    let clavePedidos = "pedidos-" + usuarioActual;

    if (cantidad < 1) {
        // alert("entra");
        alert("La cantidad debe ser mayor a cero")
    } else {
        // alert("entra");

        //Creo el objeto pedido con el vuelo elegido
        let nuevo_pedido = {
            origen: vueloElegido.origen,
            destino: vueloElegido.destino,
            precio: vueloElegido.precio,
            cantidad: cantidad,
        };


        let pedidos;

        if (localStorage.getItem(clavePedidos) == null) {
            //Si no hay pedidos creo el array vacio
            pedidos = [];
        } else {
            //si hay pedidos recupero el arrayu de pedidos
            pedidos = JSON.parse(localStorage.getItem(clavePedidos));
        }

        //add nuevo_pedido
        pedidos.push(nuevo_pedido);

        //Coverto el array a string
        localStorage.setItem(clavePedidos, JSON.stringify(pedidos));


        alert("Tu pedido ha sido correctamente añadido");
    }
}

//Muestro pedidos reservador por cada usuario
function mostrarVuelosReservador() {

    //Obtengo el usuario de memoria 
    let usuarioActual = localStorage.getItem("usuarioActual");
    // clave para saber los pedidos del usuario actual
    let clavePedidos = "pedidos-" + usuarioActual;

    //Convierto a array los peddidos del usuario actual
    let pedidos = JSON.parse(localStorage.getItem(clavePedidos));


    if (pedidos == null) {
        alert("No tienes vuelos reservados.");
    } else {
        let tabla = "<table>";
        tabla += "<tr>";
        tabla += "<td>Origen</td>";
        tabla += "<td>Destino</td>";
        tabla += "<td>Precio</td>";
        tabla += "<td>Cantidad</td>";
        tabla += "<td>Total</td>";
        tabla += "</tr>";
        tabla += "<hr>";


        let totalApagar = 0;


        for (let i = 0; i < pedidos.length; i++) {
            //Subtotal de cada pedido
            let subTotal = pedidos[i].precio * pedidos[i].cantidad;
            //Sumo cada subtotal de cada pedido
            totalApagar += subTotal;

            tabla += "<tr>";
            tabla += "<td>" + pedidos[i].origen + "</td>";
            tabla += "<td>" + pedidos[i].destino + "</td>";
            tabla += "<td>" + pedidos[i].precio + "€</td>";
            tabla += "<td>" + pedidos[i].cantidad + "</td>";
            tabla += "<td>" + subTotal + "€</td>";
            tabla += "</tr>";
        }

        tabla += "<tr>";
        tabla += "<td></td>";
        tabla += "<td></td>";
        tabla += "<td></td>";
        tabla += "<td>TOTAL A PAGAR</td>";
        tabla += "<td>" + totalApagar + "€</td>";
        tabla += "</tr>";

        tabla += "</table>";
        //Pinto en el elemento con este id
        document.getElementById("flight_table").innerHTML = tabla;
    }

}

//Pago
function pago() {
    window.location.href = "pedido.html";
}

//LogOut
function LogOut() {
    //Borro el array de vuelos que están en memoria    
    //localStorage.removeItem("vuelos");


    //borro el array de pedidos por cada usuario
    /*let usuarioActual = localStorage.getItem("usuarioActual");
    let clavePedidos = "pedidos-" + usuarioActual;    
    localStorage.removeItem(clavePedidos); */

    window.location.href = "index.html";
}



