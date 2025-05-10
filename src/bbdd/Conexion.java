/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bbdd;

import com.mysql.jdbc.Connection;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import modelo.Cita;
import modelo.Consulta;
import modelo.ConsultaEnfermeria;
import modelo.Paciente;
import modelo.Personal;

/**
 *
 * @author rober
 */
public class Conexion {

    /**
     * Método donde se establecen los parámetros de conexión con la base de
     * datos.
     *
     * @return
     */
    public static Connection conexion() {

    }

    /**
     * Método para cerrar la conexión con la base de datos.
     *
     * @return
     */
    public static void cerrarConexion() {

    }

    /**
     * Consulta para comprobar el logado de usuarios (personal)
     *
     * @param user
     * @param pass
     * @return
     */
    public static boolean acceder(String user, String pass) {

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
    public static String[] recuperaDatosUserLogado(String user) {

    }

    /**
     * Método que nos permitirá obtener de la base de datos las citas médicas
     * correspondientes a la fecha actual para cargarlas en una tabla
     *
     * @param modelo
     */
    public static void recuperaCitasMedicas(DefaultTableModel modelo) {

    }

    /**
     * Método que nos permitirá obtener de la base de datos las citas de
     * enfermería correspondientes a la fecha actual para cargarlas en una tabla
     *
     * @param modelo
     */
    public static void recuperaCitasEnfermeria(DefaultTableModel modelo) {

    }

    /**
     * Consulta para el registro de citas con el nombre y el dni del paciente
     * encriptados
     *
     * @param c
     * @return
     */
    public static boolean registrarCitaMedica(Cita c) {

    }

    /**
     * Consulta para el registro de citasEnfermeria con el nombre y el dni del
     * paciente encriptados
     *
     * @param c
     * @return
     */
    public static boolean registrarCitaEnfermeria(Cita c) {

    }

    /**
     * Consulta para comprobar si un DNI existe en la tabla pacientes asociado a
     * algún paciente
     *
     * @param dni
     * @return
     */
    public static boolean compruebaDni(String dni) {

    }

    /**
     * Descarga de información específica de pacientes cuyo dni se corresponda
     * al que pasamos como parámetro (nombre, apellidos, teléfono y email)
     *
     * @param dni
     * @return
     */
    public static Paciente recuperaDatosPaciente(String dni) {

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
    public static void cargaTablaConsultasEnfermeria(DefaultTableModel modelo, String dni) {

    }

    /**
     * Consulta para el registro de consultas médicas en la base de datos
     *
     * @param c
     * @return
     */
    public static boolean registrarConsultaMedica(Consulta c) {

    }

    /**
     * Consulta para el registro de consultas de enfermería en la base de datos
     *
     * @param c
     * @return
     */
    public static boolean registrarConsultaEnfermeria(ConsultaEnfermeria c) {

    }

    /**
     * Carga en JComboBox de los códigos postales asociados al centro médico
     * desde la base de datos, dato imprescindible para el registro de pacientes
     *
     * @param combo
     */
    public static void cargaComboCp(JComboBox combo) {

    }

    /**
     * Consulta para la incorporación de nuevos pacientes a la aplicación
     *
     * @param p
     * @return
     */
    public static boolean registrarPaciente(Paciente p) {

    }

    /**
     * Método para rescatar el listado de pacientes de la base de datos y
     * organizarlos para su visualización en una tabla
     *
     * @param modelo
     */
    public static void cargaTablaPacientes(DefaultTableModel modelo) {

    }

    /**
     * Consulta para comprobar que el nombre de usuario en el proceso de
     * registro de personal está disponible
     *
     * @param user
     * @return
     */
    public static boolean compruebaUser(String user) {

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

    }

    /**
     * Consulta para la incorporación de nuevos empleados médicos a la
     * aplicación (médicos o enfermería)
     *
     * @param p
     * @return
     */
    public static boolean registrarPersonal(Personal p) {

    }
}
