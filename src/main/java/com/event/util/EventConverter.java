package com.event.util;

import com.event.domain.EventEntity;
import com.event.dto.EventDto;

import java.util.List;
import java.util.stream.Collectors;

public final class EventConverter {

    private EventConverter() {
    }

    public static EventEntity convertToEntity(EventDto eventDto) {
        return new EventEntity(eventDto.getSsoid(), eventDto.getTs(), eventDto.getGrp(), eventDto.getType(),
                eventDto.getSubtype(), eventDto.getUrl(), eventDto.getOrgId(), eventDto.getFormId(), eventDto.getCode(),
                eventDto.getYmdh());
    }

    public static EventDto convertToDto(EventEntity eventEntity) {
        return new EventDto(eventEntity.getSsoid(), eventEntity.getTs(), eventEntity.getGrp(), eventEntity.getType(),
                eventEntity.getSubtype(), eventEntity.getUrl(), eventEntity.getOrgId(), eventEntity.getFormId(), eventEntity.getCode(),
                eventEntity.getYmdh());
    }

    public static List<EventEntity> convertToEntities(List<EventDto> list) {
        return list.stream().map(EventConverter::convertToEntity).collect(Collectors.toList());
    }

    public static List<EventDto> convertToDtos(List<EventEntity> list) {
        return list.stream().map(EventConverter::convertToDto).collect(Collectors.toList());
    }
}
