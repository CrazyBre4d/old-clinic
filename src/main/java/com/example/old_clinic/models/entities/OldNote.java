package com.example.old_clinic.models.entities;

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

    @Column(name = "client_guid")
    private UUID clientGuid;

    @Column(name = "comments", length = Integer.MAX_VALUE)
    private String comments;

    @Column(name = "modified_datetime")
    private LocalDateTime modifiedDatetime;

    @Column(name = "created_datetime")
    private LocalDateTime createdDatetime;

    @Column(name = "note_datetime")
    private Instant noteDatetime;

    @Column(name = "logged_user")
    private String loggedUser;

}