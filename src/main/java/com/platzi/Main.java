package com.platzi;


import com.platzi.model.Cliente;
import com.platzi.repository.ClienteRepositoryImpl;
import com.platzi.repository.CrudRepository;

public class Main {
    public static void main(String[] args) {
        CrudRepository<Cliente> clienteCrudRepository = new ClienteRepositoryImpl();
        clienteCrudRepository.findAll().forEach(System.out::println);
    }
}