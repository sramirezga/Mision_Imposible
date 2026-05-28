for $obra in doc("obras_teatro.xml")/obras_teatro/obra
where $obra/detalles/@idioma = "euskera"
return


$obra/titulo/text()