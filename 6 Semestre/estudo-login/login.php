<?php  
    session_start();

    $msg = "";

    if (!isset($_SESSION['isLoggedIn'])) {
        $_SESSION['isLoggedIn'] = false;
    }

    if (!isset($_SESSION['users'])) {
        $_SESSION['users'] = [];
    } else {
        if ($_SERVER['REQUEST_METHOD'] === 'POST') {
            if (isset($_POST['username']) || isset($_POST['password'])) {
                if (!empty(trim($_POST['username'])) && !empty(trim($_POST['password']))) {
                    $found = false;
                    foreach ($_SESSION['users'] as $user) {
                        if ($user['username'] === $_POST['username'] && $user['password'] === $_POST['password']) {
                            $_SESSION['isLoggedIn'] = true;
                            $msg = "Bem-vindo, " . $_POST['username'] . "!";
                            $found = true;
                            break;
                        }
                    }
                    if (!$found) {
                        $msg = "Usuário ou senha inválidos!";
                    }
                } else {
                    $msg = "Erro no login! Preencha os dados corretamente!";
                }
            }
        }        
    }
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>
<body>
    <h2>Fazer Login</h2>
    <form action="" method="POST">
        <input type="text" name="username" placeholder="Usuário" required>
        <input type="password" name="password" placeholder="Senha" required>
        <input type="submit" value="Login">
    </form>

    <form action="" method="POST">
        <input type="hidden" name="logoff">
        <input type="submit" value="Logoff">
    </form>

    <?php if (!empty($msg)): ?>
        <h2><?php echo htmlspecialchars($msg); ?></h2>
    <?php endif; ?>
</body>
</html>