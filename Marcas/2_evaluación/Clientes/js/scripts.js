


async function cargarDatosClientes() {

    const respuesta = await fetch("json/clientes.json")
    const clientes = await respuesta.json();

    // console.log(clientes[1].nombre);

    let crearTabla = "<table border='1'>";
    crearTabla += "<tr>";
    crearTabla += "<td>ID</td>";
    crearTabla += "<td>Nombre</td>";
    crearTabla += "<td>Email</td>";
    crearTabla += "<td>Teléfono</td>";
    crearTabla += "</tr>";
    

    for (i = 0; i < clientes.length; i++) {
        crearTabla += "<tr>";
       crearTabla += "<td> " + clientes[i].id + "</td>";
       crearTabla += "<td> " + clientes[i].nombre + "</td>";
       crearTabla += "<td> " + clientes[i].email + "</td>";
       crearTabla += "<td> " + clientes[i].telefono + "</td>";
        crearTabla += "</tr>";
    }

    
    crearTabla += "</table>";


    document.getElementById("tablaContainer").innerHTML = crearTabla;

    document.getElementById("cargarDatos").disabled = true;






}