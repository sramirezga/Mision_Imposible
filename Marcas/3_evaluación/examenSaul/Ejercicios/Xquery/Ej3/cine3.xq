<html>
<body>
<table border="1">
<tr>
<td colspan="2" align="center">CINEMA</td>
</tr>
<tr>
<td >Titulo</td>
<td>Actores</td>
</tr>
{
for $pelicula in doc("cinema.xml")/cinema/pelicula
where $pelicula/titulo/@idioma = "ingles"
   return
 <tr>
 <td>{data($pelicula/titulo)}</td>
 <td>{data($pelicula/reparto/actor)}</td>
  </tr>
 }
</table>
</body>
</html>