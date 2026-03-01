function data(dt) {
    if (dt instanceof Date && !isNaN(dt.valueOf())) {
        return `${dt.getDate()}/${dt.getMonth() + 1}/${dt.getFullYear()}`;
    }
    return null;
}

function hora(dt) {
    if (dt instanceof Date && !isNaN(dt.valueOf())) {
        return `${dt.getHours()}:${dt.getMinutes()}`;
    }
    return null;
}

function dataExtenso(dt) {
    if (dt instanceof Date && !isNaN(dt.valueOf())) {
        let diaExtenso = ["Domingo", "Segunda-Feira", "Terça-Feira", "Quarta-Feira", "Quinta-Feira", "Sexta-Feira", "Sábado"];
        let mesExtenso = ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"];
        return `${diaExtenso[dt.getDay()]}, ${dt.getDate()} de ${mesExtenso[dt.getMonth()]} de ${dt.getFullYear()}`;
    }
    return null;
}

module.exports = { data, hora, dataExtenso };