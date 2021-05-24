package br.com.zupacademy.caio.transacao.util;

import br.com.zupacademy.caio.transacao.dominio.TransacaoRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.stereotype.Service;

@Service
public class TransacaoDeserializer implements Deserializer<TransacaoRequest> {

    private final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();

    @Override
    public TransacaoRequest deserialize(String s, byte[] bytes) {
        return gson.fromJson(new String(bytes), TransacaoRequest.class);
    }

    @Override
    public void close() {
        Deserializer.super.close();
    }
}
