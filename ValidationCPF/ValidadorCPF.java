import java.util.Scanner;

public class ValidadorCPF {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continuar = "s"; // variável de controle

        while (continuar.equalsIgnoreCase("s")) {
            System.out.println("Digite o CPF (somente números):");
            String cpf = scanner.nextLine();

            if (validarCPF(cpf)) {
                System.out.println("CPF VÁLIDO!");
            } else {
                System.out.println("CPF INVÁLIDO!");
            }

            // Pergunta se quer continuar
            System.out.println("Deseja validar outro CPF? (s/n):");
            continuar = scanner.nextLine();
        }

        System.out.println("Encerrando o validador...");
        scanner.close();
    }

    public static boolean validarCPF(String cpf) {
        cpf = cpf.replace(".", "").replace("-", "");

        if (cpf.length() != 11 || cpf.chars().distinct().count() == 1) {
            return false;
        }

        int[] numeros = new int[11];
        for (int i = 0; i < 11; i++) {
            if (!Character.isDigit(cpf.charAt(i))) return false;
            numeros[i] = Character.getNumericValue(cpf.charAt(i));
        }

        int soma1 = 0;
        for (int i = 0; i < 9; i++) {
            soma1 += numeros[i] * (10 - i);
        }
        int digito1 = 11 - (soma1 % 11);
        if (digito1 >= 10) digito1 = 0;

        int soma2 = 0;
        for (int i = 0; i < 10; i++) {
            soma2 += numeros[i] * (11 - i);
        }
        int digito2 = 11 - (soma2 % 11);
        if (digito2 >= 10) digito2 = 0;

        return numeros[9] == digito1 && numeros[10] == digito2;
    }
}
