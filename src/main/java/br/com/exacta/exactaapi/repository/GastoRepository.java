package br.com.exacta.exactaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.exacta.exactaapi.entity.Gasto;

public interface GastoRepository extends JpaRepository<Gasto, Long> {

}
