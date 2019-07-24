package com.event.parser;

import com.event.dto.EventDto;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.MappingStrategy;
import org.springframework.stereotype.Component;

@Component
public class EventDtoCsvParser extends AbstractCsvParser<EventDto> {

    private static final String[] COLUMN_MAPPING = new String[]{
            "ssoid",
            "ts",
            "grp",
            "type",
            "subtype",
            "url",
            "orgid",
            "formid",
            "code",
            "ltpa",
            "sudirresponse",
            "ymdh"
    };

    @Override
    protected int getIgnoredLines() {
        return 1;
    }

    protected EventDtoCsvParser() {
        super(mappingStrategy());
    }

    private static MappingStrategy<EventDto> mappingStrategy() {
        ColumnPositionMappingStrategy<EventDto> result = new ColumnPositionMappingStrategy<>();
        result.setType(EventDto.class);
        result.setColumnMapping(COLUMN_MAPPING);
        return result;
    }
}