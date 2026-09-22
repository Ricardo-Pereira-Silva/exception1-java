package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

    private Integer numeroQuarto;
    private Date entrada;
    private Date saida;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


    public Reserva(Integer numeroQuarto, Date entrada, Date saida) {
        this.numeroQuarto = numeroQuarto;
        this.entrada = entrada;
        this.saida = saida;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public Date getEntrada() {
        return entrada;
    }


    public Date getSaida() {
        return saida;
    }

    public long duracao() {

        long diff = saida.getTime() - entrada.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public String atualizaDados(Date entrada, Date saida) {

        Date agora = new Date();
        if (entrada.before(agora) || saida.before(agora)) {

            return "Erro ==> : Datas para atualizar reserva devem ser datas futuras.";

        }

        if (!saida.after(entrada)) {

            return "Erro na reserva: Data de saida tem que ser depois da data de entrada.";
        }

        this.entrada = entrada;
        this.saida = saida;
        return null;
    }

    @Override
    public String toString() {

        return "Quarto "
                + numeroQuarto
                + ", entrada: "
                + sdf.format(entrada)
                + ", saida: "
                + sdf.format(saida)
                + ", "
                + duracao()
                + " noites";
    }
}
