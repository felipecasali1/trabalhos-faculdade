const readline = require('readline');
const keyboard = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

async function inputUsuario(textoPergunta) {
    return new Promise(resolve => {
        keyboard.question(textoPergunta, (resposta) => {
            resolve(Number.parseFloat(resposta));
        });
    });
}

async function main() {
    let precoUnit;
    let qntVendida;
    let desconto;

    while (true) {
        precoUnit = await inputUsuario('Informe o preço unitário: ');
        if (!isNaN(precoUnit) && precoUnit > 0) {
            qntVendida = await inputUsuario('Informe a quantidade vendida: ');
            if (!isNaN(qntVendida) && qntVendida > 0) {
                desconto = await inputUsuario('Informe o desconto: ');
                if (!isNaN(desconto) && desconto < (qntVendida * precoUnit) && desconto >= 0) {
                    break;
                }
            }
        }
        console.log('Dados inválidos, tente novamente!\n');
    }
    keyboard.close();
    var valorFinal = (precoUnit * qntVendida) - desconto;

    console.log('O valor final é: ' + valorFinal);
}

main();