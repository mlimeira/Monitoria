package teste;

import java.util.Date;
import java.util.List;

import DAO.ProfessorDAO;
import entity.Professor;

public class ProfessorApp {

	public static void main(String[] args) {
		
		ProfessorDAO professorDAO = new ProfessorDAO();
		Professor professor = new Professor();
		ProfessorApp professorApp = new ProfessorApp();
		
		professor.setCpf(0);
		professor.setNome("Professor Teste");
		professor.setRg(0);
		professorDAO.inserirProfessor(professor);
	
		professorApp.imprime();
		
		professor.setNome("Vitor Lucas Cordovil");
		professor.setRg(1131346);
		
		professorDAO.atualizarProfessor(professor);
		professorApp.imprime();
		professorDAO.deletarProfessor(professor);
		professorApp.imprime();	
	}
	
	public void imprime(){
		ProfessorDAO professorDAO = new ProfessorDAO();		
		List<Professor> professores = professorDAO.getListaProfessor();
		if (professores.size() == 0)
			System.out.println("N�o h� professor cadastrado no sistema.");
		else{
			System.out.println("Imprimindo Professor(es):");	
			for (Professor p : professores) {
				System.out.println(p);
			}
			System.out.println("\n");
		}
	}
}
