//Implemente um jogo simples de cartas onde a mão do jogador é representada por uma lista duplamente encadeada. 
//Permita que o jogador adicione, remova, e reorganize as cartas na mão.

import java.util.ArrayList;
import java.util.Scanner;

public class Exerc5{

    private static class Carta{
        String naipe;
        String valor;
        Carta next;
        Carta previous;

        public Carta(String naipe, String valor){
            this.naipe = naipe;
            this.valor = valor;
            this.next = null;
            this.previous = null;
        }
    }

    private static class Mao{
        private Carta head;
        private Carta current;

        public Mao(){
            this.head = null;
            this.current = null;
        }

        public void addCarta(String naipe, String valor){
            Carta newCarta = new Carta(naipe, valor);
            newCarta.next = head;
            if (head != null){
                head.previous = newCarta;
            }
            head = newCarta;
            current = head;
        }

        public String removeCarta(){
            if (current == null){
                return "Nenhuma carta para remover.";
            }

            String removedCarta = current.valor + " de " + current.naipe;
            head = current.next;
            if (head != null){
                head.previous = null;
            }
            current = head;
            return "Removido: " + removedCarta;
        }

        public String mostraMao(){
            if (current == null){
                return "Nenhuma carta para mostrar.";
            }

            StringBuilder sb = new StringBuilder();
            Carta temp = head;
            while (temp != null){
                sb.append(temp.valor).append(" de ").append(temp.naipe).append("\n");
                temp = temp.next;
            }
            return sb.toString();
        }

        public void reorganizaMao(){
            if (current == null){
                return;
            }

            ArrayList<Carta> cartas = new ArrayList<>();
            Carta temp = head;
            while (temp != null){
                cartas.add(temp);
                temp = temp.next;
            }

            head = cartas.get(cartas.size() - 1);
            head.next = null;
            head.previous = null;
            current = head;
            for (int i = cartas.size() - 2; i >= 0; i--){
                head.previous = cartas.get(i);
                cartas.get(i).next = head;
                head = cartas.get(i);
            }
        }
    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        Mao mao = new Mao();

        while (true){
            System.out.println("1 - Adicionar carta");
            System.out.println("2 - Remover carta");
            System.out.println("3 - Mostrar mão");
            System.out.println("4 - Reorganizar mão");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 1:
                    System.out.print("Digite o naipe da carta: ");
                    String naipe = scanner.nextLine();
                    System.out.print("Digite o valor da carta: ");
                    String valor = scanner.nextLine();
                    mao.addCarta(naipe, valor);
                    break;
                case 2:
                    System.out.println(mao.removeCarta());
                    break;
                case 3:
                    System.out.println(mao.mostraMao());
                    break;
                case 4:
                    mao.reorganizaMao();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}