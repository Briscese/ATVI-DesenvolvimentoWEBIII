package com.autobots.automanager.repositorios;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entidades.Documento;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

    Cliente findClienteByNome(String nome);

    List<Cliente> findClientesByNomeLike(String nome);

    
    
    @Query("SELECT c FROM Cliente c JOIN c.documentos d WHERE d.numero = :documentoNumero")
    List<Cliente> findClientesByDocumentoNumero(@Param("documentoNumero") String documentoNumero);


}
