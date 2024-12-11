package com.TPFinal.SpringModule.Controllers;

import com.TPFinal.SpringModule.Entities.Producto;
import com.TPFinal.SpringModule.Repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public List<Producto> getAllProductos(){
        return productoRepository.findAll();
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto){
        return productoRepository.save(producto);
    }

    @GetMapping("/{id}")
    public Producto getProductById(@PathVariable Long id){
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el producto con el ID: "+ id));


    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto producto){
        Producto p =  productoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encontró el producto con el ID: "+ id));
        p.setNombre(producto.getNombre());
        p.setPrecio(producto.getPrecio());

        return productoRepository.save(p);
    }

    @DeleteMapping("/{id}")
    public String deleteProducto(@PathVariable Long id){
        productoRepository.deleteById(id);

        return "El producto con id " + id + " fue eliminado";
    }
}
