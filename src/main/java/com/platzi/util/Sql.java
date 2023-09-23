package com.platzi.util;

public class Sql {
    public static final String INSERT_CLIENTE =
            "INSERT INTO cliente (identificacion, nombre, direccion, telefono) " +
                    " VALUES (?, ?, ?, ?)";
    public static final String CONSULTAR_TODOS_LOS_CLIENTES =
            "SELECT * FROM CLIENTE";

    public static final String CONSULTAR_CLIENTE_POR_ID =
            "SELECT * FROM cliente WHERE identificacion = ?";

    public static final String ACTUALIZAR_CLIENTE_BY_ID =
            "UPDATE cliente set nombre = ?, direccion = ?, telefono =?" +
                    " where identificacion = ?";

    public static final String ELIMINAR_CLIENTE_BY_ID =
            "DELETE FROM cliente where identificacion = ?";

}
