package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entity.EditalDisciplina;

public class EditalDiscplinaDAO extends MasterDAO {
	
	public void inserirEditalDisciplina(EditalDisciplina editalDisciplina){
		inserirEditalDisciplina(editalDisciplina);
	}
	
	public void deletarEditalDisciplina(EditalDisciplina editalDisciplina){
		deletarObjeto(editalDisciplina);
	}
	
	public void atualizarEditalDisciplina(EditalDisciplina editalDisciplina){
		atualizarObjeto(editalDisciplina);
	}
	
	public EditalDisciplina getEditalDisciplina(int idEditalDisciplina){
		return getObjeto(EditalDisciplina.class, idEditalDisciplina);
	}
	
	public List<EditalDisciplina> getListaEditalDisciplina(){
		return getLista("from EditalDisciplina m");
	}
	
	//Busca de editalDisciplina pelo id total ou parte dele.
	public List<EditalDisciplina> buscaEditalDisciplina(String str){
		Session s = getSession();
		s.beginTransaction();
		Query qr = s.createQuery("from EditalDisciplina m where m.idEditalDisciplina like :mo");
		qr.setParameter("%"+str+"%", "mo");
		List<EditalDisciplina> listaEditalDisciplina = qr.list();
		s.getTransaction().commit();
		s.close();
		return listaEditalDisciplina;
	}

}