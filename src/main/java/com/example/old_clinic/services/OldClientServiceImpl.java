package com.example.old_clinic.services;

import com.example.old_clinic.models.entities.OldClient;
import com.example.old_clinic.repositories.OldClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OldClientServiceImpl implements OldClientService {

    private final OldClientRepository oldClientRepository;

    @Override
    public Page<OldClient> findAll(@Nullable Specification<OldClient> spec, Pageable pageable) {
        return oldClientRepository.findAll(spec, pageable);
    }

    @Override
    public Optional<OldClient> findById(Long id) {
        return oldClientRepository.findById(id);
    }

}
