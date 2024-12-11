package com.TPFinal.SpringModule.Repositories;

import com.TPFinal.SpringModule.Entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {


}
