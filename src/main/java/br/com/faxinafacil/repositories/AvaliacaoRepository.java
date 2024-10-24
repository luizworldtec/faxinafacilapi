package br.com.faxinafacil.repositories;

import br.com.faxinafacil.models.avaliacao.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao,Long> {
}
