package br.com.faxinafacil.repositories;

import br.com.faxinafacil.models.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao,Long> {
}
