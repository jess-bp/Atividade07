// Crie uma aplicação que simule o histórico de navegação de um navegador utilizando uma lista simplesmente encadeada. 
//Implemente funcionalidades para adicionar novas URLs e remover URLs antigas quando a lista atingir um certo tamanho.


import java.util.ArrayList;
import java.util.Scanner;

public class Exerc2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> historico = new ArrayList<String>();
        int opcao = 0;
        String url = "";
        while (opcao != 3) {
            System.out.println("1 - Adicionar URL");
            System.out.println("2 - Listar URLs");
            System.out.println("3 - Sair");
            System.out.print("Digite a opção desejada: ");
            opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1:
                    System.out.print("Digite a URL a ser adicionada: ");
                    url = sc.nextLine();
                    if (historico.size() == 10) {
                        historico.remove(0);
                    }
                    historico.add(url);
                    break;
                case 2:
                    System.out.println("Histórico de URLs:");
                    for (String u : historico) {
                        System.out.println(u);
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
        sc.close();
    }
}