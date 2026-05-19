


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
        if (usuario == usuarios[i].username) {
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

function anadirVuelo(){


let tabla = "<table>";
tabla +=  "<td> Origen  <td>";
tabla +=  "<td>  Destino <td>";
tabla +=  "<td> Precio <td>";
tabla +=  "</tr>";


let ciudad = document.getElementById("departure_city").value;
let destino = document.getElementById("destination_city").value;
let precio = document.getElementById("flight_price").value;


if(ciudad != null && destino != null && precio > 0){

for(let i = 0; i < ){

}


}





tabla += "</table>";


document.getElementById("display").innerHTML = tabla;

}

//LogOut
function LogOut() {
    window.location.href = "index.html";
}