package com.event.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import java.net.URL;

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

    @Column(name = "ltpa")
    private String ltpa;

    @Column(name = "sudir_response")
    private String sudirResponse;

    @Column(name = "ymdh")
    private String ymdh;

    public EventEntity() {
    }

    public EventEntity(@NotBlank String ssoid, Long ts, @NotBlank String grp, @NotBlank String type,
            @NotBlank String subtype, String url, String orgId, String formId, String ymdh) {
        this.ssoid = ssoid;
        this.ts = ts;
        this.grp = grp;
        this.type = type;
        this.subtype = subtype;
        this.url = url;
        this.orgId = orgId;
        this.formId = formId;
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
}
