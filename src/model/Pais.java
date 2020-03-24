package model;

public class Pais {
	public static int id;
	public String nome;
	public long populacao;
	public double area;
	
	public Pais() {
		
	}
	
	public Pais(String nome, long populacao, double area) {

	}
	
	@Override
	public String toString() {
		return "Pais [idPais=" + id + ", nomePais=" + nome + ", populacaoPais=" + populacao + ", areaPais=" 
				+ area + "]";
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getPopulacao() {
		return populacao;
	}

	public void setPopulacao(long populacao) {
		this.populacao = populacao;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}
	
	public void setPopulacao(String pPopulacao) {
	}

	public void setArea(String pArea) {
	}
}
