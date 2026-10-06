import crudusuarios.CRUDUsuarios;
import crudusuarios.Usuario;

public class PruebaUsuarios {

    public static void main(String[] args) {

        CRUDUsuarios crud = new CRUDUsuarios();

        String dniPrueba = "99999999";

        Usuario usuario1 = new Usuario(
                "Usuario",
                "Prueba",
                dniPrueba,
                "prueba@correo.com"
        );

        Usuario usuario2 = new Usuario(
                "Usuario",
                "Duplicado",
                dniPrueba,
                "duplicado@correo.com"
        );

        // Prueba 1: registrar usuario
        crud.agregarUsuario(usuario1);

        assert crud.buscarUsuario(dniPrueba) != null :
                "Falló el registro del usuario";

        // Prueba 2: verificar que el DNI ya existe
        assert crud.buscarUsuario(dniPrueba) != null :
                "Falló la búsqueda por DNI";

        // Prueba 3: eliminar el usuario de prueba
        assert crud.eliminarUsuario(dniPrueba) :
                "Falló la eliminación del usuario";

        System.out.println("Todas las pruebas de usuarios fueron exitosas.");
    }
}
