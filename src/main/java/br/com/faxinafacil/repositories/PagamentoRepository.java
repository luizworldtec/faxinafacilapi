package br.com.faxinafacil.repositories;

import br.com.faxinafacil.models.pagamento.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository <Pagamento,Long>{
}
