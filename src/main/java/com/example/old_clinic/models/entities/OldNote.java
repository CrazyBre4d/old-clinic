package com.example.old_clinic.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    private LocalDateTime modifiedDateTime;

    @Column(name = "created_datetime")
    private LocalDateTime createdDateTime;

    @Column(name = "note_datetime")
    private LocalDateTime noteDateTime;

    @Column(name = "logged_user")
    private String loggedUser;

}