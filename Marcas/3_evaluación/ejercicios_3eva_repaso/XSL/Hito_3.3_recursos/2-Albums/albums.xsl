<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="collection">

    <html>

      <head>
        <title>Collections</title>
        <link rel="stylesheet" href="css/style.css" />
      </head>
      <body>
        <center>
          <div>
            <h1>Album collections</h1>
            <table id="tabla">
              <xsl:for-each select="album">
                <tr>
                  <td colspan="4" class="banda">
                    <b>
                      <xsl:value-of select="band" />
                    </b>
                  </td>
                </tr>

            <tr>
                  <td>
                    <img src="{cover/@path}" />
                  </td>
                  <td>Title: <xsl:value-of select="title" />
                  </td>
                  <td>Year: <xsl:value-of select="title/@year" />
                  </td>
                  <td>
                    <input type="text" list="tracks" />
                    <datalist id="tracks">
                      <xsl:for-each select="tracks/track">
                        <option value="{.}" />
                      </xsl:for-each>
                    </datalist>
                  </td>
                </tr>

              </xsl:for-each>
            </table>
          </div>
        </center>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>