package application;

import model.entities.Reserva;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    static void main() throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Número do quarto: ");
        int numero = sc.nextInt();
        System.out.print("Data de entrada: (dd/MM/yyyy): ");
        Date dataEntrada = fmt.parse(sc.next());
        System.out.print("Data de saida: (dd/MM/yyyy): ");
        Date dataSaida = fmt.parse(sc.next());

        if (!dataSaida.after(dataEntrada)) {

            System.out.println("Eita deu Erro na reserva:" +
                    " Data de saida deve ser depois da Data de entrada");

        } else {

            Reserva reserva = new Reserva(numero, dataEntrada, dataSaida);
            System.out.println("Reserva: " + reserva);

            System.out.println();
            System.out.println("Entre dados para atualizar reserva: ");

            System.out.print("Data de entrada: (dd/MM/yyyy): ");
            dataEntrada = fmt.parse(sc.next());
            System.out.print("Data de saida: (dd/MM/yyyy): ");
            dataSaida = fmt.parse(sc.next());

            String erro = reserva.atualizaDados(dataEntrada,dataSaida);

            if(erro != null) {

                System.out.println("Atenção Erro na reserva: ");
                System.out.println(erro);
            }

            else {

                System.out.println("Reserva atualizada: " +reserva);

            }

        }

        sc.close();
    }
}
