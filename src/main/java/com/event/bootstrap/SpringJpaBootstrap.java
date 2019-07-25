package com.event.bootstrap;

import com.event.parser.EventDtoCsvParser;
import com.event.service.EventService;
import com.event.dto.EventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
public class SpringJpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Value("${event-service.bootstrap-file}")
    private String bootstrapFileName;

    @Autowired
    private EventDtoCsvParser eventDtoCsvParser;

    @Autowired
    private EventService eventService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        eventService.saveAll(parseFile());
    }

    private List<EventDto> parseFile() {
        try (InputStream inputStream = new FileInputStream(bootstrapFileName)) {
            return eventDtoCsvParser.parse(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize bootstrap entities", e);
        }
    }
}
