

<html>
<body>
<table border ="1">

<tr>
<td>Nombre Empresa</td>
<td>Nombre Contacto</td>
<td>Telefono</td>
<td>Movil</td>
<td>Correo electronico</td>
</tr>
{

for $empresa in doc("enterprises.xml")/enterprises/enterprise
where $empresa/contact/person = "Maddi Azkargorta"

return
<tr>
<td>{data($empresa/name)}</td>
<td>{data($empresa/contact/person)}</td>
<td>{data($empresa/contact/phone)}</td>
<td>{data($empresa/contact/mobile)}</td>
<td>{data($empresa/contact/email)}</td>
</tr>
}
</table>
</body>
</html>