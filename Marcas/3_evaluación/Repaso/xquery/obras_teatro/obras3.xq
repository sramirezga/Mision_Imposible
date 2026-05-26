<html>
<body>
<table>
<tr>
<td>Titulo Obra</td>
</tr>
{ 

for $obra in doc("obras_teatro.xml")/obras_teatro/obra
where $obra/precio < 28 and $obra/detalles/@idioma = "castellano"

return
<tr>
<td> {data($obra/titulo)} </td>
</tr>

}
</table>
</body>
</html>