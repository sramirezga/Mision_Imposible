<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="fabricantes">    
    <html>
      <head>
        <title>Fabricantes</title>  
      </head>
      <body>
        
        <table border="1">
          <tr> 
            <td colspan="3"> <h1>Fabricantes de coches</h1></td> 
          </tr>
          
          
          <xsl:for-each select="fabricante">
            
            <tr> 
              <td colspan="3" align="center"> 
                <xsl:value-of select="@id"/>
              </td>
            </tr>
            
            
            <tr> 
              <td>
                logo
              </td>  
              
              <td>
                Fundadaor
              </td>
              
              <td>
                Desde
              </td>
            </tr>
            
            
            <tr> 
              <td>
                <img src="images/{@logo}" width="100" height="100"/>
              </td>  
              
              <td>
               <xsl:value-of select="fundador"/>
              </td>
              
              <td>
                <xsl:value-of select="fundador/@desde"/>
              </td>
            </tr>
            
            <tr> 
              <td>
                Año
              </td>  
              
              <td>
                Modelo
              </td>
              
              <td>
                Segmento
              </td>
            </tr>
            
            <xsl:for-each select="modelos/modelo">
            <tr> 
              <td>
                  <xsl:value-of select="inicio"/>
              </td>  
              
              <td>
                  <xsl:value-of select="nombre"/>
              </td>
              
              <td>
                  <xsl:value-of select="segmento"/>
              </td>
            </tr>
            </xsl:for-each>
            
          </xsl:for-each>
          
        </table>
        
        
      </body>
    </html>   
  </xsl:template>
</xsl:stylesheet>
