package com.platzi.repository;

import com.platzi.DAO.ClienteDAO;
import com.platzi.model.Cliente;

import java.util.List;

public class ClienteRepositoryImpl implements CrudRepository<Cliente> {

    @Override
    public List<Cliente> findAll() {
        return ClienteDAO.consultarCliente();
    }

    @Override
    public Cliente getById(Integer id) {
        return ClienteDAO.consultarClienteByIdentificacion(String.valueOf(id));
    }

    @Override
    public void save(Cliente cliente) {
        ClienteDAO.insertarCliente(cliente);
    }

    @Override
    public void delete(Integer id) {
        ClienteDAO.EliminarCliente(String.valueOf(id));
    }

    @Override
    public void update(Cliente cliente, Integer id) {
        ClienteDAO.actualizarClienteByIdentificacion(cliente, String.valueOf(id));
    }
}
