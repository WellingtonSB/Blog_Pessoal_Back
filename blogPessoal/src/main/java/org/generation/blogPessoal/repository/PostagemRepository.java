package org.generation.blogPessoal.repository;

import java.util.List;
import org.generation.blogPessoal.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long>{		//jpa hibernate
																					// titulo --> Titulo (em razão do camelCase)
	public List<Postagem> findAllByTituloContainingIgnoreCase (String titulo);		//"Containing" é mais ou menos o "like" do MySQL
}
