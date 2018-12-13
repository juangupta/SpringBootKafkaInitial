package com.co.bancolombia.juang.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.co.bancolombia.juang.model.User;

@Configuration
public class KakfaConfiguration {

    @Bean
    public ProducerFactory<String, User> producerFactory() {
//    public ProducerFactory<String, String> producerFactory() {
        Map<String, Object> config = new HashMap<>();

        //config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9093");
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "sbmdeqlzi001.ambientesbc.lab:9093, "
        		+ "sbmdeqlzi002.ambientesbc.lab:9093, "
        		+ "sbmdeqlzi003.ambientesbc.lab:9093");
        
        /*config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "sbmdeglzi001.AMBIENTESBC.LAB:9093, "
        		+ "sbmdeglzi002.AMBIENTESBC.LAB:9093, "
        		+ "sbmdeglzi003.AMBIENTESBC.LAB:9093");*/
        
        //config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.8.71.68:9093, 10.8.71.69:9093, 10.8.71.70:9093");
        
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        //config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put("security.protocol", "SASL_SSL");
        config.put("sasl.mechanism","GSSAPI");
        config.put("sasl.kerberos.service.name","kafka");
        //config.put("sasl.jaas.config","com.sun.security.auth.module.Krb5LoginModule required useKeyTab=true storeKey=true keyTab=\"/Users/juagomez/Bancolombia/riportil2.keytab\" principal=\"riportil@AMBIENTESBC.LAB\";");
        config.put("ssl.truststore.location","/Users/juagomez/Bancolombia/OneDrive - Grupo Bancolombia/Tutoriales/Examples/SSLSpringbootKafkaProducer/src/main/resources/cacertsqa");
        config.put("ssl.truststore.password","changeit");
        //config.put("ssl.truststore.location","/Users/juagomez/Bancolombia/OneDrive - Grupo Bancolombia/Tutoriales/Examples/SSLSpringbootKafkaProducer/src/main/resources/kafka.client.truststore.jks");
        //config.put("ssl.truststore.password","test1234");
        return new DefaultKafkaProducerFactory<>(config);
    }


    @Bean
    public KafkaTemplate<String, User> kafkaTemplate() {
//    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }


}
