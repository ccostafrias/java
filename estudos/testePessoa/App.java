class Pessoa {
  private int id;
  private String nome;
  private String endereco;

  public Pessoa(int id, String nome, String endereco) {
    this.id = id;
    this.nome = nome;
    this.endereco = endereco;
  }

  public void imprimir() {
    System.out.println("Pessoa: id = " + this.id + ", nome = " + this.nome + ", endereço = " + this.endereco);
  }

  public String getEndereco() {
    return this.endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }
}

class TestePessoa {
  public static void main(String [] args) {
    Pessoa p1 = new Pessoa(5, "opaa", "heyyy");

    p1.imprimir();
  }
}