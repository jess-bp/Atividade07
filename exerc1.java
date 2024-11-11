//Implemente um gerenciador de tarefas onde cada tarefa é um nó em uma lista simplesmente encadeada. Permita que o usuário adicione, remova, 
//e marque tarefas como concluídas.

import java.util.ArrayList;
import java.util.Scanner;

public class Exerc1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> tarefas = new ArrayList<String>();
        int opcao = 0;
        String tarefa = "";
        while (opcao != 4) {
            System.out.println("1 - Adicionar tarefa");
            System.out.println("2 - Remover tarefa");
            System.out.println("3 - Marcar tarefa como concluída");
            System.out.println("4 - Listar tarefas");
            System.out.println("5 - Sair");
            System.out.print("Digite a opção desejada: ");
            opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1:
                    System.out.print("Digite a tarefa a ser adicionada: ");
                    tarefa = sc.nextLine();
                    tarefas.add(tarefa);
                    break;
                case 2:
                    System.out.print("Digite a tarefa a ser removida: ");
                    tarefa = sc.nextLine();
                    tarefas.remove(tarefa);
                    break;
                case 3:
                    System.out.print("Digite a tarefa a ser marcada como concluída: ");
                    tarefa = sc.nextLine();
                    tarefa += " CONCLUÍDA";
                    tarefas.add(tarefa);
                    break;
                
                case 4:
                    System.out.println("Tarefas Cadastradas:");
                    for (String t : tarefas) {
                        System.out.println(t);
                    }
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
        sc.close();
    }
}