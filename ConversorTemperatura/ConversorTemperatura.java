//Lógica
//Entrada e saída
//Estruturas de repetição e decisão
// Criação de métodos

// Importe para ler o que a entrada do usuário 
import java.util.Scanner;
// classe principal
public class ConversorTemperatura {
//metodo principal
    public static void main(String[] args) {
        // criação do objeto scanner, que tem como objetivo ler as entradas
        Scanner scanner = new Scanner(System.in);
        // variavel do tipo inteiro
        int opcao;
        // laço do-while, execução pelo menos uma vez ate o usuario pedir para sair
        do {
            // metodo mostra menu
            mostrarMenu();
            // leitura do que o usuario escreveu
            opcao = scanner.nextInt();
            // verificação do que o usuario escreveu
            if (opcao == 4) {
                System.out.println("Encerrando o programa...");
                break;
            }
            // 1° contato com o usuario, e armazena a entrada na variavel temperatura
            System.out.print("Digite a temperatura: ");
            double temperatura = scanner.nextDouble();
            // inicia o switch case que trata as opções de forma separada
            // chama os metodos celsius, fahrenheit e kelvin; mostra o resultado com 2 casas decimais e utiliza break para sair do switch
            switch (opcao) {
                case 1:
                    System.out.printf("Celsius para Fahrenheit: %.2f°F\n", celsiusParaFahrenheit(temperatura));
                    break;
                case 2:
                    System.out.printf("Fahrenheit para Celsius: %.2f°C\n", fahrenheitParaCelsius(temperatura));
                    break;
                case 3:
                    System.out.printf("Celsius para Kelvin: %.2fK\n", celsiusParaKelvin(temperatura));
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

            System.out.println(); // linha em branco para organizar e separar execuções
            // fecha o do-while
        } while (true);
        // fecha o scanner
        scanner.close();
    }

    // Método que exibe o menu principal com as opções
    public static void mostrarMenu() {
        System.out.println("==== Conversor de Temperatura ====");
        System.out.println("1 - Celsius → Fahrenheit");
        System.out.println("2 - Fahrenheit → Celsius");
        System.out.println("3 - Celsius → Kelvin");
        System.out.println("4 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    // Métodos de conversão
    public static double celsiusParaFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    public static double fahrenheitParaCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    public static double celsiusParaKelvin(double c) {
        return c + 273.15;
    }
}
