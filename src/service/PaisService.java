package service;

import java.util.ArrayList;

import dao.PaisDAO;
import model.Pais;

public class PaisService {
	PaisDAO dao = new PaisDAO();
	
	@SuppressWarnings({ "rawtypes" })
	public ArrayList getPaisMaisHab() {
		return PaisDAO.buscaPaisMaisHab();	
	}
	
	@SuppressWarnings("rawtypes")
	public ArrayList getPaisMenor() {
		return PaisDAO.buscaPaisMenor();	
	}
	
	public int criar(Pais pais) {
		return PaisDAO.criar(null, 0, 0);
	}
	
	public void atualizar(Pais pais){
		PaisDAO.atualizar(0, null, 0, 0);
	}
	
	public void excluir(int id){
		PaisDAO.excluir(id);
	}
	
	public Pais carregar(int id){
		return PaisDAO.carregar(id);
	}

}