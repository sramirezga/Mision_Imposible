<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="gimnasio">
  <html>
      <head>
            <title>Gimnasio Zubiri</title>
      </head>  
      <body bgcolor="#bbdddd" style="text-align:center">
          <img src="{info/logo}" width="75" height="75"/>
          <h1><xsl:value-of select="info/gim_nombre"/></h1>
          <h3> <xsl:value-of select="info/direccion"/></h3>
          <h3> <a href="{info/web}"><xsl:value-of select="info/web"/></a></h3>
           <h1>Socios</h1>
           <table border="0" bgcolor="white" style="margin:auto">
           <xsl:for-each select="./socios/socio">
              <tr bgcolor="#cccccc">
                  <td rowspan="2"  bgcolor="white"><img src="{./foto}" width="80" height="100"/></td>
                  <td><xsl:value-of select="./nombre"/></td>
                  <td><xsl:value-of select="./apellido"/></td>
              </tr>
              <tr>
                    <td><xsl:value-of select="direccion"/></td>
                    <td><b>Código socio: </b><xsl:value-of select="@idsocio"/></td>
              </tr>
              <tr bgcolor="#cccccc">
                   <td><b>Teléfono</b></td>
                    <td colspan="2"><b>Email</b></td>
              </tr>
              <tr>
                  <td><xsl:value-of select="contacto/telefonos/numero_telefono"/></td>
                   <td colspan="2"><xsl:value-of select="contacto/emails/email"/></td>
              </tr>
              <tr bgcolor="#cccccc">
                  <td><b>Deportes</b></td>
                  <td colspan="2"><b>Sesiones</b></td>
              </tr>
              <xsl:for-each select="deportes/deporte">
                  <tr>
                      <td><xsl:value-of select="@nombredeporte"/></td>
                      <td>
                          <input list="{../../@idsocio}{.}"/>
                          <datalist id="{../../@idsocio}{.}">
                                <xsl:for-each select="./date">
                                      <option value="{.}"/>
                                </xsl:for-each>
                          </datalist>
                      </td>
                  </tr>
              </xsl:for-each>
              <tr bgcolor="#128943"><td colspan="3" height="7px" ></td></tr>
           </xsl:for-each>
           </table>
      </body>
  </html>
  </xsl:template>
</xsl:stylesheet>