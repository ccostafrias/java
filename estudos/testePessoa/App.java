class Pessoa {
  int id;
  String nome;
  String endereco;

  Pessoa(int id, String nome, String endereco) {
    this.id = id;
    this.nome = nome;
    this.endereco = endereco;
  }

  void imprimir() {
    System.out.println("Pessoa: id = " + this.id + ", nome = " + this.nome + ", endereço = " + this.endereco);
  }
}

class TestePessoa {
  public static void main(String [] args) {
    Pessoa p1 = new Pessoa(5, "opaa", "heyyy");
    p1.imprimir();
  }
}