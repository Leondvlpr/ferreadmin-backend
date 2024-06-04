package com.example.ferreadminbackend.resource.application.service;

import java.util.List;
// import java.util.Optional;
import java.util.Optional;

import com.example.ferreadminbackend.resource.application.dto.ResourceDTO;
import com.example.ferreadminbackend.resource.application.dto.ResponseDTO;
import com.example.ferreadminbackend.resource.domain.entity.ResourceEntity;

public interface ResourceService {

    List<ResourceEntity> getResources();

    List<ResourceEntity> getResourcesById(List<Integer> Ids);

    Optional<ResourceEntity> getResourceById(Integer idInsumo);

    ResponseDTO saveResource(ResourceDTO resource);

    ResponseDTO saveResources(List<ResourceDTO> resources);
}
