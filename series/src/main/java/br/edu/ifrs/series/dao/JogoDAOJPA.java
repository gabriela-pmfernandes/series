package br.edu.ifrs.series.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifrs.series.dominio.Jogo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional
public class JogoDAOJPA implements JogoDAO{
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Jogo> listarTodas() {
		// TODO Auto-generated method stub
		return em.createQuery("Select j from Jogo j", Jogo.class).getResultList();
	}

	@Override
	public Jogo buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return em.find(Jogo.class, id);
	}

	@Override
	public void salvar(Jogo jogo) {
		// TODO Auto-generated method stub
		em.persist(jogo);
	}

	@Override
	public void atualizar(Jogo jogo) {
		// TODO Auto-generated method stub
		em.merge(jogo);
	}

	@Override
	public void remover(Long id) {
		// TODO Auto-generated method stub
		Jogo jogo = em.find(Jogo.class, id);
		
		if(jogo != null) {
			em.remove(jogo);
		}
	}
	
	
}
