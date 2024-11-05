package com.wzzy.servico.wzztudyone.funcionario.model.serielizer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class SalarioFuncionarioSerializer extends JsonSerializer<BigDecimal> {

    @Override
    public void serialize(BigDecimal salario, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        // Formatar o salário no formato monetário brasileiro
        NumberFormat formatador = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        String salarioFormatado = formatador.format(salario);

        gen.writeString(salarioFormatado);
    }
}
