package com.example.old_clinic.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "old_note", schema = "old_schema")
public class OldNote {
    @Id
    @Column(name = "guid")
    private UUID guid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_guid")
    @JsonBackReference
    private OldClient oldClient;

    @Column(name = "comments", length = Integer.MAX_VALUE)
    private String comments;

    @Column(name = "modified_datetime")
    private LocalDateTime modifiedDatetime;

    @Column(name = "created_datetime")
    private LocalDateTime createdDatetime;

    @Column(name = "note_datetime")
    private LocalDateTime noteDatetime;

    @Column(name = "logged_user")
    private String loggedUser;

}