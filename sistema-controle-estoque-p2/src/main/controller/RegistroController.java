package main.controller;

import main.models.Registro;
import main.persistence.RegistroDao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class RegistroController {
    public static Boolean salvar(Registro registro) {
        return registro != null && RegistroDao.salvar(registro);
    }

    public static List<Registro> registrosPorPeriodo(Date dataInicial, Date dataFinal) {
        if (dataInicial != null && dataFinal != null) {
            return RegistroDao.registrosPorPeriodo(dataInicial, dataFinal);
        }
        return null;
    }

    public static String toString(Registro registro) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return "Produto: " + registro.getProduto().getNome() +
                " | Tipo: " + registro.getTipo() +
                " | Quantidade: " + registro.getQuantidade() +
                " | Data: " + sdf.format(registro.getData());
    }

    public static String toStringVolume(Registro registro) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return "Produto: " + registro.getProduto().getNome() +
                " | Quantidade vendida: " + registro.getQuantidade();
    }

    public static Boolean periodoValido(Date dataInicial, Date dataFinal) {
        return dataInicial.before(dataFinal) || dataInicial.equals(dataFinal);
    }

    public static Date zerarHoras(Date data) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
}
