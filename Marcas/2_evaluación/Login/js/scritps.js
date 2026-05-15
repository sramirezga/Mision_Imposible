


async function login() {

    const resp = await fetch("json/usuarios.json");

    const usuarios = await resp.json();


    let nombreUsuario = document.getElementById("nombre").value;
    //alert(nombreUsuario);
    let passUsuario = document.getElementById("password").value;
    //alert(pass);



    let encontrado = false;
    let esAdmin = false;

    for (let i = 0; i < usuarios.length; i++) {
        if (nombreUsuario == usuarios[i].usuario && passUsuario == usuarios[i].password) {
            encontrado = true;

            if (usuarios[i].usuario == "admin") {
                esAdmin = true;
            }
        }
    }

    if (encontrado && esAdmin) {
        window.location.href = "inicio_admin.html";
    } else if (encontrado) {
        window.location.href = "inicio_general.html";
    } else {
        alert("Credeciales no válidas")
    }


}