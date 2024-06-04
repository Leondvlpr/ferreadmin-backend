package com.example.ferreadminbackend.resource.infraestructure.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ferreadminbackend.resource.application.dto.ResourceDTO;
import com.example.ferreadminbackend.resource.application.dto.ResponseDTO;
import com.example.ferreadminbackend.resource.application.service.ResourceServiceImpl;
import com.example.ferreadminbackend.resource.domain.entity.ResourceEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/resources")
public class ResourceController {

    @Autowired
    private ResourceServiceImpl resourceServiceImpl;

    @GetMapping()
    public ResponseEntity<List<ResourceEntity>> getResources() {
        List<ResourceEntity> resources = resourceServiceImpl.getResources();
        return new ResponseEntity<>(resources, HttpStatus.OK);
    }

    @PostMapping("saveResource")
    public ResponseEntity<ResponseDTO> getResource(@RequestBody ResourceDTO insumo) {

        try {
            ResponseDTO savedResource = resourceServiceImpl.saveResource(insumo);
            return ResponseEntity.ok(savedResource);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(500, "Ha ocurrido un error interno", null));
        }

    }

}
