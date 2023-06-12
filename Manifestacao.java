public class Manifestacao {
    private String descricao;
    private Pessoa pessoa;

    public Manifestacao(String descricao, Pessoa pessoa) {
        this.descricao = descricao;
        this.pessoa = pessoa;
    }

    public String getDescricao() {
        return descricao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }
}
