package br.com.zupacademy.caio.transacao.consultar;

import br.com.zupacademy.caio.transacao.dominio.TransacaoResponse;
import br.com.zupacademy.caio.transacao.repository.TransacaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transacoes")
public class TransacaoConsultarController {

    Logger log = LoggerFactory.getLogger(TransacaoConsultarController.class);
    TransacaoRepository transacaoRepository;

    TransacaoConsultarController(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> consultar(@PageableDefault(sort = "efetivadaEm",
            direction = Sort.Direction.DESC, value = 10) Pageable pageable,
                                       @PathVariable String id) {
        var isTransacao = transacaoRepository.findAllByCartao_Id(id, pageable);
        if ( !isTransacao.isEmpty()) {
            return ResponseEntity.ok(TransacaoResponse.converter(isTransacao));
        }
        log.warn("Id não encontrado - {}", isTransacao.getNumberOfElements());
        return ResponseEntity.notFound().build();
    }
}
