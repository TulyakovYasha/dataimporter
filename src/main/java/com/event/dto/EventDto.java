package com.event.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class EventDto {

    private String ssoid;
    private Long ts;
    private String grp;
    private String type;
    private String subtype;
    private String url;
    private String orgId;
    private String formId;
    private String code;
    private String ltpa;
    private String sudirResponse;
    private String ymdh;

    public EventDto() {
    }

    public EventDto(String ssoid, Long ts, String grp, String type, String subtype, String url, String orgId,
            String formId, String code, String ymdh) {
        this.ssoid = ssoid;
        this.ts = ts;
        this.grp = grp;
        this.type = type;
        this.subtype = subtype;
        this.url = url;
        this.orgId = orgId;
        this.formId = formId;
        this.code = code;
        this.ymdh = ymdh;
    }

    public String getSsoid() {
        return ssoid;
    }

    public void setSsoid(String ssoid) {
        this.ssoid = ssoid;
    }

    public Long getTs() {
        return ts;
    }

    public void setTs(Long ts) {
        this.ts = ts;
    }

    public String getGrp() {
        return grp;
    }

    public void setGrp(String grp) {
        this.grp = grp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLtpa() {
        return ltpa;
    }

    public void setLtpa(String ltpa) {
        this.ltpa = ltpa;
    }

    public String getSudirResponse() {
        return sudirResponse;
    }

    public void setSudirResponse(String sudirResponse) {
        this.sudirResponse = sudirResponse;
    }

    public String getYmdh() {
        return ymdh;
    }

    public void setYmdh(String ymdh) {
        this.ymdh = ymdh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EventDto eventDto = (EventDto) o;

        return new EqualsBuilder()
                .append(ssoid, eventDto.ssoid)
                .append(ts, eventDto.ts)
                .append(grp, eventDto.grp)
                .append(type, eventDto.type)
                .append(subtype, eventDto.subtype)
                .append(url, eventDto.url)
                .append(orgId, eventDto.orgId)
                .append(formId, eventDto.formId)
                .append(code, eventDto.code)
                .append(ltpa, eventDto.ltpa)
                .append(sudirResponse, eventDto.sudirResponse)
                .append(ymdh, eventDto.ymdh)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(ssoid)
                .append(ts)
                .append(grp)
                .append(type)
                .append(subtype)
                .append(url)
                .append(orgId)
                .append(formId)
                .append(code)
                .append(ltpa)
                .append(sudirResponse)
                .append(ymdh)
                .toHashCode();
    }
}
