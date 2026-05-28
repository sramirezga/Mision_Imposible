<html>
<body>
<table border="1">
<tr>
<td colspan="3">Obras de teatro programada</td>
</tr>
<tr style="font-weight: bold;">
<td>Titulo</td>
<td>Director</td>
<td>Numero personajes</td>
</tr>
{
for $obra in doc("obras_teatro.xml")/obras_teatro/obra

  
return
<tr>
<td>{data($obra/titulo)}</td>
<td>{data($obra/director)}</td>
<td>{data($obra/personajes)}</td>
</tr>
}
</table>
</body>
</html>