package com.example.old_clinic.services;

import com.example.old_clinic.models.dtos.OldClientRequest;
import com.example.old_clinic.models.entities.OldClient;
import com.example.old_clinic.models.entities.OldNote;
import com.example.old_clinic.repositories.OldClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OldClientServiceImpl implements OldClientService {

    private final OldClientRepository oldClientRepository;

    @Override
    public List<OldClient> findAll() {
        return oldClientRepository.findAll();
    }

    @Override
    public List<OldNote> findAllWithBody(OldClientRequest body) {
        return oldClientRepository.findAll(
                body.getAgency(),
                UUID.fromString(body.getGuid()),
                body.getDateTo(),
                body.getDateFrom()).stream()
                .flatMap(client -> client.getOldNotes().stream())
                .collect(Collectors.toList());
    }

    @Override
    public Optional<OldClient> findById(Long id) {
        return oldClientRepository.findById(id);
    }

}
