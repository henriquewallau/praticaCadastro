import entities.Produto;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Produto> produtos = new ArrayList<>();



        String nome;
        int quantidadeProdutos, opcao;
        double precoTotal = 0.0;
        double preco = 0.0;

        do {
            System.out.println();
            System.out.print("Selecione a opção desejada: \n1)Adicionar produto.\n2)Listar produtos.\n3)Calcular valor total.\n4)Sair.\nOpção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao){
                case 1:
                    System.out.print("Quantidade de produtos: ");
                    quantidadeProdutos = sc.nextInt();
                    sc.nextLine();

                    for (int i = 0; i < quantidadeProdutos; i++) {
                        System.out.println();
                        System.out.println("\nProduto #" + (i + 1));

                        System.out.print("Nome do produto: ");
                        nome = sc.nextLine();
                        System.out.print("Preço: ");
                        preco = sc.nextDouble();
                        sc.nextLine();

                        Produto novoProduto = new Produto(nome, preco);
                        produtos.add(novoProduto);
                    }
                        break;

                case 2:
                    System.out.println();
                    System.out.println("Lista de produtos: ");
                    for (Produto produto : produtos){
                        System.out.println(produto);
                    }
                    break;


                case 3:
                    for (Produto produto : produtos) {
                        precoTotal += produto.getPreco();
                    }
                    System.out.println();
                    System.out.printf("Valor total: R$ %.3f\n", precoTotal);
                    break;

                case 4:
                    System.out.println();
                    System.out.println("Saindo..");
            }

        }while (opcao != 4);

        sc.close();
    }
}