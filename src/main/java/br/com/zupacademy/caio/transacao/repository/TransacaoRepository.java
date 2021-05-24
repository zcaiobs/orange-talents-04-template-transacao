package br.com.zupacademy.caio.transacao.repository;

import br.com.zupacademy.caio.transacao.dominio.Transacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, String> {
    Page<Transacao> findAllByCartao_Id(String id, Pageable pageable);
}
