<html>
<body>
<table>
<tr>
<td>Titulo Obra</td>
</tr>
{ 

for $obra in doc("obras_teatro.xml")/obras_teatro/obra
where $obra/premios < 3 and $obra/personajes > 2 and $obra/personajes < 8

return
<tr>
<td> {data($obra/titulo)} </td>
</tr>

}
</table>
</body>
</html>