interface Operacao {
	public double calc();
}

class Valor implements Operacao {

	private Number v;

	public Valor(Number v){

		this.v = v;
	}

	public double calc(){

		return v.doubleValue();
	}
}

class Soma implements Operacao {

	private Operacao op1, op2;

	public Soma(Operacao op1, Operacao op2){
	
		this.op1 = op1;
		this.op2 = op2;
	}

	public double calc(){
		return op1.calc() + op2.calc();
	}
}

class Subtracao implements Operacao {

	private Operacao op1, op2;

	public Subtracao(Operacao op1, Operacao op2){

		this.op1 = op1;
		this.op2 = op2;
	}

	public double calc(){
		return op1.calc() - op2.calc();
	}
}

class Divisao implements Operacao {

  private Operacao op1, op2;

  public Divisao(Operacao op1, Operacao op2){

		this.op1 = op1;
		this.op2 = op2;
	}

  public double calc(){
    double op2V = op2.calc();

    if (op2V == 0) {
      throw new IllegalArgumentException("Divisão por zero não permitida!");
    }

		return op1.calc() / op2V;
	}
}

class Multiplicacao implements Operacao {

	private Operacao op1, op2;

	public Multiplicacao(Operacao op1, Operacao op2){

		this.op1 = op1;
		this.op2 = op2;
	}

	public double calc(){
		return op1.calc() * op2.calc();
	}
}

public class Expressoes_v2 {

	public static void calculaExpressoes(Operacao [] expressoes){

		for(Operacao exp : expressoes){

			double resultado = exp.calc();
			System.out.println("Resultado da expressão: " + resultado);
		}
	}

	public static void main(String [] args){

		Operacao [] expressoes = new Operacao[6];

		expressoes[0] = new Valor(10);
		expressoes[1] = new Soma(new Valor(11), new Valor(12));
		expressoes[2] = new Subtracao(new Soma(new Valor(13), new Valor(14)), new Valor(15));
		expressoes[3] = new Subtracao(new Valor(13), new Soma(new Valor(14), new Valor(15)));
		expressoes[4] = new Divisao(new Valor(13), new Soma(new Valor(14), new Valor(15)));
		expressoes[5] = new Multiplicacao(new Divisao(new Valor(13), new Soma(new Valor(14), new Valor(15))), new Soma(new Valor(14), new Valor(15)));
	
		calculaExpressoes(expressoes);
	}
}
