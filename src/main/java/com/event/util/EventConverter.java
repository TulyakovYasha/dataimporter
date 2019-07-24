package com.event.util;

import com.event.domain.EventEntity;
import com.event.dto.EventDto;

import java.util.List;
import java.util.stream.Collectors;

public final class EventConverter {

    private EventConverter() {
    }

    public static EventEntity convertToEntities(EventDto eventDto) {
        return new EventEntity(eventDto.getSsoid(), eventDto.getTs(), eventDto.getGrp(), eventDto.getType(),
                eventDto.getSubtype(), eventDto.getUrl(), eventDto.getOrgId(), eventDto.getFormId(),
                eventDto.getYmdh());
    }

    public static EventDto convertToDtos(EventEntity eventEntity) {
        return new EventDto(eventEntity.getSsoid(), eventEntity.getTs(), eventEntity.getGrp(), eventEntity.getType(),
                eventEntity.getSubtype(), eventEntity.getUrl(), eventEntity.getOrgId(), eventEntity.getFormId(),
                eventEntity.getYmdh());
    }

    public static List<EventEntity> convertToEntities(List<EventDto> list) {
        return list.stream().map(EventConverter::convertToEntities).collect(Collectors.toList());
    }

    public static List<EventDto> convertToDtos(List<EventEntity> list) {
        return list.stream().map(EventConverter::convertToDtos).collect(Collectors.toList());
    }
}
