package com.platzi.DAO;

import com.platzi.model.Cliente;
import com.platzi.util.Conexion;
import com.platzi.util.Constants;
import com.platzi.util.Sql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private static Connection getConnection() throws SQLException {
        return Conexion.getConection();
    }

    public static List<Cliente> consultarCliente() {

        List<Cliente> clienteList = new ArrayList<>();

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(Sql.CONSULTAR_TODOS_LOS_CLIENTES);) {

            while (resultSet.next()) {
                clienteList.add(loadClients(resultSet));
            }

            return clienteList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Cliente loadClients(ResultSet resultSet) throws SQLException {
        return new Cliente(
                resultSet.getString(Constants.IDENTIFICACION),
                resultSet.getString(Constants.NOMBRE),
                resultSet.getString(Constants.DIRECCION),
                resultSet.getString(Constants.TELEFONO)
        );
    }

    public static Cliente consultarClienteByIdentificacion(String identificacion) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(Sql.CONSULTAR_CLIENTE_POR_ID);
        ) {

            preparedStatement.setString(1, identificacion);

            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    return loadClients(resultSet);
                }
                System.out.println("cliente no existe");
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al consultar el cliente por identificación: " + e.getMessage(), e);
        }
    }

    public static void actualizarClienteByIdentificacion(Cliente cliente, String identificacion) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(Sql.ACTUALIZAR_CLIENTE_BY_ID);) {

            preparedStatement.setString(1, cliente.getNombre());
            preparedStatement.setString(2, cliente.getDireccion());
            preparedStatement.setString(3, cliente.getTelefono());
            preparedStatement.setString(4, identificacion);

            soutResultState(preparedStatement.executeUpdate());


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void EliminarCliente(String identificacion) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     Sql.ELIMINAR_CLIENTE_BY_ID);) {

            preparedStatement.setString(1, identificacion);

            soutResultState(preparedStatement.executeUpdate());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void insertarCliente(Cliente cliente) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     Sql.INSERT_CLIENTE)) {

            preparedStatement.setString(1, cliente.getIdentificacion());
            preparedStatement.setString(2, cliente.getNombre());
            preparedStatement.setString(3, cliente.getDireccion());
            preparedStatement.setString(4, cliente.getTelefono());

            soutResultState(preparedStatement.executeUpdate());


        } catch (SQLException e) {
            throw new RuntimeException("Error al insertar el cliente " + e.getMessage(), e);
        }
    }

    private static void soutResultState(int rowsAffected) {
        if (rowsAffected > 0) {
            System.out.println("query exitosa.");
        } else {
            System.out.println("query no exitosa.");
        }
    }
}
