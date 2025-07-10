package com.example.demo.streams;

import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Materialized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class LoginCountStreams {
    @Autowired
    private StreamsBuilder streamsBuilder;

    @PostConstruct
    public void startStreams() {
        KStream<String, String> loginEvents = streamsBuilder.stream("user-login-events");

        Map<String, Long> initialCounts = new HashMap<>();
        loginEvents.groupBy((key, value) -> value.split(",")[0]) // Assuming format: userId,timestamp
                .count(Materialized.as("login-counts-store"))
                .toStream()
                .to("login-counts");

        KafkaStreams streams = new KafkaStreams(streamsBuilder.build(), streamsBuilder.streamsConfiguration());
        streams.start();
    }
}
