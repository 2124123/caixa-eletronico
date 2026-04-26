package projetocaixaeletronico;

import java.util.Scanner;

public class CaixaEletronico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String usuarioCorreto = "admin";
        String senhaCorreta = "1234";

        double saldo = 1000.00;
        double limiteSaque = 500.00;
        int opcao;

        System.out.println("===== BEM-VINDO AO CAIXA ELETRÔNICO =====");

        System.out.print("Usuário: ");
        String usuario = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        if (!usuario.equals(usuarioCorreto) || !senha.equals(senhaCorreta)) {
            System.out.println("Usuário ou senha incorretos!");
            scanner.close();
            return;
        }

        System.out.println("Login realizado com sucesso!");

        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Sacar");
            System.out.println("3 - Depositar");
            System.out.println("4 - Transferir");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.printf("Saldo atual: R$ %.2f%n", saldo);
                    break;

                case 2:
                    System.out.print("Digite o valor do saque: R$ ");
                    double saque = scanner.nextDouble();

                    if (saque <= 0) {
                        System.out.println("Valor inválido!");
                    } else if (saque > saldo) {
                        System.out.println("Saldo insuficiente!");
                    } else if (saque > limiteSaque) {
                        System.out.println("O limite de saque é R$ " + limiteSaque);
                    } else {
                        saldo -= saque;
                        System.out.println("Saque realizado com sucesso!");
                    }
                    break;

                case 3:
                    System.out.print("Digite o valor do depósito: R$ ");
                    double deposito = scanner.nextDouble();

                    if (deposito <= 0) {
                        System.out.println("Valor inválido!");
                    } else {
                        saldo += deposito;
                        System.out.println("Depósito realizado com sucesso!");
                    }
                    break;

                case 4:
                    System.out.print("Digite o valor da transferência: R$ ");
                    double transferencia = scanner.nextDouble();

                    if (transferencia <= 0) {
                        System.out.println("Valor inválido!");
                    } else if (transferencia > saldo) {
                        System.out.println("Saldo insuficiente!");
                    } else {
                        saldo -= transferencia;
                        System.out.println("Transferência realizada com sucesso!");
                    }
                    break;

                case 5:
                    System.out.println("Obrigado por usar o caixa eletrônico!");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 5);

        scanner.close();
    }
}