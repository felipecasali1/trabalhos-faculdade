<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body class="bg-light d-flex justify-content-center align-items-center vh-100">

    <div class="card shadow p-4" style="width: 100%; max-width: 400px;">
        <h3 class="text-center mb-4">Login</h3>

        <form action="{{ route('auth.authenticate') }}" method="POST">
            @csrf

            <div class="mb-3">
                <label class="form-label">E-mail</label>
                <input 
                    name="email" 
                    type="email" 
                    class="form-control" 
                    placeholder="Digite seu e-mail" 
                    required
                >
            </div>

            <div class="mb-3">
                <label class="form-label">Senha</label>
                <input 
                    name="password" 
                    type="password" 
                    class="form-control" 
                    placeholder="Digite sua senha" 
                    required
                >
            </div>

            <button type="submit" class="btn btn-primary w-100">
                Entrar
            </button>
        </form>

        <div class="text-center mt-3">
            <a href="{{ route('auth.register') }}" class="text-decoration-none">
                Criar uma conta
            </a>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>