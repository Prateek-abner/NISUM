package com.example.demo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.streams.StreamsConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.Properties;

@Configuration
public class KafkaStreamsConfig {
    @Bean
    public NewTopic userLoginEventsTopic() {
        return TopicBuilder.name("user-login-events").partitions(1).replicas(1).build();
    }

    @Bean
    public NewTopic loginCountsTopic() {
        return TopicBuilder.name("login-counts").partitions(1).replicas(1).build();
    }

    @Bean
    public StreamsConfig streamsConfig() {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "login-counts-app");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, org.apache.kafka.common.serialization.Serdes.StringSerde.class);
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, org.apache.kafka.common.serialization.Serdes.LongSerde.class);
        return new StreamsConfig(props);
    }
}
