package com.event;

import com.event.domain.EventEntity;
import com.event.dto.EventDto;

public final class CommonTestData {

    private CommonTestData() {
    }

    public static final String SSOID = "5e49d876-d214-47a3-80c8-f606f41e5b6c";
    public static final Long TS = 1499763720L;
    public static final String GRP = "guis-47";
    public static final String TYPE = "getEpd";
    public static final String SUBTYPE = "success";
    public static final String URL = "https://www.mos.ru/pgu/ru/application/guis/-47/#";
    public static final String ORGID = "guis";
    public static final String FORMID = "-47";
    public static final String CODE = "MPGU";
    public static final String YMDH = "2017-07-11-09";

    public static final String FORMID1 = "49";

    public static final EventEntity VALID_ENTITY = new EventEntity(SSOID, TS, GRP, TYPE, SUBTYPE, URL, ORGID, FORMID, CODE, YMDH);
    public static final EventDto VALID_DTO = new EventDto(SSOID, TS, GRP, TYPE, SUBTYPE, URL, ORGID, FORMID, CODE, YMDH);
    public static final EventDto INVALID_DTO = new EventDto("", null, GRP, TYPE, SUBTYPE, URL, ORGID, FORMID, CODE, YMDH);
}
