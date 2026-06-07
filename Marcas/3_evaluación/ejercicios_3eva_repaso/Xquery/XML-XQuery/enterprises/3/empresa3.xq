

<html>
<body>
<table border ="1">

<tr>
<td>Nombre Empresa</td>
<td>Tipo</td>
<td>Facturacion</td>
<td>Persona Contacto</td>
<td>Telefono</td>
<td>Movil</td>
<td>Email</td>
</tr>
{

for $empresa in doc("enterprises.xml")/enterprises/enterprise
where $empresa/sector = "Building"

return
<tr>
<td>{data($empresa/name)}</td>
<td>{data($empresa/type)}</td>
<td>{data($empresa/billing)}</td>
<td>{data($empresa/contact/person)}</td>
<td>{data($empresa/contact/phone)}</td>
<td>{data($empresa/contact/mobile)}</td>
<td>{data($empresa/contact/email)}</td>
</tr>
}
</table>
</body>
</html>