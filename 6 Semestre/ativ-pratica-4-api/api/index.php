<?php
    include("../../aula_pdo/config/database.php");

    $database = new Database();

    header('Content-Type: application/json; charset=utf-8');
    header('Access-Control-Allow-Origin: *');
    header('Access-Control-Allow-Methods: GET, POST, PUT, DELETE, OPTIONS');
    header('Access-Control-Allow-Headers: Content-Type, Authorization');

    if($_SERVER["REQUEST_METHOD"] === "GET") {
        $usuarios = $database->read("usuarios");
        if($usuarios["success"] !== false) {
            echo json_encode(
                [
                    'success' => true,
                    'data' => $usuarios,
                    'message' => 'Usuários recuperados com sucesso!'
                ],
                JSON_PRETTY_PRINT | JSON_UNESCAPED_UNICODE
            );
        } else {
            echo json_encode(
                [
                    'success' => false,
                    'data' => null,
                    'message' => 'Erro ao recuperar usuários!'
                ],
                JSON_PRETTY_PRINT | JSON_UNESCAPED_UNICODE
            );
        }
    } else if($_SERVER["REQUEST_METHOD"] === "POST") {
        $input = $_POST;

        switch ($input["tipo"]) {
            case 'insert':
                $resposta = $database->create(
                    "usuarios",
                    [
                        "nome" => $input["nome"],
                        "email" => $input["email"],
                        "senha" => md5($input["senha"]),
                        "idade" => $input["idade"],
                        "cidade" => $input["cidade"]
                    ]
                );
                if($resposta["success"] !== false) {
                    echo json_encode(
                        [
                            'success' => true,
                            'data' => $resposta,
                            'message' => 'Usuário inserido com sucesso!'
                        ],
                        JSON_PRETTY_PRINT | JSON_UNESCAPED_UNICODE
                    );
                } else {
                    echo json_encode(
                        [
                            'success' => false,
                            'data' => null,
                            'message' => $resposta["message"]
                        ],
                        JSON_PRETTY_PRINT | JSON_UNESCAPED_UNICODE
                    );
                }
                exit();
            case 'update':
                if(empty($input["id"])) {
                    echo json_encode(
                        [
                            "success" => false,
                            "message" => "Id necessário para atualização!"                            
                        ],
                        JSON_PRETTY_PRINT | JSON_UNESCAPED_UNICODE
                    );
                } else {
                    $dadosAtualizados = [
                        "nome" => $input["nome"],
                        "email" => $input["email"],
                        "idade" => $input["idade"],
                        "cidade" => $input["cidade"]
                    ];

                    if (!empty($input["senha"])) {
                        $dadosAtualizados["senha"] = md5($input["senha"]);
                    }

                    $resposta = $database->update(
                        "usuarios",
                        $dadosAtualizados,
                        ["id" => $input["id"]]
                    );

                    if ($resposta["success"] !== false) {
                        echo json_encode([
                            "success" => true,
                            "data" => $resposta,
                            "message" => "Usuário atualizado com sucesso"
                        ], JSON_PRETTY_PRINT | JSON_UNESCAPED_UNICODE);
                    } else {
                        echo json_encode([
                            "success" => false,
                            "data" => null,
                            "message" => $resposta["message"]
                        ], JSON_PRETTY_PRINT | JSON_UNESCAPED_UNICODE);
                    }
                }
                exit();
            case 'delete':
                if(empty($input["id"])) {
                    echo json_encode(
                        [
                            "success" => false,
                            "message" => "Id necessário para remoção!"                            
                        ],
                        JSON_PRETTY_PRINT | JSON_UNESCAPED_UNICODE
                    );
                } else {
                    $resposta = $database->delete(
                        "usuarios",
                        ["id" => $input["id"]]
                    );

                    if ($resposta["success"] !== false) {
                        echo json_encode([
                            "success" => true,
                            "data" => $resposta,
                            "message" => "Usuário atualizado com sucesso"
                        ], JSON_PRETTY_PRINT | JSON_UNESCAPED_UNICODE);
                    } else {
                        echo json_encode([
                            "success" => false,
                            "data" => null,
                            "message" => $resposta["message"]
                        ], JSON_PRETTY_PRINT | JSON_UNESCAPED_UNICODE);
                    }
                }
                exit();
            default:
                echo "Erro! Opção inválida!";
                exit();
        }
    }
?>
