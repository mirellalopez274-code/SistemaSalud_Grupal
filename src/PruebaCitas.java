import crudcitas.Cita;
import crudcitas.CRUDCitas;


public class PruebaCitas {

    public static void main(String[] args) {

        CRUDCitas crud = new CRUDCitas();

        String idPrueba = "PRUEBA_" + System.currentTimeMillis();

        Cita cita = new Cita(
                idPrueba,
                "PACIENTE01",
                "DOCTOR01",
                "05/10/2026",
                "10:00",
                "Consulta de prueba"
        );

        // Prueba 1: registrar una cita nueva
        assert crud.agregar(cita) :
                "Falló el registro de una cita nueva";

        // Prueba 2: impedir una cita con ID duplicado
        assert !crud.agregar(cita) :
                "Falló la validación de cita duplicada";

        // Prueba 3: impedir una actualización con paciente vacío
        assert !crud.actualizar(
                idPrueba,
                "",
                "DOCTOR01",
                "05/10/2026",
                "10:00",
                "Consulta de prueba"
        ) :
                "Falló la validación de paciente vacío";

        // Limpiar la cita creada para la prueba
        crud.eliminar(idPrueba);

        System.out.println("Todas las pruebas de citas fueron exitosas.");
    }
}
