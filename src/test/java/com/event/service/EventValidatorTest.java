package com.event.service;

import com.event.dto.EventDto;
import org.junit.Test;

import static com.event.CommonTestData.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EventValidatorTest {

    private EventValidator validator = new EventValidator();

    @Test
    public void eventWithAllFieldsIsValid() {
        assertTrue(validator.isValid(new EventDto(SSOID, TS, GRP, TYPE, SUBTYPE, URL, ORGID, FORMID, CODE, YMDH)));
    }

    @Test
    public void eventWithoutSsoidIsNotValid() {
        assertFalse(validator.isValid(new EventDto(null, TS, GRP, TYPE, SUBTYPE, URL, ORGID, FORMID, CODE, YMDH)));
    }

    @Test
    public void eventWithoutTsIsNotValid() {
        assertFalse(validator.isValid(new EventDto(SSOID, null, GRP, TYPE, SUBTYPE, URL, ORGID, FORMID, CODE, YMDH)));
    }

    @Test
    public void eventWithoutGrpIsNotValid() {
        assertFalse(validator.isValid(new EventDto(SSOID, TS, null, TYPE, SUBTYPE, URL, ORGID, FORMID, CODE, YMDH)));
    }

    @Test
    public void eventWithoutTypeIsNotValid() {
        assertFalse(validator.isValid(new EventDto(SSOID, TS, GRP, null, SUBTYPE, URL, ORGID, FORMID, CODE, YMDH)));
    }

    @Test
    public void eventWithoutSubtypeIsNotValid() {
        assertFalse(validator.isValid(new EventDto(SSOID, TS, GRP, TYPE, null, URL, ORGID, FORMID, CODE, YMDH)));
    }

    @Test
    public void eventWithoutYmdhIsNotValid() {
        assertFalse(validator.isValid(new EventDto(SSOID, TS, GRP, TYPE, SUBTYPE, URL, ORGID, FORMID, CODE, null)));
    }
}