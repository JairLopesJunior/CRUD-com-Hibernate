package br.com.crudcomhibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AlunoController {

	EntityManagerFactory emf;
	EntityManager em;
	
	public AlunoController(){
		emf = Persistence.createEntityManagerFactory("aluno");
		em = emf.createEntityManager();
	}
	
	public void salvar(Aluno _aluno) {
		em.getTransaction().begin(); //Inicia transação no banco de dados
		em.merge(_aluno); //Salva o objeto aluno no banco de dados
		em.getTransaction().commit(); //Precisa commitar a transação para ficar salvo
		emf.close();
		
	}
	
	public void remover(Aluno _aluno) {
		em.getTransaction().begin(); //Inicia transação no banco de dados
		Query q = em.createNativeQuery("delete from aluno where  matricula = " + _aluno.getMatricula());
		q.executeUpdate();
		em.getTransaction().commit(); //Precisa commitar a transação para ficar salvo
		emf.close();
		
	}
	
	public List<Aluno> listar(){
		em.getTransaction().begin();
		Query consulta = em.createQuery("select aluno from Aluno aluno");
		List<Aluno> lista = consulta.getResultList();
		em.getTransaction().commit();
		emf.close();
		return lista;
	}
}
