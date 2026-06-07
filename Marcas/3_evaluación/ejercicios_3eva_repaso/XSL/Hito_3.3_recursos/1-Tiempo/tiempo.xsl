<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="day">

    <html>
      <body>

        <h1>Pronostico del tiempo para donostia</h1>
        <table>

          <xsl:for-each select="forecasts/forecast"> 
            <tr>
              <td rowspan="3">
                <img src="images/{symbol/icon}.png" width="100" height="100" />
              </td>
              <td>Fecha:
                <xsl:value-of select="@period"/>
              </td>
              <td>Fecha/Hora:
                <xsl:value-of select="@date"/>
              </td>
              <td>Temperatura Max: 
                <xsl:value-of select="tempMax"/>
              </td>
              <td> Temperatura Min: 
                <xsl:value-of select="tempMin"/>
              </td>
            </tr>

            <tr>
              <td colspan="4">
                <xsl:value-of select="description/es"/>
              </td>
            </tr>

            <tr>
              <td colspan="4">
                <xsl:value-of select="description/eu"/>
              </td>
            </tr>

            <tr>
              <td colspan="5">
                <hr/>
              </td>
            </tr>

          </xsl:for-each>


        </table>
      </body>
    </html>


  </xsl:template>
</xsl:stylesheet>