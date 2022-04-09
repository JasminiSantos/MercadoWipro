import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Carrinho {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		List<ProdCart> carrinho = new ArrayList<>();
		BigDecimal vlDesconto = new BigDecimal(0);
		BigDecimal vlAcrecimo = new BigDecimal(0);
		BigDecimal vlPagar = new BigDecimal(0);
		// ArrayList<Produto> produtosCompra = new ArrayList<>();

		/* Criando tabela de disponiveis */

		Produto[] produtos = new Produto[10];
		produtos[0] = new Produto(1, "Leite", 10, new BigDecimal(4.51).setScale(2, RoundingMode.HALF_EVEN));
		produtos[1] = new Produto(2, "Ceral", 10, new BigDecimal(3.02).setScale(2, RoundingMode.HALF_EVEN));
		produtos[2] = new Produto(3, "Arroz", 10, new BigDecimal(9.50).setScale(2, RoundingMode.HALF_EVEN));
		produtos[3] = new Produto(4, "Atum", 10, new BigDecimal(3.55).setScale(2, RoundingMode.HALF_EVEN));
		produtos[4] = new Produto(5, "Feijão", 10, new BigDecimal(6.55).setScale(2, RoundingMode.HALF_EVEN));
		produtos[5] = new Produto(6, "Azeite", 10, new BigDecimal(4.55).setScale(2, RoundingMode.HALF_EVEN));
		produtos[6] = new Produto(7, "Oleo", 10, new BigDecimal(7.33).setScale(2, RoundingMode.HALF_EVEN));
		produtos[7] = new Produto(8, "Sabão", 10, new BigDecimal(1.99).setScale(2, RoundingMode.HALF_EVEN));
		produtos[8] = new Produto(9, "Sal", 10, new BigDecimal(3.82).setScale(2, RoundingMode.HALF_EVEN));
		produtos[9] = new Produto(10, "Açucar", 10, new BigDecimal(4.29).setScale(2, RoundingMode.HALF_EVEN));

		System.out.println("\tWIPRO STORE\n====================================");
		System.out.println("Codigo      Produto      Quantidade      Preço Unitário");
		for (int i = 0; i < produtos.length; i++) {
			System.out.println(produtos[i].getCodigo() + "            " + produtos[i].getNome() + "           "
					+ produtos[i].getQuantidade() + "            " + produtos[i].getVlUnitario());
		}

		boolean validador = false;
		BigDecimal vlTotal = new BigDecimal(0);
		while (validador != true) {
			System.out.println("Olá ! Digite o código do produto desejado : ");
			int codProduto = input.nextInt();
			// carrinho.add(cod);
			System.out.println("Quantidade");
			int qnt = input.nextInt();
			// carrinho.add(qnt);

			for (int i = 0; i < produtos.length; i++) {
				if (produtos[i].getCodigo() == codProduto) {
					produtos[i].setVlTotal((produtos[i].getVlUnitario().multiply(BigDecimal.valueOf(qnt))));
					carrinho.add(new ProdCart(qnt, produtos[i]));
					vlTotal = vlTotal.add(produtos[i].getVlTotal());
				}

			}
			System.out.println("Deseja continuar a sua compra? [s/n]");
			String r = input.next();

			if (r.equals("n"))
				validador = true;
		}
		
		System.out.println("================================================================================");

		System.out.println("Nome      Qtd. no carrinho      Preço unit.(R$)      Preço Total(R$)");
		carrinho.forEach(item -> {
			System.out.println(item.getProdutos().getCodigo() + "                " + item.getQtd()
					+ "                  " + item.getProdutos().getVlUnitario() + "                "
					+ item.getProdutos().getVlTotal());
		});
		System.out.println("O valor total da compra com Importo de 9%: R$: "
				+ vlTotal.multiply(BigDecimal.valueOf(1.096)).setScale(2, RoundingMode.HALF_EVEN));
		System.out.println("================================================================================");
		System.out.println("Opções de Pagamento:");
		System.out.println("[1]À vista em dinheiro ou cartão MASTERCARD, recebe 20% de desconto.");
		System.out.println("[2]À vista no cartão de crédito, recebe 15% de desconto.");
		System.out.println("[3]Em Duas vezes, preço normal de etiqueta sem juros.");
		System.out.println("[1]Em Três vezes, preço normal de etiqueta mais juros de 10%.");
		System.out.println("Qual seria a forma de pagamento?");
		
		

		int codPagamento = input.nextInt();
		System.out.println("Wipro STORE");
		System.out.println("Rua dos Bôbos, n 0 - Mercadinho - LTDA");
		System.out.println("CNPJ: 1234554321-00");
		System.out.println("NOTA FISCAL");
		System.out.println("================================================================================");
		System.out.println("Nome      Qtd. no carrinho      Preço unit.(R$)      Preço Total(R$)");
		carrinho.forEach(item -> {
			System.out.println(item.getProdutos().getCodigo() + "                " + item.getQtd()
					+ "                  " + item.getProdutos().getVlUnitario() + "                "
					+ item.getProdutos().getVlTotal());
		});
		System.out.println("================================================================================");
		if (codPagamento == 1) {
			vlDesconto = vlTotal.multiply(BigDecimal.valueOf(0.2)).setScale(2, RoundingMode.HALF_EVEN);
			vlPagar = vlTotal.subtract(vlDesconto);
		} else if (codPagamento == 2) {
			vlDesconto = vlTotal.multiply(BigDecimal.valueOf(0.15)).setScale(2, RoundingMode.HALF_EVEN);
			vlPagar = vlTotal.subtract(vlDesconto);
		} else if (codPagamento == 3) {
			vlPagar = vlTotal;
		} else if (codPagamento == 4) {
			vlAcrecimo = vlTotal.multiply(BigDecimal.valueOf(0.1)).setScale(2, RoundingMode.HALF_EVEN);
			vlPagar = vlTotal.multiply(BigDecimal.valueOf(1.1)).setScale(2, RoundingMode.HALF_EVEN);
		}

		System.out.println("DESCONTO NA COMPRA: r$" + vlDesconto);
		System.out.println("ACRECIMO NA COMPRA: r$" + vlAcrecimo);
		System.out.println("VALOR TOTAL A SER PAGO: r$" + vlPagar);
		System.out.println("VALOR TRIBUTÁRIO: r$"
				+ vlPagar.multiply(BigDecimal.valueOf(0.17)).setScale(2, RoundingMode.HALF_EVEN));

	}

}
