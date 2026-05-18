

//LogIn
async function login() {

const rest = await fetch("json/cuentas.json");
const cuentas = await rest.json();

console.log(cuentas)

let usuario = document.getElementById("usuario").value;
let password = document.getElementById("password").value;

let esAdmin = false;
let encontrado = false;


for(let i = 0; i < cuentas.length; i++){

if(usuario == cuentas[i].usuario  && password == cuentas[i].password){
    encontrado = true;

    if(cuentas[i].usuario == "admin") {
    esAdmin = true;
}
}



}


if(encontrado && esAdmin){
    window.location.href = "administrador.html";
}else if(encontrado){
window.location.href = "catalogo.html";
}else{
    alert("Credenciales no válidas")
}


}

//LogOut
function logOut(){
        window.location.href = "index.html";
}

async function catalogo(){
const rest = await fetch("json/catalogo.json");
const bicicleta = await rest.json();

let tabla = "<table>";
tabla += "<tr>";
tabla += " <td>BICICLETA</td>";
tabla += " <td>PRECIO</td>";
tabla += " <td>COLOR</td>";
tabla += " <td>IMAGEN</td>";

tabla += "</tr>";

for(let i = 0; i < bicicleta.length; i++){

tabla += "<tr>";
tabla += " <td>" + bicicleta[i].nombre_bicicleta + "</td>";
tabla += " <td>" + bicicleta[i].precio + "</td>";
tabla += " <td>" + bicicleta[i].color + "</td>";
tabla += " <td><img src='images/" + bicicleta[i].imagen + "'> </td>";
tabla += "</tr>";

}



tabla += "</table>";

document.getElementById("tabla").innerHTML = tabla;

}

catalogo();

