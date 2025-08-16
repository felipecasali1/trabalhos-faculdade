<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Jornal do Dia</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: #f4f4f9;
            color: #333;
            margin: 0;
            padding: 0;
            height: 100vh;
        }
        header {
            background: #222;
            color: white;
            padding: 25px;
            text-align: center;
            font-size: 2.5rem;
            font-weight: bold;
            font-style: italic;
        }
        main {
            max-width: 800px;
            margin: 40px auto;
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
            text-align: center;
        }
        h2 {
            color: #444;
        }
        footer {
            background: #e4e4e4ff;
            color: black;
            padding: 25px;
            text-align: center;
            font-weight: bold;
            font-size: 1.2rem;
            position: fixed;
            bottom: 0;
            font-style: italic;
            width: 100%;
        }
        </style>
</head>
<body>
    <header>
        Jornal do Dia
    </header>
    <main>
        <?php
            include("content.php");
            echo "<h2>$noticiaAleatoria</h2>";
        ?>
    </main>
    <footer>
        Desenvolvido por Felipe Casali - 802.483
    </footer>
</body>
</html>
