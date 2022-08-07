package com.example.accounts.mapper;

import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface UUIDMapper {

    default String toString(UUID id){
        return id.toString();
    }

    default UUID toUuid(String id){
        return UUID.fromString(id);
    }
}
