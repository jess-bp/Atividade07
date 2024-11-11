//Implemente um editor de texto simples onde as operações de desfazer (undo) e refazer (redo) são gerenciadas por uma lista duplamente encadeada.


import java.util.Scanner;

public class Exerc4 {

    private static class Action {
        String text; // O texto atual
        String description; // Descrição da ação
        Action next; // Referência para a próxima ação
        Action previous; // Referência para a ação anterior

        public Action(String text, String description) {
            this.text = text;
            this.description = description;
            this.next = null;
            this.previous = null;
        }
    }

    private static class UndoManager {
        private Action head; // Cabeça da lista encadeada
        private Action current; // Ação atual

        public UndoManager() {
            this.head = null;
            this.current = null;
        }

        // Adiciona uma nova ação à lista
        public void addAction(String text, String description) {
            Action newAction = new Action(text, description);
            newAction.next = head; // O novo nó aponta para o antigo cabeçalho
            if (head != null) {
                head.previous = newAction;
            }
            head = newAction; // O novo nó se torna o novo cabeçalho
            current = head; // Atualiza a ação atual
        }

        // Desfaz a última ação
        public String undo() {
            if (current == null) {
                return "Nenhuma ação para desfazer.";
            }

            String undoneText = current.text;
            head = current.next; // Remove a ação atual
            if (head != null) {
                head.previous = null;
            }
            current = head; // Atualiza a ação atual para a próxima
            return "Desfeito: " + undoneText;
        }

        public String mostraTexto(){
            if (current == null) {
                return "Nenhuma ação para desfazer.";
            }
            return current.text;
        }

        // Refaz a última ação desfeita
        public String redo() {
            if (current == null) {
                return "Nenhuma ação para refazer.";
            }

            if (current.previous == null) {
                return "Nenhuma ação para refazer.";
            }

            current = current.previous;
            return "Refazer: " + current.text;
        }

        // Retorna a descrição da ação atual
        public String getCurrentAction() {
            if (current == null) {
                return "Nenhuma ação atual.";
            }
            return current.description;
        }
    }

    public static void main(String[] args) {
        UndoManager undoManager = new UndoManager();
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Bem-vindo ao editor de texto!");
        System.out.println("Digite 'sair' para encerrar.");

        do {
            System.out.print("Digite um comando (adicionar, desfazer, refazer, sair): ");
            command = scanner.nextLine();

            switch (command) {
                case "adicionar":
                    System.out.print("Digite o texto a ser adicionado: ");
                    String text = scanner.nextLine();
                    undoManager.addAction(text, "Adicionar: " + text);
                    break;
                case "desfazer":
                    System.out.println(undoManager.undo());
                    break;
                case "refazer":
                    System.out.println(undoManager.redo());
                    break;
                case "mostrar":
                    System.out.println(undoManager.mostraTexto());
                    break;
                case "sair":
                    break;
                default:
                    System.out.println("Comando inválido.");
            }

            System.out.println("Texto atual: " + undoManager.getCurrentAction());
        } while (!command.equals("sair"));

        scanner.close();
    }
}