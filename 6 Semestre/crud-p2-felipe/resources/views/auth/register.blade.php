<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastrar</title>
</head>
<body>
    <form action="{{ route('auth.store') }}" method="POST">
        @csrf
        <label>Nome</label>
        <input name="name" type="text" min="3" max="30" placeholder="Nome" required>
        <label>E-mail</label>
        <input name="email" type="email" max="30" placeholder="E-mail" required>
        <label>Senha</label>
        <input name="password" type="password" min="8" max="30" placeholder="Senha" required>
        <input type="submit" value="Cadastrar">
    </form>
    <a href="{{ route('auth.login') }}">Login</a>
</body>
</html>