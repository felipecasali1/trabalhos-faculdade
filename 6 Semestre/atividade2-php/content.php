<?php 
    $arquivo = "noticias.txt";

    $noticias = carregarNoticias($arquivo);

    $noticiaAleatoria = obterNoticiaAleatoria($noticias);

    function carregarNoticias($arquivo) {
        $noticias = [];

        if(verificarArquivo($arquivo)) {
            $numLinha = 0;

            $conteudoArquivo = fopen($arquivo,"r");
            
            while(($linha = fgets($conteudoArquivo)) !== false) {
                $numLinha++;

                $linha = trim($linha);

                if(empty($linha)) {
                    continue;
                }

                if (preg_match('/^Notícia\s\d+:/', $linha)) {
                    $linha = preg_replace('/^Notícia\s\d+:/', '', $linha);
                    $noticias[] = $linha;
                }

            }
            fclose($conteudoArquivo);
            return $noticias;
        } else {
            print('Arquivo não encontrado!');
        }
    }

    function obterNoticiaAleatoria($noticias) {
        return (string) $noticias[rand(0, count($noticias) -1)];
    }

    function verificarArquivo($arquivo) {
        return file_exists($arquivo);
    }

?>