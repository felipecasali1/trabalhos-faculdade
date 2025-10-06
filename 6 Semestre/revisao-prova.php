<?php 
    echo date('d/m/Y') . "\n";  // .  para concatenar

    define("PHP", "Linguagem Open Source");
    echo PHP . "\n";

    $array = array(1 => "Felipe", "chave" => "valor");
    echo $array["chave"] . "\n";

    // === representa igualdade de valor e tipo de dado
    
    $array = array(0,1,2,3,4,5,6,7,8,9);
    foreach($array as $key => $value) {
        echo $key . " - " .  $value . "\n";
    }

    function printNumber($number) {
        echo "O número é: " . $number;
    }

    // variaveis superglobais
    // $GLOBALS
    // $_SERVER
    // $_REQUEST
    // $_POST
    // $_GET
    // $_COOKIE
    // $_SESSION

    $valor = 5;
    function exemploEscopo() {
        global $valor;
        $valor = 10;
        echo $valor. "\n";
        echo $GLOBALS["valor"] . " globals \n";
    }
    echo $valor. "\n";
    exemploEscopo();
    echo $valor. "\n";
?>