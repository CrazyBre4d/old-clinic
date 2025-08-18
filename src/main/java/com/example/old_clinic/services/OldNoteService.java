package com.example.old_clinic.services;

import com.example.old_clinic.models.entities.OldNote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface OldNoteService {

    Page<OldNote> findAll(@Nullable Specification<OldNote> spec, Pageable pageable);

    Optional<OldNote> findById(Long id);
}
