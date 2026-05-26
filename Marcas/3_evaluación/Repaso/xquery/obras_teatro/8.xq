<html>
<body>
<table>
<tr>
<td>Titulo Obra</td>
</tr>
{ 

for $obra in doc("obras_teatro.xml")/obras_teatro/obra
where $obra/director = "Peio Perez"

return
<tr>
<td> {data($obra/detalles/@idioma)} </td>
</tr>

}
</table>
</body>
</html>