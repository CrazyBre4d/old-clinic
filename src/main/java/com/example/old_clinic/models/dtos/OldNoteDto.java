package com.example.old_clinic.models.dtos;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OldNoteDto {
    private String guid;
    private String comments;
    private String clientGuid;
    private String loggedUser;
    private String createdDateTime;
    private String modifiedDateTime;
}
