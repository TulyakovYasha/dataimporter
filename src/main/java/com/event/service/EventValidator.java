package com.event.service;

import com.event.dto.EventDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class EventValidator {

    public boolean isValid(EventDto event) {
        return StringUtils.isNotBlank(event.getSsoid())
                && StringUtils.isNotBlank(event.getGrp())
                && StringUtils.isNotBlank(event.getType())
                && StringUtils.isNotBlank(event.getSubtype())
                && StringUtils.isNotBlank(event.getYmdh())
                && Objects.nonNull(event.getTs());
    }
}
