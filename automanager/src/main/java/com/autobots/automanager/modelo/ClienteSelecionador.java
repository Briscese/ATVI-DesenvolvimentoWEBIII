package com.autobots.automanager.modelo;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.autobots.automanager.entidades.Cliente;

@Component
public class ClienteSelecionador {
	public Optional<Cliente> selecionar(List<Cliente> clientes, long id) {
        return clientes.stream()
                .filter(cliente -> cliente.getId() == id)
                .findFirst();
    }
}