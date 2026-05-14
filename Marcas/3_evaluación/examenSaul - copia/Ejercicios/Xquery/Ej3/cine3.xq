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
for $actor in $cinema/pelicula/reparto
where $cinema/pelicula/[titulo/idioma = "ingles"]
   return
 <tr>
 <td>{data($cinema/pelicula/titulo)}</td>
 <td>{data($cinema/pelicula/reparto/actor)}</td>
  </tr>
 }
</table>
</body>
</html>