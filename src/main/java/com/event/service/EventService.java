package com.event.service;

import com.event.dto.FormUsageDto;
import com.event.repository.EventEntityRepository;
import com.event.dto.EventDto;
import com.event.util.EventConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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
        long endTimestamp = System.currentTimeMillis() / 1000;
        long startTimestamp = endTimestamp - (TimeUnit.HOURS.toMillis(1) / 1000);
        return EventConverter.convertToDtos(repository.findAllByTsBetween(startTimestamp, endTimestamp));
    }

    public List<EventDto> findAllBetween(String startDate, String endDate, String startTime, String endTime) {
        Long startTimestamp = getTimestamp(startDate, startTime);
        Long endTimestamp = getTimestamp(endDate, endTime);
        return EventConverter.convertToDtos(repository.findAllByTsBetween(startTimestamp, endTimestamp));
    }

    public void saveAll(List<EventDto> list) {
        List<EventDto> validEvents = list.stream()
                                         .filter(validator::isValid)
                                         .collect(Collectors.toList());
        repository.saveAll(EventConverter.convertToEntities(validEvents));
    }

    public List<FormUsageDto> getTopFiveForms() {
        return repository.getTopFiveForms(new PageRequest(0, 5));
    }

}
