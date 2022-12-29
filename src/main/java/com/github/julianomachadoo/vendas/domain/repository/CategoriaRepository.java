package com.github.julianomachadoo.vendas.domain.repository;

import com.github.julianomachadoo.vendas.domain.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
