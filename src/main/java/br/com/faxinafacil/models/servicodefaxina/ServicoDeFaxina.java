package br.com.faxinafacil.models.servicodefaxina;

import br.com.faxinafacil.models.pagamento.Pagamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ServicoDeFaxina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dataHoraPgto;
    private String enderecoServico;
    @OneToOne
    private Pagamento pagamento;
}