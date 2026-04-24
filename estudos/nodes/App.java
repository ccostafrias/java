class Node {
  int value;
  Node prox;

  public Node(int value, Node prox) {
    this.value = value;
    this.prox = prox;
  }
}

class ListaLigada {
  private int size;
  private Node head;
  private Node tail;

  public void addLast(int value) {
    Node node = new Node(value, null);

    tail.prox = node;
    tail = node;
    size++;
  }

  public void addFirst(int value) {
    Node node = new Node(value, null);

    node.prox = head.prox;
    head.prox = node;
    size++;
  }

  public int getLastValue() {
    return tail.value;
  }

  public void imprime() {
    Node p = head.prox;

    while (p != null) {
      System.out.print(p.value);
      if (p.prox != null) System.out.print(" -> ");

      p = p.prox;
    }
    System.out.println();
  }

  public ListaLigada() {
    size = 0;
    head = new Node(0, null);
    tail = head;
  }

  public ListaLigada(int v) {
    this();

    this.addLast(v);
  }

  public ListaLigada(int [] v) {
    this();

    for (int i = 0; i < v.length; i++) {
      this.addLast(v[i]);
    }
  }
}

class App {
  public static void main (String [] args) {
    int [] v = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    ListaLigada l1 = new ListaLigada(2);
    l1.imprime();

    ListaLigada l2 = new ListaLigada(v);
    l2.addFirst(21);
    l2.addLast(24);
    l2.imprime();

    System.out.print("\nÚltimo valor é: " + l2.getLastValue());

  }
}