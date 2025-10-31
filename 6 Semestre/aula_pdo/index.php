<?php

if (extension_loaded("pdo") && extension_loaded("pdo_mysql")) {
    echo "PDO e PDO_MYSQL habilitados";
} else {
    echo "Extensões não encontradas";
}

include("config/database.php");

$database = new Database();

echo "<br>";

//var_dump($database->create('usuarios', ["nome" => "Felipe Casali", "email" => "felipe@casali.com", "idade" => "21", "cidade" => "Dourados"]));

//var_dump($database->read("usuarios", [],3,9));

//$database->delete("usuarios", ["idade" => 18]);

//var_dump($database->update("usuarios",["nome"=>"Felipe Casali"]));