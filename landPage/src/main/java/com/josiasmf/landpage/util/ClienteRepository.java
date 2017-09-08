package com.josiasmf.landpage.util;

import com.josiasmf.landpage.model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
    
    private final List<Cliente> clientes = new ArrayList<>();
    private long nextId = 0;
    
    
    public List<Cliente> findAll() {
        return clientes;
    }
    
    public Cliente findById(long id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId().equals(id))
                return cliente;
        }
        return null;
    }
    
    public void insert(Cliente cliente) {
        cliente.setId(++nextId);
        clientes.add(cliente);
    }
    
    public void update(long id, Cliente cliente) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId().equals(id)) {
                clientes.set(i, cliente);
                return;
            }
        }
    }
    
    public void delete(long id) {
        Cliente selecionado = null;
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId().equals(id)) {
                selecionado = clientes.get(i);
                break;
            }
        }
        if (selecionado != null)
            clientes.remove(selecionado);
    }
}
