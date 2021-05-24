package br.com.zupacademy.caio.transacao.receber;

import br.com.zupacademy.caio.transacao.dominio.TransacaoRepository;
import br.com.zupacademy.caio.transacao.dominio.TransacaoRequest;
import br.com.zupacademy.caio.transacao.util.TransacaoDeserializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

@Service
public class TransacaoConsumerKafka {

    KafkaConsumer<String, TransacaoRequest> consumer;
    TransacaoRepository transacaoRepository;

    TransacaoConsumerKafka(TransacaoRepository transacaoRepository) {
        this.consumer = new KafkaConsumer<>(properties());
        this.consumer.subscribe(Collections.singletonList("transacoes"));
        this.transacaoRepository = transacaoRepository;
    }

    @Scheduled(fixedDelay = 1000)
    public void consumer() {
        var records = consumer.poll(Duration.ofMillis(1000));
        records.forEach(record -> transacaoRepository.save(record.value().toTransacao()));
    }

    Properties properties() {
        var properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, TransacaoDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, TransacaoConsumerKafka.class.getSimpleName());
        properties.setProperty(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "1");
        return properties;
    }
}
