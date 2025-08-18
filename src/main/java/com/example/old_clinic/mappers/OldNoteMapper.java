package com.example.old_clinic.mappers;

import com.example.old_clinic.models.dtos.OldNoteDto;
import com.example.old_clinic.models.entities.OldNote;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OldNoteMapper {
    OldNoteDto toOldNoteDto(OldNote oldNote);
}