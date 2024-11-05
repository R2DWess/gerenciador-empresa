package com.wzzy.servico.wzztudyone.empresa.model.serielizer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class TelefoneEmpresaSerializer extends JsonSerializer<String> {

    @Override
    public void serialize(String telefone, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        // Formatar o telefone para o formato (XX) 9 XXXX-XXXX
        String telefoneFormatado = String.format("(%s) %s %s-%s",
                telefone.substring(0, 2),    // DDD
                telefone.substring(2, 3),    // Prefixo 9
                telefone.substring(3, 7),    // Primeiros 4 dígitos
                telefone.substring(7, 11));  // Últimos 4 dígitos

        gen.writeString(telefoneFormatado);
    }
}
