package com.example.old_clinic.services;

import com.example.old_clinic.models.entities.OldNote;
import com.example.old_clinic.repositories.OldNoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OldNoteServiceImpl implements OldNoteService {

    private final OldNoteRepository oldNoteRepository;

    @Override
    public Page<OldNote> findAll(@Nullable Specification<OldNote> spec, Pageable pageable) {
        return oldNoteRepository.findAll(spec, pageable);
    }

    @Override
    public Optional<OldNote> findById(Long id) {
        return oldNoteRepository.findById(id);
    }
}
