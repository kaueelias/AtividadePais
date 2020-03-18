package atividadePais;

public class Pais {
	public int idPais;
	public String nomePais;
	public long populacaoPais;
	public double areaPais;
	
	public Pais() {
	}
	
	@Override
	public String toString() {
		return "Pais [idPais=" + idPais + ", nomePais=" + nomePais + ", populacaoPais=" + populacaoPais + ", areaPais=" 
				+ areaPais + "]";
	}
	
	public Pais(int id, String nome, long populacao, double area) {
		idPais = id;
		nomePais = nome;
		populacaoPais = populacao;
		areaPais = area;
	}

	public int getIdPais() {
		return idPais;
	}

	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}

	public String getNomePais() {
		return nomePais;
	}

	public void setNomePais(String nomePais) {
		this.nomePais = nomePais;
	}

	public long getPopulacaoPais() {
		return populacaoPais;
	}

	public void setPopulacaoPais(long populacaoPais) {
		this.populacaoPais = populacaoPais;
	}

	public double getAreaPais() {
		return areaPais;
	}

	public void setAreaPais(double areaPais) {
		this.areaPais = areaPais;
	}
	
}
