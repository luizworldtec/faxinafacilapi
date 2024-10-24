package br.com.faxinafacil.models.pagamento;

import br.com.faxinafacil.models.servicodefaxina.ServicoDeFaxina;
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
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String valorPgto;
    private String dataHoraPgto;
    private String typePayment;
    private String statusPgto;
    @OneToOne
    private ServicoDeFaxina servicoDeFaxina;
}