//Crie um simulador de fila de atendimento em um banco. Utilize uma fila para gerenciar os clientes que aguardam atendimento e 
//implemente a lógica para chamar o próximo cliente.

import java.util.Scanner;

public class Exerc6 {

    private static class Cliente{
        String nome;
        Cliente next;

        public Cliente(String nome){
            this.nome = nome;
            this.next = null;
        }
    }

    private static class Fila{
        private Cliente head;
        private Cliente tail;
        private Cliente current;

        public Fila(){
            this.head = null;
            this.tail = null;
            this.current = null;
        }

        public void addCliente(String nome){
            Cliente newCliente = new Cliente(nome);
            if (head == null){
                head = newCliente;
            } else {
                tail.next = newCliente;
            }
            tail = newCliente;
            current = head;
        }

        public String removeCliente(){
            if (head == null){
                return "Nenhum cliente para remover.";
            }

            String removedCliente = head.nome;
            head = head.next;
            if(head == null){
                tail = null;
            }
            return "Removido: " + removedCliente;
        }

        public String mostraFila(){
            if (head == null){
                return "Nenhum cliente para mostrar.";
            }

            String fila = "";
            Cliente temp = head;
            while (temp != null){
                fila += temp.nome + " ";
                temp = temp.next;
            }
            return fila;
        }

        public String chamaProximo(){
            if (current == null){
                return "Nenhum cliente para chamar.";
            }

            String proximoCliente = current.nome;
            head = current.next;
            current = head;
            return "Próximo cliente: " + proximoCliente;
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Fila fila = new Fila();
        String opcao = "";

        while (!opcao.equals("sair")){
            System.out.println("Digite 'add' para adicionar um cliente, 'remove' para remover um cliente, 'mostra' para mostrar a fila, 'chama' para chamar o próximo cliente, ou 'sair' para encerrar o programa.");
            opcao = scanner.nextLine();

            if (opcao.equals("add")){
                System.out.println("Digite o nome do cliente:");
                String nome = scanner.nextLine();
                fila.addCliente(nome);
            } else if (opcao.equals("remove")){
                System.out.println(fila.removeCliente());
            } else if (opcao.equals("mostra")){
                System.out.println(fila.mostraFila());
            } else if (opcao.equals("chama")){
                System.out.println(fila.chamaProximo());
            }
        }
    }
}