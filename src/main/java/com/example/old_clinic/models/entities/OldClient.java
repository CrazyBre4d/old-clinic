package com.example.old_clinic.models.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "old_client", schema = "old_schema")
public class OldClient {
    @Id
    @NotNull
    @Column(name = "guid", nullable = false)
    private UUID guid;

    @NotNull
    @Column(name = "agency", nullable = false)
    private String agency;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "status")
    private String status;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "created_datetime")
    private LocalDateTime createdDatetime;

    @OneToMany(mappedBy = "oldClient")
    @JsonManagedReference
    private Set<OldNote> oldNotes = new LinkedHashSet<>();

}