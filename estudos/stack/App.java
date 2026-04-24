class Stack {
  private int [] a;
  private int livre;
  static int MAX = 100;

  public void push(int el) {
    this.a[livre] = el;
    this.livre++;
  }

  public int pop() {
    if (this.livre == 0) return -1;

    this.livre--;
    return this.a[livre];
    
  }

  public boolean temPilha() {
    return this.livre > 0;
  }

  public Stack(int el) {
    this.a = new int[MAX];
    
    this.push(el);
  }

  public Stack(int [] el) {
    this.a = new int[MAX];
    
    for (int i = 0; i < el.length; i++) {
      this.push(el[i]);
    }
  }

  public void listar() {
    for (int i = 0; i < livre; i++) {
      System.out.print(" " + a[i]);
    }
  }
}

public class App {
  public static void main(String [] args) {
    int [] v = {0, 2, 3, 4, 5, 6, 7};

    Stack s1 = new Stack(2);
    // s1.listar();

    // while (s1.temPilha()) {
    //   System.out.println("ELEMENTO REMOVIDO: " + s1.pop());
    // }

    Stack s2 = new Stack(v);
    // s2.listar();

    while (s2.temPilha()) {
      System.out.println("ELEMENTO REMOVIDO: " + s2.pop());
    }

    Stack s3 = s1;
    s3.push(10);
    System.out.println(s1.pop());
  }
}