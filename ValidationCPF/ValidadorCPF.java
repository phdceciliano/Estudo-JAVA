// Scanner permite ler a entrada do usuário
import java.util.Scanner;

public class ValidadorCPF {

    public static void main(String[] args) {
    // Cria um objeto scanner que permite ler o que o usuário digita  
        Scanner scanner = new Scanner(System.in);
        String continuar = "s"; // variável de controle
    // Cria um loop que continuará executando enquanto o usuário digitar "s"
        while (continuar.equalsIgnoreCase("s")) {
            System.out.println("Digite o CPF (somente números):");
    // Lê o CPF digitado e armazena na variável cpf.        
            String cpf = scanner.nextLine();
    // Chama o método validarCPF(cpf). Se retornar true, mostra "VÁLIDO", senão "INVÁLIDO".        
            if (validarCPF(cpf)) {
                System.out.println("CPF VÁLIDO!");
            } else {
                System.out.println("CPF INVÁLIDO!");
            }

            // Pergunta se quer continuar
            System.out.println("Deseja validar outro CPF? (s/n):");
            continuar = scanner.nextLine();
        }
        // finalização
        System.out.println("Encerrando o validador...");
        scanner.close();
    }
    // Define um método que recebe um String cpf e retorna true se for válido ou false se não for.
    public static boolean validarCPF(String cpf) {
        // Remove pontos e traços caso o usuário digite no formato
        cpf = cpf.replace(".", "").replace("-", "");
        // Verifica se o CPF tem 11 dígitos e se todos os dígitos são iguais
        if (cpf.length() != 11 || cpf.chars().distinct().count() == 1) {
            return false;
        }
        // Cria um array de inteiros com 11 posições para armazenar os números do CPF.
        int[] numeros = new int[11];
        // Converte cada caractere do CPF para número e armazena no array. Se algum caractere não for número, retorna false
        for (int i = 0; i < 11; i++) {
            if (!Character.isDigit(cpf.charAt(i))) return false;
            numeros[i] = Character.getNumericValue(cpf.charAt(i));
        }
        // Multiplica os 9 primeiros dígitos por pesos de 10 a 2 e soma os resultados
        int soma1 = 0;
        for (int i = 0; i < 9; i++) {
            soma1 += numeros[i] * (10 - i);
        }
        // Calcula o primeiro dígito verificador
        int digito1 = 11 - (soma1 % 11);
        if (digito1 >= 10) digito1 = 0;
        // Faz o mesmo para o segundo dígito verificador, agora com 10 números e pesos de 11 a 2
        int soma2 = 0;
        for (int i = 0; i < 10; i++) {
            soma2 += numeros[i] * (11 - i);
        }
        int digito2 = 11 - (soma2 % 11);
        if (digito2 >= 10) digito2 = 0;
        // Compara os dígitos que o usuário digitou com os que foram calculados. Se forem iguais, retorna true
        return numeros[9] == digito1 && numeros[10] == digito2;
    }
}
