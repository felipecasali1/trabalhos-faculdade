package main.persistence;

import main.controller.RegistroController;
import main.models.Registro;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class RegistroDao {
    public static final List<Registro> registros = new LinkedList<>();

    public static List<Registro> getRegistros() {
        return registros;
    }

    public static Boolean salvar(Registro registro) {
        if (registro != null) {
            registros.add(registro);
            return true;
        }
        return false;
    }

    public static List<Registro> registrosPorPeriodo(Date dataInicial, Date dataFinal) {
        List<Registro> reg = new LinkedList<>();
        if (RegistroController.periodoValido(dataInicial, dataFinal)) {
            for (Registro registro : registros) {
                if (registro.getData().after(dataInicial) && registro.getData().before(dataFinal)) {
                    reg.add(registro);
                }
            }
            return reg;
        }
        return null;
    }

    public static List<Registro> agruparOrdenarRegistros() {
        List<Registro> registrosFinal = new LinkedList<>();
        Boolean prodEncontrado = false;

        for (Registro registro : registros) {
            for (Registro regAgrupado : registrosFinal) {
                if (regAgrupado.getProduto().equals(registro.getProduto())) {
                    regAgrupado.setQuantidade(regAgrupado.getQuantidade() + registro.getQuantidade());
                    prodEncontrado = true;
                    break;
                }
            }
            if (!prodEncontrado) {
                registrosFinal.add(new Registro(registro.getProduto(), "", registro.getQuantidade(), registro.getData()));
            }
        }
        registrosFinal.sort((r1, r2) -> Integer.compare(r2.getQuantidade(), r1.getQuantidade()));
        return registrosFinal;
    }

    public static Boolean isEmpty() {
        return registros.isEmpty();
    }
}
