
/* let n1 = Number(prompt("Introduce un número"));
let n2 = Number(prompt("Introduce otro número"));
let n3 = Number(prompt("Introduce un ultimo número"));

2, 4, 5

function menor(n1, n2, n3) {

   let menor = n1;

   if (n1 > n2) {
       menor = n2;
   } 
   
   if (n2 > n3) {
       menor = n3;
   }

   document.getElementById("result").innerHTML = menor;
   }


   menor(n1,n2,n3); */

/* ----------------------------------2----------------------------------



let longitud = Number(prompt("Introduce la longitud de un cuadrado"));

function long(longitud){

    let perimetro = longitud * 4;

    document.getElementById("result").innerHTML = perimetro;

}

long(longitud);  */


/* ----------------------------3 ------------------------- 


let n = Number(prompt("Introduce un número"));

function parImpar(n){

if(n == 0){
     document.getElementById("result").innerHTML = "El número es cero"
}else if( n % 2 == 0){
   document.getElementById("result").innerHTML = "El número" + n + " es par.";
}else{
document.getElementById("result").innerHTML = "El " + n + " es impar."
}

} 

parImpar(n);*/


let n1 = Number(prompt("Introduce un número"));
let n2 = Number(prompt("Introduce un número"));
let operador = prompt("Introduce un operador");


function operacion(n1, n2, operador) {


    switch (operador) {
        case "+":
            return console.log(n1 + n2);
            break;
        case "-":
            return console.log(n1 - n2)
            break;

        case "*":
            return console.log(n1 + n2)
            return n1 * n2;
            break;

        case "/":
            if (n2 === 0) {
                alert("No se puede dividir por cero");
            } else {
                return n1 / n2;
            }
            break;
    }
}

operacion(n1, n2, operador)
