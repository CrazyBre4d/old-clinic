package com.example.old_clinic.controllers;

import com.example.old_clinic.mappers.OldClientMapper;
import com.example.old_clinic.mappers.OldNoteMapper;
import com.example.old_clinic.models.dtos.OldClientDto;
import com.example.old_clinic.models.dtos.OldClientRequest;
import com.example.old_clinic.models.dtos.OldNoteDto;
import com.example.old_clinic.models.entities.OldClient;
import com.example.old_clinic.models.entities.OldNote;
import com.example.old_clinic.services.OldClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class OldClientController {

    private final OldClientService oldClientService;

    private final OldClientMapper oldClientMapper;
    private final OldNoteMapper oldNoteMapper;

    @PostMapping("/clients")
    public ResponseEntity<List<OldClientDto>> findAll(@Nullable @RequestParam(required = false) @Valid Specification<OldClient> spec, Pageable pageable) {
        List<OldClient> oldClients = oldClientService.findAll();
        return ResponseEntity.ok(oldClientMapper.toOldClientDtoList(oldClients));
    }

    @PostMapping("/notes")
    public
    ResponseEntity<List<OldNoteDto>> findAllWithNotes(@RequestBody(required = false) OldClientRequest body) {
        List<OldNote> oldNotes = oldClientService.findAllWithBody(body);
        return ResponseEntity.ok(oldNoteMapper.toOldNoteDtoList(oldNotes));
    }

}

