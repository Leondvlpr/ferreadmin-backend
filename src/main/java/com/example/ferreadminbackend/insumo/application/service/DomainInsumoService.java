package com.example.ferreadminbackend.insumo.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.ferreadminbackend.insumo.application.dto.InsumoDTO;
import com.example.ferreadminbackend.insumo.application.dto.ResponseDTO;
import com.example.ferreadminbackend.insumo.domain.entity.Insumo;
import com.example.ferreadminbackend.insumo.domain.entity.Proveedor;
import com.example.ferreadminbackend.insumo.domain.repository.InsumoRepository;
// import com.example.ferreadminbackend.insumo.domain.repository.ProveedorRepository;

@Service
public class DomainInsumoService implements InsumoService {

    @Autowired
    private InsumoRepository insumoRepository;

    @Autowired
    private DomainProveedorService domainProveedorService;

    @Override
    public List<Insumo> obtenerInsumos() {
        return insumoRepository.findAll();
    }


    @Override
    public ResponseDTO guardarInsumo(InsumoDTO insumo) {
        try {
            Proveedor proveedor = domainProveedorService.obtenerProveedor(insumo.getIdProveedor())
                    .orElseThrow(() -> new IllegalArgumentException("El proveedor no existe"));
    
            Insumo insumoEntity = new Insumo();
    
            insumoEntity.setCantidadDisponible(insumo.getCantidadDisponible());
            insumoEntity.setCantidadMinima(insumo.getCantidadMinima());
            insumoEntity.setDescripcion(insumo.getDescripcion());
            insumoEntity.setNombre(insumo.getNombre());
            insumoEntity.setPrecioUnitario(insumo.getPrecioUnitario());
            insumoEntity.setProveedor(proveedor);
            insumoRepository.save(insumoEntity);

            
            return new ResponseDTO(200, "El insumo se a guardado correctamente");
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseDTO(500, "Ha ocurrido un error interno");
        }
    }

}
