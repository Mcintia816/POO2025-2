package ufpb.dcx.amigosecreto;

import java.util.Scanner;

public class TestaSistemaAmigoGUI {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        SistemaAmigo sistema = new SistemaAmigo();

        try {
            System.out.print("Digite a quantidade total de amigos: ");
            int totalAmigos = Integer.parseInt(sc.nextLine());

            for (int i = 1; i <= totalAmigos; i++) {
                System.out.println("Amigo #" + i + ":");
                System.out.print("Nome: ");
                String nome = sc.nextLine();
                System.out.print("Email: ");
                String email = sc.nextLine();

                sistema.cadastraAmigo(nome, email);
            }

            System.out.println("\n--- Configuração dos Amigos Secretos ---");
            for (int i = 1; i <= totalAmigos; i++) {
                System.out.print("Email da pessoa: ");
                String emailPessoa = sc.nextLine();
                System.out.print("Email do amigo secreto sorteado: ");
                String emailAmigo = sc.nextLine();

                sistema.configuraAmigoSecretoDe(emailPessoa, emailAmigo);
            }

            System.out.println("\n--- Enviar Mensagem para Todos ---");
            System.out.print("Email do remetente: ");
            String emailRemetente = sc.nextLine();
            System.out.print("Texto da mensagem: ");
            String texto = sc.nextLine();
            System.out.print("A mensagem é anônima? (true/false): ");
            boolean ehAnonima = Boolean.parseBoolean(sc.nextLine());

            sistema.enviarMensagensparaTodos(texto, emailRemetente, ehAnonima);

            System.out.println("\nMensagem enviada com sucesso!");

        } catch (AmigoJaExisteException | AmigoInexistenteException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Quantidade inválida!");
        }

        sc.close();
    }
}


