package com.example.old_clinic.services;

import com.example.old_clinic.models.entities.OldClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface OldClientService {

    Page<OldClient> findAll(@Nullable Specification<OldClient> spec, Pageable pageable);

    Optional<OldClient> findById(Long id);

}
