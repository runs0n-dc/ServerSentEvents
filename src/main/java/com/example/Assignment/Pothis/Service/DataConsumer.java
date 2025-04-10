package com.example.Assignment.Pothis.Service;

import com.example.Assignment.Pothis.BufferArgs;
import com.example.Assignment.Pothis.WikiChangeEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
public class DataConsumer {

    private final BufferArgs bufferArgs;

    @Autowired
    public DataConsumer(BufferArgs bufferArgs) {
        this.bufferArgs = bufferArgs;
    }

    @Bean
    public CommandLineRunner runSseClient() {
        return args -> {
            WebClient client = WebClient.create();

            Flux<String> eventStream = client.get()
                    .uri("https://stream.wikimedia.org/v2/stream/revision-create")
                    .retrieve()
                    .bodyToFlux(String.class);

            eventStream.subscribe(
                    data -> {
                        try {
                            WikiChangeEvent event = bufferArgs.getMapper().readValue(data, WikiChangeEvent.class);
                            bufferArgs.getBuffer().add(event);
                        } catch (Exception e) {
                            System.out.println("SOME ERROR "+e.getMessage());
                        }
                    },
                    error -> System.err.println("Error in stream: " + error),
                    () -> System.out.println("stream closed.")
            );
        };
    }
}
