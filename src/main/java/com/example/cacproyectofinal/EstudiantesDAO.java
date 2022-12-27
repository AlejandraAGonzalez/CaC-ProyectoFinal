package com.example.cacproyectofinal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class EstudiantesDAO {
    /*metodos del crud*/
    public EstudiantesDAO obtenerPorIdPersona(int id) {
        String sql = "SELECT * FROM Estudiantes WHERE ID_PERSONA="+id;

        //Connection
        Connection con = AdministradorDeConexiones.getConnection();

        EstudiantesDAO estudianteFromDb = null;

        //Statement
        try {
            Statement st = con.createStatement();

            //resultset
            ResultSet rs = st.executeQuery(sql);

            //VIENE UN SOLO REGISTRO!!!

            if(rs.next()) {//si existe, hay uno solo
                // rs > sacando los datos
                Integer id_persona = rs.getInt(1);//tomar la primer columna
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                Integer edad = rs.getInt(4);

                //campos crear un objeto????
                estudianteFromDb = new Estudiantes(id_persona,nombre,apellido,edad);
            }
        } catch (SQLException e) {
            // ERRORES
            e.printStackTrace();
        }
        return estudianteFromDb;
    }


    /*metodos del crud*/
    public List<Estudiante> listarEstudiante() {
        String sql = "SELECT * FROM ESTUDIANTE ";

        //Connection
        Connection con = AdministradorDeConexiones.getConnection();

        List<Estudiante> list = new ArrayList<>();

        //Statement
        try {
            Statement st = con.createStatement();

            //resultset
            ResultSet rs = st.executeQuery(sql);

            //VIENE UN SOLO REGISTRO!!!

            while(rs.next()) {//
                // rs > sacando los datos
                Integer id_persona = rs.getInt(1);//tomar la primer columna
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                Integer edad = rs.getInt(4);

                //campos crear un objeto????
                EstudiantesDAO estudianteFromDb = new Estudiantes(id_persona,nombre,apellido,edad);

                //agrego a la lista
                list.add(estudianteFromDb);
            }

            //cierro la conexion
            con.close();
        } catch (SQLException e) {
            // ERRORES
            e.printStackTrace();
        }
        return list;
    }

    /*crear un estudiante en la db*/
    public void crearEstudiante(String nombre, String apellido, Integer edad) {

        Connection con = AdministradorDeConexiones.getConnection();

        if(con != null) {
            // insert en la db > SQL: INSERT INTO....
            String sql = "INSERT INTO PERSONA (nombre, apellido, edad) ";
            sql += "VALUES('"+nombre+"','"+apellido+"','"+edad+"')";

            //control de errores
            try {
                Statement st = con.createStatement();
                st.execute(sql);

                //cierre de conexion
                con.close();

            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void actualizarEstudiante(String nombre, String apellido, Integer edad) {
        Connection con = AdministradorDeConexiones.getConnection();
        if(con != null) {
            String sql = "UPDATE PRODUCTO "
                    + " set nombre='"+nombre+"',"
                    + " apellido='"+apellido+"'"
                    + " WHERE edad = '"+edad+"'";

            try {
                Statement st = con.createStatement();
                st.executeUpdate(sql);

                con.close();

            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /*metodos del crud*/
    public List<Estudiantes> buscar(String clave) {
        String sql = "SELECT * FROM ESTUDIANTE WHERE nombre LIKE '%"+clave+"%' ";

        //Connection
        Connection con = AdministradorDeConexiones.getConnection();

        List<Estudiantes> listado = new ArrayList<Estudiantes>();

        //Statement
        try {
            Statement st = con.createStatement();

            //resultset
            ResultSet rs = st.executeQuery(sql);

            //VIENE UN SOLO REGISTRO!!!

            if(rs.next()) {//si existe, hay uno solo
                // rs > sacando los datos
                Integer id_persona = rs.getInt(1);//tomar la primer columna
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                Integer edad = rs.getInt(4);


                //campos crear un objeto????
                Estudiantes estudianteFromDb = new Estudiantes(id_persona,nombre,apellido,edad);

                listado.add(estudianteFromDb);
            }
        } catch (SQLException e) {
            // ERRORES
            e.printStackTrace();
        }

        return listado;
    }
}
