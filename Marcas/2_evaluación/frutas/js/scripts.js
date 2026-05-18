

async function todasLasFrutas() {

    const rest = await fetch("json/frutas.json");

    const frutas = await rest.json();


    let tabla = "<table border='1'>";
    tabla += "<tr>";
    tabla += "<td>ID</td>";
    tabla += "<td>Nombre</td>";
    tabla += "<td>Precio</td>";
    tabla += "<td>Unidad</td>";
    tabla += "<td>Stock</td>";
    tabla += "<td>Categoria</td>";
    tabla += "<td>Origen</td>";
    tabla += "</tr>";

    for (let i = 0; i < frutas.length; i++) {
        tabla += "<tr>";
        tabla += "<td>" + frutas[i].id + "</td>";
        tabla += "<td>" + frutas[i].nombre + "</td>";
        tabla += "<td>" + frutas[i].precio + "</td>";
        tabla += "<td>" + frutas[i].unidad + "</td>";
        tabla += "<td>" + frutas[i].stock + "</td>";
        tabla += "<td>" + frutas[i].categoria + "</td>";
        tabla += "<td>" + frutas[i].origen + "</td>";
        tabla += "</tr>";
    }


    tabla += "</table>";

    document.getElementById("tabla").innerHTML = tabla

}


async function filtrarFrutas() {

    const rest = await fetch("json/frutas.json");

    const frutas = await rest.json();

    let pais = document.getElementById("caja").value;


    let tabla = "<table border='1'>";
    tabla += "<tr>";
    tabla += "<td></td>";
    tabla += "<td>Nombre</td>";
    tabla += "<td>Precio</td>";
    tabla += "<td>Unidad</td>";
    tabla += "<td>Stock</td>";
    tabla += "<td>Categoria</td>";
    tabla += "<td>Origen</td>";
    tabla += "</tr>";

    for (let i = 0; i < frutas.length; i++) {


        if (pais.toLowerCase().trim() === frutas[i].origen.toLowerCase().trim()) {
            tabla += "<tr>";
            tabla += "<td>" + frutas[i].id + "</td>";
            tabla += "<td>" + frutas[i].nombre + "</td>";
            tabla += "<td>" + frutas[i].precio + "</td>";
            tabla += "<td>" + frutas[i].unidad + "</td>";
            tabla += "<td>" + frutas[i].stock + "</td>";
            tabla += "<td>" + frutas[i].categoria + "</td>";
            tabla += "<td>" + frutas[i].origen + "</td>";
            tabla += "</tr>";
        }

    }


    tabla += "</table>";

    document.getElementById("tabla").innerHTML = tabla

}