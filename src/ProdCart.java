public class ProdCart {

	private Integer qtd;
	private Produto produtos;

	public ProdCart(Integer qtd, Produto produtos) {
		super();
		this.qtd = qtd;
		this.produtos = produtos;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public Produto getProdutos() {
		return produtos;
	}

	public void setProdutos(Produto produtos) {
		this.produtos = produtos;
	}

}
