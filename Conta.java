
public class Conta {
	private int numeroConta;
	private String titularConta;
	private double saldoConta;
	
	//Construtores
	
	public Conta(int numeroConta_, String titularConta_, double saldoConta_)
	{
		this.numeroConta = numeroConta_;
		this.titularConta = titularConta_;
		this.saldoConta = saldoConta_;
	}
	
	//Getters
	
	public double getSaldoConta()
	{
		return this.saldoConta;
	}
	
	public String getTitularConta()
	{
		return this.titularConta;
	}
	
	public int getNumeroConta()
	{
		return this.numeroConta;
	}
	
	//Método de Sacar
	
	public boolean sacar(double valorASacar)
	{
		if (this.saldoConta >= valorASacar)
		{
			saldoConta = saldoConta - valorASacar;
			System.out.printf("Valor Sacado: %d", valorASacar);
			return true;
		}
		else
		{
			System.out.printf("O valor a sacar é maior que o saldo.\nNão foi possível sacar R$%d", valorASacar);
			return false;
		}
	}
	
	//Método de Depositar
	
	public boolean depositar(double valorADepositar)
	{
		if(valorADepositar > 0)
		{
			saldoConta = saldoConta + valorADepositar;
			return true;
		}
		else
		{
			System.out.printf("O valor a depositar está abaixo de 0, não é possível depositar valor negativo");
			return false;
		}
	}
	
	//Método de imprimir titular
	
	public void printTitular()
	{
		System.out.printf("Titular:%s",this.getTitularConta());
	}

	//Método de transferência
	
	public boolean transferirValor(Conta contaExterna, double valorATransferir)
	{
		if(this.saldoConta > valorATransferir)
		{
			boolean tempName1;
			tempName1 = contaExterna.depositar(valorATransferir);
			
			if(tempName1 == true)
			{
				/*
				 * Essa checagem é apenas para garantir que o valor transferido só vai ser
				 * removido da conta atual se ele for depositado na conta externa.
				 * Isso apenas garante que caso o objeto da conta externa esteja inacessível nós não removamos
				 * um valor da conta atual 
				 */
				
				this.saldoConta = this.saldoConta - valorATransferir;
				return true;
			}
			else
			{
				return false;
			}
		}
		
		else
		{
			System.out.println("Saldo insuficiente");
			return false;
		}
	}
	
	
}
