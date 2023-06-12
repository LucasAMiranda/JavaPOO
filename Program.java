import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        int contadorManifestacoes = 0;

        Manifestacao[] manifestacoes = new Manifestacao[5];
        Scanner sc = new Scanner(System.in);

        System.out.println("Seja bem-vindo à ouvidoria jr's");

        char enfeite = '-';
        char[] array = new char[70];
        for (int i = 0; i < array.length; i++) {
            array[i] = enfeite;
        }
        String hifen = new String(array);
        System.out.println(hifen);

        int opcao;
        do {
            System.out.println("Menu:");
            System.out.println("1 - Inserir manifestação");
            System.out.println("2 - Listar manifestações");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opção:");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Informe o tipo de manifestação (1-Reclamação, 2-Elogio, 3-Sugestão):");
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Digite a descrição da manifestação:");
                    String descricao = sc.nextLine();

                    System.out.println("Digite o nome da pessoa:");
                    String nome = sc.nextLine();

                    System.out.println("Digite o CPF da pessoa:");
                    String cpf = sc.nextLine();

                    Pessoa pessoa = new Pessoa(nome, cpf);

                    Manifestacao manifestacao;

                    contadorManifestacoes++;

                    switch (tipo) {
                        case 1:
                            manifestacao = new Reclamacao(descricao, pessoa);
                            break;
                        case 2:
                            manifestacao = new Elogio(descricao, pessoa);
                            break;
                        case 3:
                            manifestacao = new Sugestao(descricao, pessoa);
                            break;
                        default:
                            System.out.println("Tipo inválido. Manifestação ignorada.");
                            continue;
                    }

                    int indice = -1;
                    for (int i = 0; i < manifestacoes.length; i++) {
                        if (manifestacoes[i] == null) {
                            indice = i;
                            break;
                        }
                    }

                    if (indice != -1) {
                        manifestacoes[indice] = manifestacao;
                        System.out.println("Manifestação cadastrada com sucesso!");
                    } else {
                        System.out.println("Não é possível cadastrar mais manifestações. Limite alcançado.");
                    }
                    break;
                case 2:
                    System.out.println("\nManifestações cadastradas:");
                    if (contadorManifestacoes == 0) {
                        System.out.println("Nenhuma manifestação cadastrada.");
                    } else {
                        for (Manifestacao manifestacao1 : manifestacoes) {
                            if (manifestacao1 != null) {
                                System.out.println(manifestacao1.getClass().getSimpleName() + ": " + manifestacao1.getDescricao());
                                pessoa = manifestacao1.getPessoa();
                                System.out.println("Nome: " + pessoa.getNome());
                            }
                        }
                    }
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Digite novamente.");
                    break;
            }
        } while (opcao != 0);

        sc.close();
    }
}
