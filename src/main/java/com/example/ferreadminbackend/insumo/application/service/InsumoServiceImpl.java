package com.example.ferreadminbackend.insumo.application.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ferreadminbackend.insumo.application.dto.InsumoDTO;
import com.example.ferreadminbackend.insumo.application.dto.ResponseDTO;
import com.example.ferreadminbackend.insumo.domain.entity.Insumo;
import com.example.ferreadminbackend.insumo.domain.entity.Proveedor;
import com.example.ferreadminbackend.insumo.domain.repository.InsumoRepository;
// import com.example.ferreadminbackend.insumo.domain.repository.ProveedorRepository;

@Service
public class InsumoServiceImpl implements InsumoService {

    @Autowired
    private InsumoRepository insumoRepository;

    @Autowired
    private ProveedorServiceImpl proveedorServiceImpl;

    @Override
    public List<Insumo> obtenerInsumos() {
        return insumoRepository.findAll();
    }

    @Override
    public List<Insumo> obtenerInsumosPorIds(List<Integer> ids) {
        return insumoRepository.findAllById(ids);
    }

    @Override
    public Optional<Insumo> obtenerInsumoPorId(Integer idInsumo) {
        return insumoRepository.findById(idInsumo);
    }

    @Override
    public ResponseDTO guardarInsumo(InsumoDTO insumo) {
        try {
            Proveedor proveedor = proveedorServiceImpl.obtenerProveedor(insumo.getIdProveedor())
                    .orElseThrow(() -> new IllegalArgumentException("El proveedor no existe"));

            Insumo insumoEntity = new Insumo();

            insumoEntity.setCantidadDisponible(insumo.getCantidadDisponible());
            insumoEntity.setCantidadMinima(insumo.getCantidadMinima());
            insumoEntity.setDescripcion(insumo.getDescripcion());
            insumoEntity.setNombre(insumo.getNombre());
            insumoEntity.setPrecioUnitario(insumo.getPrecioUnitario());
            insumoEntity.setProveedor(proveedor);
            insumoRepository.save(insumoEntity);

            return new ResponseDTO(200, "El insumo se a guardado correctamente", null);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseDTO(500, "Ha ocurrido un error interno", null);
        }
    }

    @Override
    public ResponseDTO guardarInsumos(List<InsumoDTO> insumos) {
        try {
            Insumo insumoEntity = new Insumo();

            List<Insumo> listaInsumos = insumos
                    .stream()
                    .map(insumo -> {

                        Proveedor proveedor = proveedorServiceImpl.obtenerProveedor(insumo.getIdProveedor())
                                .orElseThrow(() -> new IllegalArgumentException("El proveedor no existe"));

                        insumoEntity.setCantidadDisponible(insumo.getCantidadDisponible());
                        insumoEntity.setCantidadMinima(insumo.getCantidadMinima());
                        insumoEntity.setDescripcion(insumo.getDescripcion());
                        insumoEntity.setNombre(insumo.getNombre());
                        insumoEntity.setPrecioUnitario(insumo.getPrecioUnitario());
                        insumoEntity.setProveedor(proveedor);

                        return insumoEntity;
                    }).collect(Collectors.toList());

            insumoRepository.saveAll(listaInsumos);

            return new ResponseDTO(200, "El insumo se a guardado correctamente", null);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseDTO(500, "Ha ocurrido un error interno", null);
        }
    }

}
