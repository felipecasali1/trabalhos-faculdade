<?php  
    session_start();

    if (!isset($_SESSION['isLoggedIn'])) {
        $_SESSION['isLoggedIn'] = false;
    }

    if (!isset($_SESSION['users'])) {
        $_SESSION['users'] = [];
    }
    
    if ($_SERVER['REQUEST_METHOD'] === 'POST') {
        if (isset($_POST['username']) || isset($_POST['email']) || isset($_POST['password'])) {
            if (!empty($_POST['username']) && !empty($_POST['email']) && !empty($_POST['password'])) {
                $_SESSION['users'][] = [
                    "username"=>$_POST['username'],
                    "email"=>$_POST['email'],
                    "password"=>$_POST['password']
                ];
                $_SESSION['isLoggedIn'] = true;
            }
        }
        if (isset($_POST['logoff'])) {
            session_unset();
            session_destroy();
            $_SESSION['isLoggedIn'] = false;
            header("Location: ".$_SERVER['PHP_SELF']);
            exit;
        }
    }
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro</title>
</head>
<body>
    <h2>Cadastro</h2>
    <form action="" method="POST">
        <input type="text" name="username" placeholder="Nome" required>
        <input type="email" name="email" placeholder="E-mail" required>
        <input type="password" name="password" placeholder="Senha" required>
        <input type="submit" value="Enviar">
    </form>

    <form action="" method="POST">
        <input type="hidden" name="logoff">
        <input type="submit" value="Logoff">
    </form>

    <?php if($_SESSION['isLoggedIn']):?>    
        <h2>Cadastro Realizado!</h2>
    <?php endif; ?>
</body>
</html>