<html>
<body>
<table border="1">

<tr>
   <td align="center" colspan="4">Cinema</td>
</tr>  

<tr>  
   <td>Titulo</td>
   <td>Director</td>
   <td>Fecha estreno</td>
   <td>Idioma</td>
</tr>

{
for $pelicula in doc("cinema.xml")/cinema/pelicula
where $pelicula/@categoria = "accion"

return
<tr>  
   <td>{data($pelicula/titulo)}</td>
   <td>{data($pelicula/director)}</td>
   <td>{data($pelicula/estreno)}</td>
   <td>{data($pelicula/titulo/@idioma)}</td>
</tr>

  
}
</table>
</body>
</html>