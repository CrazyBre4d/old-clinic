package com.example.old_clinic.repositories;

import com.example.old_clinic.models.entities.OldClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OldClientRepository extends JpaRepository<OldClient, Long>, JpaSpecificationExecutor<OldClient> {
}