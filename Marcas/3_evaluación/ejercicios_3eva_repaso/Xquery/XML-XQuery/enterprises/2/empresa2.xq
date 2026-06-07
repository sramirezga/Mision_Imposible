

<html>
<body>
<table border ="1">

<tr>
<td>Nombre Empresa</td>
<td>Pais</td>
<td>Provincia</td>
<td>Ciuda</td>
<td>Direccion</td>
</tr>
{

for $empresa in doc("enterprises.xml")/enterprises/enterprise
where $empresa/location/province = "Gipuzkoa"

return
<tr>
<td>{data($empresa/name)}</td>
<td>{data($empresa/location/country)}</td>
<td>{data($empresa/location/province)}</td>
<td>{data($empresa/location/city)}</td>
<td>{data($empresa/location/address)}</td>
</tr>
}
</table>
</body>
</html>