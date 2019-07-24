package com.event.repository;

import com.event.domain.EventEntity;
import com.event.dto.FormUsageDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventEntityRepository extends JpaRepository<EventEntity, String> {

    @Query("select new com.event.dto.FormUsageDto(e.formId, count (e.formId)) from EventEntity e " +
            "where e.formId is not null " +
            "group by e.formId " +
            "order by count (e.formId) desc ")
    List<FormUsageDto> getTopFiveForms(Pageable pageable);

    List<EventEntity> findAllByTsBetween(Long from, Long to);
}
