//Implemente uma fila que simula a fila de processos prontos para execução em um sistema operacional. 
//Permita que novos processos sejam adicionados e que o processo mais antigo seja removido para execução.

import java.util.Scanner;
import java.util.ArrayList;

public class Exerc8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> fila = new ArrayList<String>();
        int opcao = 0;
        while (opcao != 3) {
            System.out.println("1 - Adicionar processo");
            System.out.println("2 - Executar processo mais antigo");
            System.out.println("3 - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            if (opcao == 1) {
                System.out.print("Nome do processo: ");
                String processo = scanner.nextLine();
                fila.add(processo);
            } else if (opcao == 2) {
                if (fila.size() > 0) {
                    System.out.println("Executando processo: " + fila.get(0));
                    fila.remove(0);
                } else {
                    System.out.println("Fila vazia");
                }
            }
        }
    }
}