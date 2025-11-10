<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>
<body>
    <form action="{{ route('auth.authenticate') }}" method="POST">
        @csrf
        <label>E-mail</label>
        <input name="email" type="email" max="30" placeholder="E-mail" required>
        <label>Senha</label>
        <input name="password" type="password" min="8" max="30" placeholder="Senha" required>
        <input type="submit" value="Cadastrar">
    </form>
    <a href="{{ route('auth.register') }}">Cadastrar</a>
</body>
</html>