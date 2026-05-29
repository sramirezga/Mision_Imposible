<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="website">
    
    <html>
      <head>
        <title>Peliculas</title>
        <link rel="stylesheet" href="style.css"></link>
      </head>
      <body>
        <div id="padre">
          <img src="{info/logo/@path}" id="logo" />
          <h2>
            <xsl:value-of select="info/name" />
          </h2>
          <p>
            <a href="">
              <xsl:value-of select="info/email" />
              
            </a>
          </p>
          <table>
            <xsl:for-each select="movies/category">
              <tr>
                <td colspan="3" class="c">
                  <xsl:value-of select="@cat" />
                </td>
              </tr>
              <xsl:for-each  select="movie">
                <tr>
                  <td>
                    <img src="{poster}" />
                  </td>
                  
                  <td>
                    <p> Title: <xsl:value-of select="title" />
                    </p>
                    
                    <p> ISBN: <xsl:value-of
                        select="isbn" />
                    </p>
                    
                    <p> Score: <xsl:value-of
                        select="score" />
                    </p> director(s): <input
                      list="directores-{isbn}" />
                    <datalist id="directores-{isbn}">
                      <xsl:for-each select="directors/director">
                        <option value="{.}" />
                      </xsl:for-each>
                    </datalist>
                    <br />  <br />
                    Actor(s): <input list="actores-{isbn}" />
                    <datalist id="actores-{isbn}">
                      <xsl:for-each select="actors/actor">
                        <option value="{.}" />
                      </xsl:for-each>
                    </datalist>
                    
                  </td>
                  
                </tr>
                <tr>
                  <td colspan="3">
                    <hr />
                  </td>
                </tr>
              </xsl:for-each>
              
            </xsl:for-each>
          </table>
        </div>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>