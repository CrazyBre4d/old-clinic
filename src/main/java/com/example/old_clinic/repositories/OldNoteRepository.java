package com.example.old_clinic.repositories;

import com.example.old_clinic.models.entities.OldNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OldNoteRepository extends JpaRepository<OldNote, Long>, JpaSpecificationExecutor<OldNote> {
}