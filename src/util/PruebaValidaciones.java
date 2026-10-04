package util;

public class PruebaValidaciones {

    public static void main(String[] args) {

        assert Validaciones.textoNoVacio("Paciente") :
                "Falló la validación de texto";

        assert !Validaciones.textoNoVacio("") :
                "Falló la validación de texto vacío";

        assert Validaciones.numeroPositivo("25") :
                "Falló la validación de número positivo";

        assert !Validaciones.numeroPositivo("-5") :
                "Falló la validación de número negativo";

        System.out.println("Todas las pruebas de validaciones fueron exitosas.");
    }
}
