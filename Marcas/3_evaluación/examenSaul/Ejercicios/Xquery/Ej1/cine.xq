<html>
<body>
<table border="1">
<tr>
<td colspan="3" align="center">CINEMA</td>
</tr>
<tr>
<td >Titulo</td>
<td>Director</td>
<td>Fecha estreno</td>
</tr>
{
for $pelicula in doc("cinema.xml")/cinema/pelicula
   return
 <tr>
 <td>{data($pelicula/titulo)}</td>
 <td>{data($pelicula/director)}</td>
  <td>{data($pelicula/estreno)}</td>
  </tr>
 }
</table>
</body>
</html>