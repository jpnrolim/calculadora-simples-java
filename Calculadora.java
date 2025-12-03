import java.util.Scanner;
import java.util.InputMismatchException;

public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            exibirMenu();
            
            try {
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();

                // Se for opção de sair ou inválida, não pede números
                if (opcao == 0) {
                    System.out.println("Calculadora encerrada.");
                    break;
                } else if (opcao < 0 || opcao > 6) { // Ajustei para 6 opções
                    System.out.println("Opção inválida. Tente novamente.\n");
                    continue;
                }

                // Bloco especial para Raiz Quadrada (só precisa de 1 número)
                if (opcao == 6) {
                    realizarRaizQuadrada(scanner);
                } else {
                    // Operações que precisam de 2 números
                    realizarOperacaoBasica(scanner, opcao);
                }

            } catch (InputMismatchException e) {
                System.out.println("Erro: Você digitou um caractere inválido! Use apenas números.");
                scanner.nextLine(); // Limpa o buffer do scanner
            }

            System.out.println();

        } while (opcao != 0);

        scanner.close();
    }
    
    public static void exibirMenu() {
        System.out.println("=== MENU CALCULADORA ===");
        System.out.println("1 - Soma");
        System.out.println("2 - Subtração");
        System.out.println("3 - Multiplicação");
        System.out.println("4 - Divisão");
        System.out.println("5 - Potência");
        System.out.println("6 - Raiz Quadrada");
        System.out.println("0 - Sair");
        System.out.println("========================");
    }

    // Método para operações de 2 números
    public static void realizarOperacaoBasica(Scanner scanner, int opcao) {
        System.out.print("Digite o primeiro número: ");
        double num1 = scanner.nextDouble();
        System.out.print("Digite o segundo número: ");
        double num2 = scanner.nextDouble();
        double resultado = 0;

        switch (opcao) {
            case 1:
                resultado = num1 + num2;
                System.out.printf("Resultado: %.2f\n", resultado);
                break;
            case 2:
                resultado = num1 - num2;
                System.out.printf("Resultado: %.2f\n", resultado);
                break;
            case 3:
                resultado = num1 * num2;
                System.out.printf("Resultado: %.2f\n", resultado);
                break;
            case 4:
                if (num2 != 0) {
                    resultado = num1 / num2;
                    System.out.printf("Resultado: %.2f\n", resultado);
                } else {
                    System.out.println("Erro: Divisão por zero não é permitida.");
                }
                break;
            case 5: // Potência
                resultado = Math.pow(num1, num2);
                System.out.printf("Resultado: %.2f\n", resultado);
                break;
        }
    }

    // Método específico para Raiz Quadrada
    public static void realizarRaizQuadrada(Scanner scanner) {
        System.out.print("Digite o número para calcular a raiz: ");
        double num = scanner.nextDouble();

        if (num >= 0) {
            double resultado = Math.sqrt(num);
            System.out.printf("Resultado: %.2f\n", resultado);
        } else {
            System.out.println("Erro: Não existe raiz real de número negativo.");
        }
    }
}
