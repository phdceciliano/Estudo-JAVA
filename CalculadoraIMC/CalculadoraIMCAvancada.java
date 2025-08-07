// Import scanner ler as entradas do usuário
import java.util.Scanner;
// classe principal
public class CalculadoraIMCAvancada {
    //metodo principal
    public static void main(String[] args) {
        // chamando o metodo scanner
        // array imcs para armazenar até 100 imc
        Scanner scanner = new Scanner(System.in);
        double[] imcs = new double[100]; // Armazena até 100 IMCs
        int contador = 0; // Conta quantos IMCs foram calculados
        // variavel para armazenar opcao do usuario
        int opcao;
        // laço de repetição do-while
        // menu de entrada do usuario
        do {
            System.out.println("\n=== MENU - CALCULADORA DE IMC ===");
            System.out.println("1. Calcular IMC");
            System.out.println("2. Ver histórico de IMCs");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt(); // lê o que o usuario escreveu
            // switch case, estrutura de controle com base na opção escolhida pelo usuario
            switch (opcao) {
                case 1:
                    System.out.print("Digite seu peso (kg) ex: 90 ");
                    double peso = scanner.nextDouble();//leitura

                    System.out.print("Digite sua altura (m) ex: 1,80 ");
                    double altura = scanner.nextDouble();//leitura

                    double imc = peso / (altura * altura);
                    System.out.printf("Seu IMC é: %.2f\n", imc);

                    // Salvar IMC no array
                    if (contador < imcs.length) {// verifica se ainda a espaço no array
                        imcs[contador] = imc; // armazena no arrey
                        contador++; // incrementa o contador
                    }

                    // Classificação do IMC if, else if, else estrutura de condição
                    if (imc < 18.5) {
                        System.out.println("Classificação: Abaixo do peso");
                    } else if (imc < 24.9) {
                        System.out.println("Classificação: Peso normal");
                    } else if (imc < 29.9) {
                        System.out.println("Classificação: Sobrepeso");
                    } else if (imc < 34.9) {
                        System.out.println("Classificação: Obesidade Grau 1");
                    } else if (imc < 39.9) {
                        System.out.println("Classificação: Obesidade Grau 2");
                    } else {
                        System.out.println("Classificação: Obesidade Grau 3 (Mórbida)");
                    }
                    break; //encerra o caso 1
                    // se o usuário resolveu ver o histórico
                case 2:
                    if (contador == 0) {// se zero print resposta
                        System.out.println("Nenhum IMC calculado ainda.");
                    } else {
                        System.out.println("\n=== Histórico de IMCs ===");
                        for (int i = 0; i < contador; i++) {// cria variavel, enquanto i for menor incrementa i=i+1 percorrendo todo array 
                            System.out.printf("%d. IMC: %.2f\n", i + 1, imcs[i]);// numero da pessoa começando por 1  e o valor imc com 2 casas decimais 
                        }
                    }
                    break;//encerra caso 2
                    //se escolheu sair
                case 3:
                    System.out.println("Encerrando programa. Até mais!");
                    break;
                    //se digitou invalido
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            //repete o menu ate o usuario sair
        } while (opcao != 3);
        //encerra o scanner - sendo uma boa pratica para economizar memoria 
        scanner.close();
    }
}
