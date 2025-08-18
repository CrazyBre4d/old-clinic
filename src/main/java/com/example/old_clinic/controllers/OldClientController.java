package com.example.old_clinic.controllers;

import com.example.old_clinic.mappers.OldClientMapper;
import com.example.old_clinic.models.dtos.OldClientDto;
import com.example.old_clinic.models.entities.OldClient;
import com.example.old_clinic.services.OldClientServiceImpl;
import jakarta.validation.Valid;
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
@RequiredArgsConstructor
@RequestMapping("/clients")
public class OldClientController {

    private final OldClientServiceImpl oldClientServiceImpl;

    private final OldClientMapper oldClientMapper;

    @PostMapping
    public ResponseEntity<PagedModel<OldClientDto>> findAll(@Nullable @RequestParam(required = false) @Valid Specification<OldClient> spec, Pageable pageable) {
        Page<OldClient> oldClients = oldClientServiceImpl.findAll(spec, pageable);
        Page<OldClientDto> oldClientDtoPage = oldClients.map(oldClientMapper::toOldClientDto);
        PagedModel<OldClientDto> oldClientDto = new PagedModel<>(oldClientDtoPage);
        return ResponseEntity.ok(oldClientDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OldClientDto> findById(@PathVariable Long id) {
        Optional<OldClient> oldClientOptional = oldClientServiceImpl.findById(id);
        Optional<OldClientDto> oldClientDto = oldClientOptional.map(oldClientMapper::toOldClientDto);
        return ResponseEntity.of(oldClientDto);
    }

}

