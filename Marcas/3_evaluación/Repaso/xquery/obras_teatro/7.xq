<html>
<body>
<table>
<tr>
<td>Titulo Obra</td>
</tr>
{ 

for $obra in doc("obras_teatro.xml")/obras_teatro/obra
where $obra/detalles/@idioma = "castellano" or $obra/detalles/@idioma = "euskera"

return
<tr>
<td> {data($obra/@id)} </td>
</tr>

}
</table>
</body>
</html>