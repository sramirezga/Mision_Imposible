function crearTabla() {
  var row = document.getElementById("row").value;
  var col = document.getElementById("col").value;

  var codigoNuevaTabla = "<table border='1' >";


if(row < 1 || row > 3 || col <1  || col > 3){
    alert("Tabla no válida")
}else{
for (let i = 0; i < row; i++) {
    codigoNuevaTabla += "<tr>";

    for (let j = 0; j < col; j++) {
      codigoNuevaTabla +=
        "<td> <img src='img/"+i+j+".jpg' width='250px' height='250px'  /></td>";
    }

    codigoNuevaTabla += "</tr>";
  }
}

  

  codigoNuevaTabla += "</table>";
  console.log(codigoNuevaTabla);

  document.getElementById("nuevaTabla").innerHTML = codigoNuevaTabla;
}
