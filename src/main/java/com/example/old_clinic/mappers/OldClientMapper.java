package com.example.old_clinic.mappers;

import com.example.old_clinic.models.dtos.OldClientDto;
import com.example.old_clinic.models.entities.OldClient;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {OldNoteMapper.class})
public interface OldClientMapper {
    OldClientDto toOldClientDto(OldClient oldClient);
}