package application;

import model.entities.Reserva;
import model.entities.exception.DomainExceptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    static void main() {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Número do quarto: ");
            int numero = sc.nextInt();
            System.out.print("Data de entrada: (dd/MM/yyyy): ");
            Date dataEntrada = fmt.parse(sc.next());
            System.out.print("Data de saida: (dd/MM/yyyy): ");
            Date dataSaida = fmt.parse(sc.next());

            Reserva reserva = new Reserva(numero, dataEntrada, dataSaida);
            System.out.println("Reserva: " + reserva);

            System.out.println();
            System.out.println("Entre dados para atualizar reserva: ");
            System.out.print("Data de entrada: (dd/MM/yyyy): ");
            dataEntrada = fmt.parse(sc.next());
            System.out.print("Data de saida: (dd/MM/yyyy): ");
            dataSaida = fmt.parse(sc.next());

            reserva.atualizaDados(dataEntrada, dataSaida);
            System.out.println("Reserva atualizada: " + reserva);
        }
        catch (ParseException e) {
            System.out.println("Formato inválido de data.");
        }
        catch (DomainExceptions e) {
            System.out.println("Erro na reserva: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Erro inesperado.");
        }

        sc.close();
    }
}
