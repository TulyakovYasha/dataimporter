package com.event.services;

import com.event.domain.EventEntity;
import com.event.dto.FormUsageDto;
import com.event.repository.EventEntityRepository;
import com.event.dto.EventDto;
import com.event.util.DateTimeUtil;
import com.event.util.EventConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static com.event.util.DateTimeUtil.getTimestamp;


@Service
public class EventService {

    @Autowired
    private EventValidator validator;

    @Autowired
    private EventEntityRepository repository;

    public List<EventDto> findAllForLastHour() {
        long timeTo = System.currentTimeMillis() / 1000;
        long eventTimeStamp = timeTo - (TimeUnit.HOURS.toMillis(1) / 1000);
        return EventConverter.convertToDtos(repository.findAllByTsBetween(eventTimeStamp, timeTo));
    }

    public void saveAll(List<EventDto> list) {
        List<EventDto> validEvents = list.stream()
                .filter(validator::isEventValid)
                .collect(Collectors.toList());
        repository.saveAll(EventConverter.convertToEntities(validEvents));
    }

    public List<FormUsageDto> getTopFiveForms() {
        return repository.getTopFiveForms(new PageRequest(0, 5));
    }

    public List<EventDto> getBetween(String startDate, String endDate, String startTime, String endTime) {
        List<EventEntity> eventEntities = repository.findAllByTsBetween(getTimestamp(startDate, startTime), getTimestamp(endDate, endTime));
        return EventConverter.convertToDtos(eventEntities);
    }

}
