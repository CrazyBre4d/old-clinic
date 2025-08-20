package com.example.old_clinic.repositories;

import com.example.old_clinic.models.entities.OldClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface OldClientRepository extends JpaRepository<OldClient, Long>, JpaSpecificationExecutor<OldClient> {

    @Query("""
            select o from OldClient o inner join o.oldNotes oldNotes
            where o.agency = ?1 and o.guid = ?2 and oldNotes.createdDateTime between ?3 and ?4""")
    List<OldClient> findAll(@Nullable String agency, @Nullable UUID guid, @Nullable LocalDateTime createdDatetimeStart, @Nullable LocalDateTime createdDatetimeEnd);
}