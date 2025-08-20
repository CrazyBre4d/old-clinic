package com.example.old_clinic.mappers;

import com.example.old_clinic.models.dtos.OldClientDto;
import com.example.old_clinic.models.entities.OldClient;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {OldNoteMapper.class})
public interface OldClientMapper {
    @Named("toOldClientDto")
    OldClientDto toOldClientDto(OldClient oldClient);

    @IterableMapping(qualifiedByName = "toOldClientDto")
    List<OldClientDto> toOldClientDtoList(List<OldClient> oldClients);
}