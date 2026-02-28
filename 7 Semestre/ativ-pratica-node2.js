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
    let a;
    let b;
    while (true) {
        b = await inputUsuario('Informe o tamanho da base: ');
        if (!isNaN(b) && b > 0) {
            a = await inputUsuario('Informe a altura: ');
            if (!isNaN(a) && a > 0) {
                break;
            }
        }
        console.log('Dados inválidos, tente novamente!\n');
    }
    keyboard.close();
    if (a === b) {
        console.log('\nO quadrado tem área igual a ' + a * b);
    } else {
        console.log('\nO retângulo tem área igual a ' + a * b);
    }
}

main();