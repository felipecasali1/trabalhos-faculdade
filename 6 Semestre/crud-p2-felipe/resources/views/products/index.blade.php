<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Produtos</title>
</head>
<body>
    <h1>Página de Produtos</h1>
    <form action="{{ route('auth.logout') }}" method="POST">
        @csrf
        <input type="submit" value="Logout">
    </form>
</body>
</html>