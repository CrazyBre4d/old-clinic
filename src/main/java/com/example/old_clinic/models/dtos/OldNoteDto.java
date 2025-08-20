package com.example.old_clinic.models.dtos;

import com.example.old_clinic.models.entities.OldClient;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OldNoteDto {

    private UUID guid;

    private String comments;

    private LocalDateTime modifiedDateTime;

    private LocalDateTime createdDateTime;

    private LocalDateTime noteDateTime;

    private String loggedUser;
}
