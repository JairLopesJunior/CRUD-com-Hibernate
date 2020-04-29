package br.com.crudcomhibernate;

import java.util.List;

public class Teste {

	public static void main(String[] args) {
		
		Aluno a = new Aluno();
		a.setNome("Jair");
		a.setIdade(18);
		a.setMatricula("3");
		
		Aluno a2 = new Aluno();
		a2.setNome("aa");
		a2.setIdade(20);
		a2.setMatricula("2");
		
		Aluno a3 = new Aluno();
		a3.setNome("ll");
		a3.setIdade(10);
		a3.setMatricula("1");
		
		
		//ac.salvar(a);
		//ac.salvar(a2);
		//ac.salvar(a3);
		
		//ac.remover(a3);
		
		AlunoController ac = new AlunoController();
		
		List<Aluno> alunos = ac.listar(); 
		
		for(int i = 0; i < alunos.size(); i++) {
			System.out.println("Nome: " + alunos.get(i).getNome() + 
							   "Idade: " + alunos.get(i).getIdade() +
							   "Matricula: " + alunos.get(i).getMatricula());
		}

	}

}
