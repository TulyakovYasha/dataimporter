package com.event.dto;

public class FormUsageDto {

    private String formId;
    private Long count;

    public FormUsageDto(String formId, Long count) {
        this.formId = formId;
        this.count = count;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
