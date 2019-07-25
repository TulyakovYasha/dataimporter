package com.event.service;

import com.event.dto.EventDto;
import com.event.dto.FormUsageDto;
import com.event.repository.EventEntityRepository;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static com.event.CommonTestData.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EventServiceTest {

    @Mock
    private EventEntityRepository repository;
    @Mock
    private EventValidator validator;

    @InjectMocks
    private EventService service;

    @Before
    public void setUp() {


        when(validator.isValid(VALID_DTO)).thenReturn(true);
        when(validator.isValid(INVALID_DTO)).thenReturn(false);
    }

    @Test
    public void findAllForLastHour() {
        when(repository.findAllByTsBetween(anyLong(), anyLong())).thenReturn(Lists.newArrayList(VALID_ENTITY));

        List<EventDto> eventsBetween = service.findAllForLastHour();
        assertEquals(Lists.newArrayList(VALID_DTO), eventsBetween);
    }

    @Test
    public void findAllBetween() {
        when(repository.findAllByTsBetween(1563625800L, 1564057800L)).thenReturn(Lists.newArrayList(VALID_ENTITY));

        List<EventDto> eventsBetween = service.findAllBetween("2019-07-20", "2019-07-25", "12:30", "12:30");
        assertEquals(Lists.newArrayList(VALID_DTO), eventsBetween);
    }

    @Test
    public void saveAll() {
        service.saveAll(Lists.newArrayList(VALID_DTO, INVALID_DTO));

        verify(repository).saveAll(Lists.newArrayList(VALID_ENTITY));
    }

    @Test
    public void getTopFiveForms() {
        List<FormUsageDto> formUsageDtoList = Lists.newArrayList(new FormUsageDto(FORMID, 10L), new FormUsageDto(FORMID1, 5L));

        when(repository.getTopFiveForms(new PageRequest(0, 5))).thenReturn(formUsageDtoList);

        assertEquals(formUsageDtoList, service.getTopFiveForms());
    }
}