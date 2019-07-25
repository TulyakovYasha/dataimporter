package com.event.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "events")
public class EventEntity {

    @Id
    @NotBlank
    @Column(name = "sso_id")
    private String ssoid;

    @Column(name = "ts")
    private Long ts;

    @NotBlank
    @Column(name = "grp")
    private String grp;

    @NotBlank
    @Column(name = "type")
    private String type;

    @NotBlank
    @Column(name = "subtype")
    private String subtype;

    @Column(name = "url")
    private String url;

    @Column(name = "org_id")
    private String orgId;

    @Column(name = "form_id")
    private String formId;

    @Column(name = "code")
    private String code;

    @Column(name = "ltpa")
    private String ltpa;

    @Column(name = "sudir_response")
    private String sudirResponse;

    @Column(name = "ymdh")
    private String ymdh;

    public EventEntity() {
    }

    public EventEntity(@NotBlank String ssoid, Long ts, @NotBlank String grp, @NotBlank String type,
            @NotBlank String subtype, String url, String orgId, String formId, String code, String ymdh) {
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

        EventEntity that = (EventEntity) o;

        return new EqualsBuilder()
                .append(ssoid, that.ssoid)
                .append(ts, that.ts)
                .append(grp, that.grp)
                .append(type, that.type)
                .append(subtype, that.subtype)
                .append(url, that.url)
                .append(orgId, that.orgId)
                .append(formId, that.formId)
                .append(code, that.code)
                .append(ltpa, that.ltpa)
                .append(sudirResponse, that.sudirResponse)
                .append(ymdh, that.ymdh)
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
