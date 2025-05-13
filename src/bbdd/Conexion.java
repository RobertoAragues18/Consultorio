/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bbdd;

import com.mysql.jdbc.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import modelo.Cita;
import modelo.Consulta;
import modelo.ConsultaEnfermeria;
import modelo.Paciente;
import modelo.Personal;
import utilidades.Encriptado;

/**
 *
 * @author rober
 */
public class Conexion {

    public static Connection conn;

    /**
     * Método donde se establecen los parámetros de conexión con la base de
     * datos.
     *
     * @return
     */
    public static Connection conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://145.14.151.1/u812167471_consultorio25", "u812167471_consultorio25", "2025-Consultorio");
            System.out.println("Conexión exitosa a la base de datos");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    /**
     * Método para cerrar la conexión con la base de datos.
     *
     * @return
     */
    public static void cerrarConexion() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Consulta para comprobar el logado de usuarios (personal)
     *
     * @param user
     * @param pass
     * @return
     */
    public static boolean acceder(String user, String pass) {
        try {
            String consulta = "SELECT usuario, contrasenya FROM personal WHERE usuario =? and contrasenya=?";

            PreparedStatement pst;
            ResultSet rs;

            pst = conn.prepareStatement(consulta);
            pst.setString(1, user);
            pst.setString(2, pass);
            rs = pst.executeQuery();

            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Recupera los datos del usuario logado tomando como referencia el nombre
     * de usuario (único). Recuperamos una cadena compuesta por el nombre y los
     * apellidos, su DNI y el número de colegiado, todo ello en un array de tipo
     * String con tres posiciones.
     *
     * @param user
     * @return
     */
    public static String[] recuperaDatosUser(String user) {

        String[] usuario = new String[3];
        
        String consulta = "SELECT CONCAT (nombre, ' ', apellidos), numero_colegiado, tipo FROM personal WHERE usuario= '" + user + "'";
        
        try {
            Statement st = conn.createStatement();
            try (ResultSet rs = st.executeQuery(consulta)) {
                if (rs.next()) {
                    usuario[0] = rs.getString(1);
                    usuario[1] = rs.getString(2);
                    usuario[2] = rs.getString(3);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usuario;
    }

    /**
     * Método que nos permitirá obtener de la base de datos las citas médicas
     * correspondientes a la fecha actual para cargarlas en una tabla
     *
     * @param modelo
     */
    public static void recuperaCitasMedicas(DefaultTableModel modelo) {
        try {
            Object[] datos = new Object[3];
            String consulta = "SELECT nombre, dia, hora FROM citas where dia = CURRENT_DATE()";

            ResultSet rs = conn.createStatement().executeQuery(consulta);
            while (rs.next()) {
                try {
                    datos[0] = Encriptado.desencriptar(rs.getString("nombre"));
                } catch (Exception ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                }
                datos[1] = rs.getString("dia");
                datos[2] = rs.getString("hora");

                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método que nos permitirá obtener de la base de datos las citas de
     * enfermería correspondientes a la fecha actual para cargarlas en una tabla
     *
     * @param modelo
     */
    public static void recuperaCitasEnfermeria(DefaultTableModel modelo) {
        try {
            Object[] datos = new Object[3];
            String consulta = " SELECT nombre, dia, hora FROM citasEnfermeria where dia = CURRENT_DATE()";

            ResultSet rs = conn.createStatement().executeQuery(consulta);
            while (rs.next()) {
                try {
                    datos[0] = Encriptado.desencriptar(rs.getString("nombre"));
                } catch (Exception ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                }
                datos[1] = rs.getString("dia");
                datos[2] = rs.getString("hora");

                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Consulta para el registro de citas con el nombre y el dni del paciente
     * encriptados
     *
     * @param c
     * @return
     */
    public static boolean registrarCitaMedica(Cita c) {

        return false;

    }

    /**
     * Consulta para el registro de citasEnfermeria con el nombre y el dni del
     * paciente encriptados
     *
     * @param c
     * @return
     */
    public static boolean registrarCitaEnfermeria(Cita c) {

        return false;

    }

    /**
     * Consulta para comprobar si un DNI existe en la tabla pacientes asociado a
     * algún paciente
     *
     * @param dni
     * @return
     */
    public static boolean compruebaDni(String dni) {

        return false;

    }

    /**
     * Descarga de información específica de pacientes cuyo dni se corresponda
     * al que pasamos como parámetro (nombre, apellidos, teléfono y email)
     *
     * @param dni
     * @return
     */
    public static Paciente recuperaDatosPaciente(String dni) throws Exception {

        Paciente p = null;

        String consulta = "SELECT dni, nombre, apellidos, telefono, email FROM paciente WHERE dni = ?";

        PreparedStatement pst;
        ResultSet rs;
        try {

            pst = conn.prepareStatement(consulta);
            pst.setString(1, Encriptado.encriptar(dni));
            rs = pst.executeQuery();

            if (rs.next()) {
                p = new Paciente(
                        Encriptado.desencriptar(rs.getString(2)),
                        Encriptado.desencriptar(rs.getString(3)),
                        rs.getInt(4),
                        rs.getString(5)
                );

            }

        } catch (SQLException ex) {

            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return p;
    }

    /**
     * Método para rescatar el listado de consultas médicas de la base de datos
     * y organizarlos para su visualización en una tabla
     *
     * @param modelo
     * @param dni
     */
    public static void cargaTablaConsultasMedicas(DefaultTableModel modelo, String dni) {

    }

    /**
     * Método para rescatar el listado de consultas de enfermería de la base de
     * datos y organizarlos para su visualización en una tabla
     *
     * @param modelo
     * @param dni
     */
    public static void cargarTablaConsultasEnfermeria(DefaultTableModel modelo, String dni) {
        try {
            Object[] datos = new Object[5];
            String consulta = " SELECT fechaConsulta, tensionMax, tensionMin, glucosa, peso  from enfermeria where fechaConsulta = CURRENT_DATE()";

            ResultSet rs = conn.createStatement().executeQuery(consulta);
            while (rs.next()) {

                datos[0] = rs.getString("fechaConsulta");

                datos[1] = rs.getString("tensionMax");
                datos[2] = rs.getString("tensionMax");
                datos[3] = rs.getString("glucosa");
                datos[4] = rs.getString("peso");
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Consulta para el registro de consultas médicas en la base de datos
     *
     * @param c
     * @return
     */
    public static boolean registrarConsultaMedica(Consulta c) {
        try {
            String consulta = "INSERT INTO consultas (dniPaciente, fechaConsulta, diagnostico, tratamiento, "
                    + "observaciones, codigofacultativo) "
                    + "values (?, ?, ?, ?, ?, ?)";

            PreparedStatement pst = conn.prepareStatement(consulta);
            try {
                pst.setString(1, Encriptado.encriptar(c.getDniPaciente()));
                pst.setDate(2, new java.sql.Date(c.getFechaConsulta().getTime()));
                pst.setString(3, c.getDiagnostico());
                pst.setString(4, c.getTratamiento());
                pst.setString(5, c.getObservaciones());
                pst.setInt(6, c.getCodigoFacultativo());

            } catch (Exception ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }

            pst.execute();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Consulta para el registro de consultas de enfermería en la base de datos
     *
     * @param c
     * @return
     */
    public static boolean registrarConsultaEnfermeria(ConsultaEnfermeria c) {
        try {
            String consulta = "INSERT INTO enfermeria(dniPaciente, fechaConsulta, tensionMax, tensionMin, "
                    + "glucosa, peso,  codigoFacultativo) "
                    + "values (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pst = conn.prepareStatement(consulta);
            try {
                pst.setString(1, Encriptado.encriptar(c.getDniPaciente()));
                pst.setDate(2, new java.sql.Date(c.getFechaConsulta().getTime()));
                pst.setDouble(3, c.getMaxima());
                pst.setDouble(4, c.getMinima());
                pst.setInt(5, c.getGlucosa());
                pst.setDouble(6, c.getPeso());
                pst.setInt(7, c.getCodigoFacultativo());

            } catch (Exception ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }

            pst.execute();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Carga en JComboBox de los códigos postales asociados al centro médico
     * desde la base de datos, dato imprescindible para el registro de pacientes
     *
     * @param combo
     */
    public static void cargaComboCp(JComboBox combo) {
        try {
            String consulta = "SELECT codigopostal FROM codigospostales";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(consulta);

            while (rs.next()) {
                combo.addItem(rs.getString("codigopostal"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Consulta para la incorporación de nuevos pacientes a la aplicación
     *
     * @param p
     * @return
     */
    public static boolean registrarPaciente(Paciente p) {
        try {
            String consulta = "INSERT INTO pacientes (nombre, apellidos, fechaNacimiento, telefono, email, cp, sexo, tabaquismo, consumoAlcohol,"
                    + " antecedentesSalud, datosSaludGeneral, fechaRegistro) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(consulta);

            pst.setString(1, p.getNombre());
            pst.setString(2, p.getApellidos());
            pst.setDate(3, (Date) p.getFechaNacimiento());
            pst.setInt(4, p.getTelefono());
            pst.setString(5, p.getEmail());
            pst.setInt(6, p.getCp());
            pst.setString(7, p.getSexo());
            pst.setString(8, p.getTabaquismo());
            pst.setString(9, p.getConsumoAlcohol());
            pst.setString(10, p.getAntecedentesSalud());
            pst.setString(11, p.getDatosSaludGeneral());
            pst.setDate(12, (Date) p.getFechaRegistro());

            pst.execute();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Método para rescatar el listado de pacientes de la base de datos y
     * organizarlos para su visualización en una tabla
     *
     * @param modelo
     */
    public static void cargaTablaPacientes(DefaultTableModel modelo) {
        try {
            Object[] datos = new Object[5];

            String consulta = "SELECT dni, nombre, apellidos, telefono, cp FROM paciente ";

            ResultSet rs = conn.createStatement().executeQuery(consulta);
            while (rs.next()) {
                try {
                    datos[0] = Encriptado.desencriptar(rs.getString("dni"));
                    datos[1] = Encriptado.desencriptar(rs.getString("nombre"));
                    datos[2] = Encriptado.desencriptar(rs.getString("apellidos"));
                } catch (Exception ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                }

                datos[3] = rs.getString("telefono");
                datos[4] = rs.getString("cp");

                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Consulta para comprobar que el nombre de usuario en el proceso de
     * registro de personal está disponible
     *
     * @param user
     * @return
     */
    public static boolean compruebaUser(String user) {

        return false;

    }

    /**
     * Consulta para comprobar que el número de colegiado del empleado en el
     * proceso de registro está disponible o existe ya algún personal médico
     * registrado con ese número de colegiado
     *
     * @param numero
     * @return
     */
    public static boolean compruebaNumeroColegiado(long numero) {

        return false;

    }

    /**
     * Consulta para la incorporación de nuevos empleados médicos a la
     * aplicación (médicos o enfermería)
     *
     * @param p
     * @return
     */
    public static boolean registrarPersonal(Personal p) {

        return false;

    }

    public static boolean actualizaDatos(Paciente p, String dni) {

        try {
            String consultasUpdate = "UPDATE paciente set nombre=?, apellidos=?, telefono=?, cp=? WHERE dni=?";

            PreparedStatement stat = conn.prepareStatement(consultasUpdate);

            try {
                stat.setString(1, Encriptado.encriptar(p.getNombre()));
                stat.setString(2, Encriptado.encriptar(p.getApellidos()));
                stat.setString(5, Encriptado.encriptar(dni));
            } catch (Exception ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }

            stat.setInt(3, p.getTelefono());
            stat.setInt(4, p.getCp());

            stat.executeUpdate();
            stat.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
