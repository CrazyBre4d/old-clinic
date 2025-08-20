package com.example.old_clinic.mappers;

import com.example.old_clinic.models.dtos.OldNoteDto;
import com.example.old_clinic.models.entities.OldNote;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OldNoteMapper {

    @Named("toOldNoteDto")
    OldNoteDto toOldNoteDto(OldNote oldNote);

    @IterableMapping(qualifiedByName = "toOldNoteDto")
    List<OldNoteDto> toOldNoteDtoList(List<OldNote> oldNotes);
}