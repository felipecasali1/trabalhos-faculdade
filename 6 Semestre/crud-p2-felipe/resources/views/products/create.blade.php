<html lang="en">
<head>
    <meta charset="UTF-8"   >
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Criar Produto</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body class="bg-light">

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark px-4">
        <a class="navbar-brand" href="{{ route('products.index') }}">Controle de Produtos</a>
    </nav>

    <div class="container mt-5">
        <div class="card shadow-sm">
            <div class="card-header bg-success text-white">
                <h4 class="mb-0">Cadastrar Novo Produto</h4>
            </div>

            <div class="card-body">
                <form action="{{ route('products.store') }}" method="POST" class="needs-validation" novalidate>
                    @csrf

                    <div class="mb-3">
                        <label class="form-label">Nome</label>
                        <input 
                            name="name" 
                            type="text" 
                            class="form-control" 
                            placeholder="Nome do produto" 
                            value="{{ old('name') }}"
                            required
                        >
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Descrição</label>
                        <input 
                            name="description" 
                            type="text" 
                            class="form-control" 
                            placeholder="Descrição do produto"
                            value="{{ old('description') }}"
                        >
                    </div>

                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label class="form-label">Preço (R$)</label>
                            <input 
                                name="price" 
                                type="number" 
                                step="0.01" 
                                min="1"
                                class="form-control"
                                placeholder="Preço"
                                value="{{ old('price') }}"
                                required
                            >
                        </div>

                        <div class="col-md-6 mb-3">
                            <label class="form-label">Quantidade</label>
                            <input 
                                name="quantity" 
                                type="number" 
                                min="0"
                                class="form-control"
                                placeholder="Quantidade"
                                value="{{ old('quantity') }}"
                                required
                            >
                        </div>
                    </div>

                    <div class="d-flex justify-content-between mt-4">
                        <a href="{{ route('products.index') }}" class="btn btn-secondary">
                            Voltar
                        </a>
                        <button type="submit" class="btn btn-success">
                            Cadastrar Produto
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>