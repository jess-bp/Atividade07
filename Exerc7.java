//Implemente um sistema de gerenciamento de impressões onde os trabalhos de impressão são enfileirados e processados na ordem em que chegam. 
//Use uma fila para armazenar os trabalhos de impressão.

import java.util.Scanner;

public class Exerc7 {

    private static class Trabalho{
        String nome;
        Trabalho next;

        public Trabalho(String nome){
            this.nome = nome;
            this.next = null;
        }
    }

    private static class Fila{
        private Trabalho head;
        private Trabalho tail;
        private Trabalho current;

        public Fila(){
            this.head = null;
            this.tail = null;
            this.current = null;
        }

        public void addTrabalho(String nome){
            Trabalho newTrabalho = new Trabalho(nome);
            if (head == null){
                head = newTrabalho;
            } else {
                tail.next = newTrabalho;
            }
            tail = newTrabalho;
            current = head;
        }

        public String removeTrabalho(){
            if (head == null){
                return "Nenhum trabalho para remover.";
            }

            String removedTrabalho = head.nome;
            head = head.next;
            if(head == null){
                tail = null;
            }
            return "Removido: " + removedTrabalho;
        }

        public String mostraFila(){
            if (head == null){
                return "Nenhum trabalho para mostrar.";
            }

            String fila = "";
            Trabalho temp = head;
            while (temp != null){
                fila += temp.nome + " ";
                temp = temp.next;
            }
            return fila;
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Fila fila = new Fila();
        String opcao = "";

        while (!opcao.equals("sair")){
            System.out.println("Digite 'adicionar' para adicionar um trabalho, 'remover' para remover um trabalho, 'mostrar' para mostrar a fila, ou 'sair' para sair.");
            opcao = scanner.nextLine();

            if (opcao.equals("adicionar")){
                System.out.println("Digite o nome do trabalho:");
                String nome = scanner.nextLine();
                fila.addTrabalho(nome);
            } else if (opcao.equals("remover")){
                System.out.println(fila.removeTrabalho());
            } else if (opcao.equals("mostrar")){
                System.out.println(fila.mostraFila());
            }
        }
    }
}