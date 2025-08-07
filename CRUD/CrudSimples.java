import java.util.InputMismatchException; // para tratar erros de tipo de dados
import java.util.Scanner; // ler entradas do usuario

// inicio da classe principal do sistema
public class CrudSimples {
    // cria vetor alunos para armazenar até 100 nomes
    static String[] alunos = new String[100];
    static int contador = 0;// controla quanto alunos estão cadastrados

    // Entrada do programa/ metodo main
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);// cria objeto scanner para leitura
        int opcao = 0; // declara a variavel opcao para armazenar escolhas do menu
        // loop infinito, exibição ate escolha contraria
        // menu CRUD
        while (true) { 
            System.out.println("\n==== MENU CRUD ====");
            System.out.println("1. Cadastrar aluno");
            System.out.println("2. Listar alunos");
            System.out.println("3. Atualizar nome do aluno");
            System.out.println("4. Remover aluno");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            // estrutura de exceção try-catch
            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // limpa o buffer
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine(); // limpa a entrada errada
                continue; // volta para o menu
            }
            // switch case, estrutura de controle de fluxo, alternativa if e else
            // executa a opção escolhida do menu pelo usuario, chamando os metodos correspondentes
            switch (opcao) {
                case 1:
                    cadastrarAluno(scanner);
                    break;
                case 2:
                    listarAlunos();
                    break;
                case 3:
                    atualizarAluno(scanner);
                    break;
                case 4:
                    removerAluno(scanner);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    // metodo cadastro, le o nome, armaena no array e incrementa o contador
    public static void cadastrarAluno(Scanner scanner) {
        System.out.print("Digite o nome do aluno: ");//exibe
        String nome = scanner.nextLine();//le  e guarda
        alunos[contador] = nome; //armazena nome em alunos
        contador++; //incrementa  o contador de alunos
        System.out.println("Aluno cadastrado com sucesso.");
    }

    // metodo leitura
    public static void listarAlunos() {
        if (contador == 0) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            System.out.println("Lista de alunos:");
            for (int i = 0; i < contador; i++) { // cria variavel i começando de 0 (indice inical) enquanto i for menor que contador(quantidade de alunos)repita
                                                // no final de cada repetição i++ aumenta (incrementa) o valor de i em 1 (evitando loop infinito)
                System.out.println((i + 1) + ". " + alunos[i]);// mostra a posição começando em 1 (2,3,4,...)
                                                                // adiciona ponto parar formatar "1.Nome"
                                                                // pega o aluno da posição i do array alunos
            }
        }
    }

    // metodo atualizar aluno
    public static void atualizarAluno(Scanner scanner) {
        if (contador == 0) {// busca alunos no contador, se nenhum cadastrado encerra
            System.out.println("Nenhum aluno cadastrado para atualizar.");
            return;
        }
        // se localizar aluno, mostra lista de alunos atuais
        listarAlunos();
        System.out.print("Digite o número do aluno que deseja atualizar: ");
        int indice;// armazena o numero que o usuario escreveu

        try {
            indice = scanner.nextInt(); // le o numero do aluno a ser atualizado
            scanner.nextLine(); // limpa buffer do scanner
        } catch (InputMismatchException e) {// se escrito errado 
            System.out.println("Entrada inválida. Retornando ao menu...");
            scanner.nextLine(); // limpa entrada inválida
            return;
        }
        // verifica se o numero digitado é valido
        if (indice >= 1 && indice <= contador) {// indice>=1 garante que o usuario nao digitou zero e indice <= contador gartante que o numero digitado nao ultrapasse total de alunos cadastrados
            System.out.print("Digite o novo nome: ");
            String novoNome = scanner.nextLine();// scanner le e armazena em novoNOME
            alunos[indice - 1] = novoNome; // substitui o nome antigo do aluno, indice -1 porque os vetore começam em 0se o usuario digita 2 o aluno esta na posição 1
            System.out.println("Aluno atualizado com sucesso.");
        } else {
            System.out.println("Número inválido. Retornando ao menu...");
        }
    }

    // metodo deletar recebendo parametro scanner
    public static void removerAluno(Scanner scanner) {// define o metodo removerAluno como static (podendo ser chamado sem instanciar um objeto da classe)
        if (contador == 0) { // se 0 nao a alunos cadastrados
            System.out.println("Nenhum aluno cadastrado para remover.");
            return;
        }
        // exibe alunos cadastrados
        listarAlunos();
        System.out.print("Digite o número do aluno que deseja remover: ");
        int indice; //armazena entrada do usuario

        try {
            indice = scanner.nextInt();//le o numero digitado
            scanner.nextLine(); // limpa buffer
        } catch (InputMismatchException e) {// se numero ou item errado retorna menu
            System.out.println("Entrada inválida. Retornando ao menu...");
            scanner.nextLine(); // limpa entrada inválida
            return;
        }
        // verifica se o numero digitado corresponde a um aluno existente entr 1 e o total de alunos
        if (indice >= 1 && indice <= contador) {
            for (int i = indice - 1; i < contador - 1; i++) {// remove o aluno, deslocando todos os seguintes uma posição para esquerda
                alunos[i] = alunos[i + 1];
            }
            alunos[contador - 1] = null;// apos deslocar o ultimo aluno fica duplicado, e o null entra na ultima posição limpando
            contador--; // diminui o contador total de alunos em 1
            System.out.println("Aluno removido com sucesso.");
        } else {
            System.out.println("Número inválido. Retornando ao menu...");
        }
    }
}
