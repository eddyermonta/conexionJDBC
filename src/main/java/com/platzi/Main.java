package com.platzi;


import com.platzi.entity.ClienteEntity;
import com.platzi.util.UtilEntity;
import jakarta.persistence.EntityManager;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = UtilEntity.getEntityManager();
        List<ClienteEntity> clients = entityManager.createQuery("select c from ClienteEntity c", ClienteEntity.class).getResultList();
        clients.forEach(System.out::println);
    }
}