package com.example.old_clinic.controllers;

import com.example.old_clinic.mappers.OldNoteMapper;
import com.example.old_clinic.models.dtos.OldNoteDto;
import com.example.old_clinic.models.entities.OldNote;
import com.example.old_clinic.services.OldNoteServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class OldNoteController {

    private final OldNoteServiceImpl oldNoteServiceImpl;

    private final OldNoteMapper oldNoteMapper;

    @PostMapping
    public ResponseEntity<PagedModel<OldNoteDto>> findAll(@Nullable @RequestParam(required = false) Specification<OldNote> spec, Pageable pageable) {
        Page<OldNote> oldNotes = oldNoteServiceImpl.findAll(spec, pageable);
        Page<OldNoteDto> oldNoteDtoPage = oldNotes.map(oldNoteMapper::toOldNoteDto);
        PagedModel<OldNoteDto> oldNoteDto = new PagedModel<>(oldNoteDtoPage);
        return ResponseEntity.ok(oldNoteDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OldNoteDto> findById(@PathVariable Long id) {
        Optional<OldNote> oldNoteOptional = oldNoteServiceImpl.findById(id);
        Optional<OldNoteDto> oldNoteDto = oldNoteOptional.map(oldNoteMapper::toOldNoteDto);
        return ResponseEntity.of(oldNoteDto);
    }
}

