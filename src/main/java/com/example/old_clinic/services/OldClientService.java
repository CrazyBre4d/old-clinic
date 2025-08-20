package com.example.old_clinic.services;

import com.example.old_clinic.models.dtos.OldClientRequest;
import com.example.old_clinic.models.entities.OldClient;
import com.example.old_clinic.models.entities.OldNote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface OldClientService {

    List<OldClient> findAll();

    List<OldNote> findAllWithBody(OldClientRequest body);


    Optional<OldClient> findById(Long id);

}
