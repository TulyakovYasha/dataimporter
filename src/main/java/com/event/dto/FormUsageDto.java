package com.event.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FormUsageDto that = (FormUsageDto) o;

        return new EqualsBuilder()
                .append(formId, that.formId)
                .append(count, that.count)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(formId)
                .append(count)
                .toHashCode();
    }
}
