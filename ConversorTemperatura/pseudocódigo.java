pseudocódigo
Início
    Criar um objeto para ler dados do usuário (scanner)

    Declarar variável opcao do tipo inteiro
    Declarar variável temperatura do tipo decimal
    Declarar variável resultado do tipo decimal

    Repetir
        Exibir "==== Conversor de Temperatura ===="
        Exibir "1 - Celsius para Fahrenheit"
        Exibir "2 - Fahrenheit para Celsius"
        Exibir "3 - Celsius para Kelvin"
        Exibir "4 - Sair"

        Pedir ao usuário: "Escolha uma opção:"
        Ler opcao

        Se opcao for igual a 4
            Exibir "Encerrando o programa..."
            Parar o loop

        Pedir ao usuário: "Digite a temperatura:"
        Ler temperatura

        Escolha (opcao)
            Caso 1:
                resultado ← (temperatura × 9 / 5) + 32
                Exibir "Celsius para Fahrenheit: " + resultado
            Caso 2:
                resultado ← (temperatura - 32) × 5 / 9
                Exibir "Fahrenheit para Celsius: " + resultado
            Caso 3:
                resultado ← temperatura + 273.15
                Exibir "Celsius para Kelvin: " + resultado
            Outro caso:
                Exibir "Opção inválida!"

    Enquanto (opcao ≠ 4)

    Fechar o objeto de leitura
Fim