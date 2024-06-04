package com.example.ferreadminbackend.resource.application.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ferreadminbackend.resource.application.dto.ResourceDTO;
import com.example.ferreadminbackend.resource.application.dto.ResponseDTO;
import com.example.ferreadminbackend.resource.domain.entity.ResourceEntity;
import com.example.ferreadminbackend.resource.domain.entity.SupplierEntity;
import com.example.ferreadminbackend.resource.domain.repository.ResourceRepository;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private SupplierServiceImpl supplierServiceImpl;

    @Override
    public List<ResourceEntity> getResources() {
        return resourceRepository.findAll();
    }

    @Override
    public List<ResourceEntity> getResourcesById(List<Integer> ids) {
        return resourceRepository.findAllById(ids);
    }

    @Override
    public Optional<ResourceEntity> getResourceById(Integer idInsumo) {
        return resourceRepository.findById(idInsumo);
    }

    public SupplierEntity getSupplier(Long idSupplier) {
        return supplierServiceImpl.getSupplierById(idSupplier)
                    .orElseThrow(() -> new IllegalArgumentException("El proveedor no existe"));
    }

    @Override
    public ResponseDTO saveResource(ResourceDTO resource) {
        try {
            SupplierEntity supplier = this.getSupplier(resource.getIdSupplier());

            ResourceEntity resourceEntity = new ResourceEntity();
            resourceEntity.setAmountAvailable(resource.getAvailableAmount());
            resourceEntity.setMinAmount(resource.getMinAmount());
            resourceEntity.setResourceDescription(resource.getDescription());
            resourceEntity.setResourceName(resource.getName());
            resourceEntity.setUnitResourcePrice(resource.getUnitPrice());
            resourceEntity.setSupplier(supplier);
            resourceRepository.save(resourceEntity);

            return new ResponseDTO(200, "El insumo se a guardado correctamente", null);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseDTO(500, "Ha ocurrido un error interno", null);
        }
    }

    public List<ResourceEntity> getResources(List<ResourceDTO> resourceList) {

        ResourceEntity resourceEntity = new ResourceEntity();

        return resourceList
        .stream()
        .map(resource -> {

            SupplierEntity supplier = this.getSupplier(resource.getIdSupplier());

            resourceEntity.setAmountAvailable(resource.getAvailableAmount());
            resourceEntity.setMinAmount(resource.getMinAmount());
            resourceEntity.setResourceDescription(resource.getDescription());
            resourceEntity.setResourceName(resource.getName());
            resourceEntity.setUnitResourcePrice(resource.getUnitPrice());
            resourceEntity.setSupplier(supplier);

            return resourceEntity;
        }).collect(Collectors.toList());

    }

    @Override
    public ResponseDTO saveResources(List<ResourceDTO> resourceList) {
        try {

            List<ResourceEntity> resources = this.getResources(resourceList);

            resourceRepository.saveAll(resources);

            return new ResponseDTO(200, "El insumo se a guardado correctamente", null);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseDTO(500, "Ha ocurrido un error interno", null);
        }
    }

}
