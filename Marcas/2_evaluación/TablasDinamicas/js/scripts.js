

function crearTabla() {


  let row = document.getElementById("row").value;
  let col = document.getElementById("col").value;

  let crearTabla = "<table>";


  if ((row <= 0 || row > 3) || (col <= 0 || col > 3)) {
    alert("Cantidad no válida");

  } else {

    for (let i = 0; i < row; i++) {

      crearTabla += "<tr>";
      for (let j = 0; j < col; j++) {

        crearTabla += "<td> <img src='img/" + i + j+".jpg' width='250px' height='250px'> </td> ";
        
      }

      crearTabla += "</tr>"

    }

    crearTabla += "</table>";
    console.log(crearTabla);


  }


  document.getElementById("nuevaTabla").innerHTML = crearTabla;



}