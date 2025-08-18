package com.example.old_clinic.controllers;

import com.example.old_clinic.mappers.OldClientMapper;
import com.example.old_clinic.mappers.OldNoteMapper;
import com.example.old_clinic.models.dtos.OldClientDto;
import com.example.old_clinic.models.dtos.OldClientRequest;
import com.example.old_clinic.models.entities.OldClient;
import com.example.old_clinic.services.OldClientService;
import com.example.old_clinic.services.OldNoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PagedModel;
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

    @PostMapping("/clients")
    public ResponseEntity<PagedModel<OldClientDto>> findAll(@Nullable @RequestParam(required = false) @Valid Specification<OldClient> spec, Pageable pageable) {
        Page<OldClient> oldClients = oldClientService.findAll(spec, pageable);
        Page<OldClientDto> oldClientDtoPage = oldClients.map(oldClientMapper::toOldClientDto);
        PagedModel<OldClientDto> oldClientDto = new PagedModel<>(oldClientDtoPage);
        return ResponseEntity.ok(oldClientDto);
    }

    @PostMapping("/notes")
    public
    ResponseEntity<List<OldClient>> findAllWithNotes(@RequestBody(required = false) OldClientRequest body) {
        List<OldClient> oldClients = oldClientService.findAllWithBody(body);
        return ResponseEntity.ok(oldClients);
    }

}

