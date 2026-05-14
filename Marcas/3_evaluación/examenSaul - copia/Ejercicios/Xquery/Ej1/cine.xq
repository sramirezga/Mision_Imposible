<html>
<body>
<table>
<tr>CINEMA</tr>
<tr>
<td >Titulo</td>
<td>Director</td>
<td>Fecha estreno</td>
</tr>
{
for $cinema in doc/("cinema.xml")/pelicula
   return
 <tr>
 <td>{data($cinema/pelicula/titulo)}</td>
 <td>{data($cinema/pelicula/director)}</td>
  <td>{data($cinema/pelicula/estreno)}</td>
  </tr>
 }
</table>
</body>
</html>