package cl.ucn.disc.as.connectionSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection getConnection() throws SQLException {
        String jdbcUrl = "jdbc:sqlite:C:\\Users\\Matias\\Desktop\\My Homeworks\\acceso por carpetas\\De carrera\\9 semestre\\arq de sistemas\\primera vez\\tareas\\conserjeria\\NewConserjeria.db";
        return DriverManager.getConnection(jdbcUrl);
    }

}
