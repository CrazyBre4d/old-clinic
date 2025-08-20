package com.example.old_clinic.models.dtos;

import com.example.old_clinic.models.entities.OldNote;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OldClientDto {
    private String agency;
    private UUID guid;
    private String firstName;
    private String lastName;
    private String status;
    private LocalDate dob;
    private LocalDateTime createdDateTime;
}
