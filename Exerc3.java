//Implemente um sistema de controle de reversão (undo) para uma aplicação de edição de texto. Use uma lista simplesmente encadeada para armazenar as ações
//realizadas e permita que o usuário desfaça as últimas ações.

import java.util.Scanner;

public class Exerc3 {
    private static class Action {
        String text; // O texto atual
        String description; // Descrição da ação
        Action next; // Referência para a próxima ação

        public Action(String text, String description) {
            this.text = text;
            this.description = description;
            this.next = null;
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
            current = head; // Atualiza a ação atual para a próxima
            return "Desfeito: " + undoneText;
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

        while (true) {
            System.out.print("Digite uma ação (texto ou 'undo'): ");
            command = scanner.nextLine();

            if (command.equalsIgnoreCase("sair")) {
                break;
            } else if (command.equalsIgnoreCase("undo")) {
                System.out.println(undoManager.undo());
            } else {
                undoManager.addAction(command, "Texto adicionado: " + command);
                System.out.println("Ação registrada: " + command);
            }
        }

        scanner.close();
        System.out.println("Editor encerrado.");
    }
}