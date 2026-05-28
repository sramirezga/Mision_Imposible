<html>
<body>
<table>
<tr>
<td>id obra</td>
</tr>
{
for $obra in doc("obras_teatro.xml")/obras_teatro/obra
where $obra/director = "Peio Perez" and $obra/premios > 1 and $obra/detalles/@idioma = "euskera"
  
return
<tr>
<td>{data($obra/@id)}</td>
</tr>
}
</table>
</body>
</html>