package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entity.EditalProfessor;

public class EditalProfessorDAO extends MasterDAO {
	
	public void inserirEditalProfessor(EditalProfessor editalProfessor){
		inserirObjeto(editalProfessor);
	}
	
	public void deletarEditalProfessor(EditalProfessor editalProfessor){
		deletarObjeto(editalProfessor);
	}
	
	public void atualizarEditalProfessor(EditalProfessor editalProfessor){
		atualizarObjeto(editalProfessor);
	}
	
	public EditalProfessor getEditalProfessor(int idEditalProfessor){
		return getObjeto(EditalProfessor.class, idEditalProfessor);
	}
	
	public List<EditalProfessor> getListaEditalProfessor(){
		return getLista("from EditalProfessor ep");
	}
	
	//Busca de editalProfessor por id ou parte dele.
	public List<EditalProfessor> buscaEditalProfessor(String str){
		Session s = getSession();
		s.beginTransaction();
		Query qr = s.createQuery("from EditalProfessor e where e.idEditalProfessor like :ep");
		qr.setParameter("%"+str+"%", "ep");
		List<EditalProfessor> listaEditalProfessor = qr.list();
		s.getTransaction().commit();
		s.close();
		return listaEditalProfessor;
	}
}
