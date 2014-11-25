package util;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import DAO.AlunoDAO;
import DAO.ProfessorDAO;
import entity.Aluno;
import entity.Disciplina;
import entity.Edital;
import entity.Inscricao;
import entity.Professor;

public class InsereDados {

	public static void main(String[] args) {
	
		Aluno aluno = new Aluno();
		aluno.setNome("Jo�o Neto");
		aluno.setCpf(1111);
		aluno.setDataNascimento(new Date(new String("09/05/1995")));
		aluno.setMatricula(2012030);
		aluno.setRg(123456);

		AlunoDAO alunoDAO = new AlunoDAO();	
		alunoDAO.inserirAluno(aluno);
		
		List<Aluno> alunos = alunoDAO.getListaAluno();
		
		for (Aluno a : alunos) {
			System.out.println(a.getNome());
		}
		
		aluno.setNome("Joaummm");
		aluno.setMatricula(555);
		alunoDAO.atualizarAluno(aluno);
		
		alunos = alunoDAO.getListaAluno();
		
		for (Aluno a : alunos) {
			System.out.println(a.getNome());
		}
	}
}
