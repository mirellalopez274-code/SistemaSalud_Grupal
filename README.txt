SISTEMA DE SALUD - PARCIAL INTEGRADO
====================================

Proyecto integrado para Apache NetBeans.

ACCESO AL SISTEMA
Credenciales: configuradas de forma local para las pruebas.
No se almacenan contraseñas en el repositorio.

MODULOS
- Login
- Menú principal
- Gestión de pacientes
- Gestión de usuarios
- Gestión de personal médico / doctores
- Gestión de medicamentos

COMO ABRIR EN APACHE NETBEANS
1. Descomprime este archivo ZIP.
2. Abre Apache NetBeans.
3. Selecciona File > Open Project.
4. Selecciona la carpeta SistemaSalud_Parcial_Integrado.
5. Espera a que NetBeans reconozca el proyecto.
6. Presiona F6 (Run Project).
7. Ingresa usuario diego y contraseña diego2230.

REQUISITO
- Java JDK 17 o superior.

El proyecto tiene main class: Main.

BUENAS PRACTICAS Y RIESGOS

- Validación de datos de entrada para evitar registros incorrectos.
- Manejo de excepciones para informar errores durante la ejecución.
- Prevención de registros duplicados mediante identificadores.
- Protección de credenciales evitando almacenarlas en texto plano.

RIESGOS Y MITIGACIONES

- Datos inválidos: se controlan mediante validaciones.
- Registros duplicados: se verifica el identificador antes de guardar.
- Errores de archivos: se controlan mediante excepciones.
- Exposición de credenciales: no se almacenan contraseñas en el README.

CONSECUENCIAS

Una baja calidad del sistema puede generar registros incorrectos,
errores durante la atención y pérdida de confiabilidad de la información.
Por ello, las validaciones, el manejo de excepciones y las pruebas
automatizadas ayudan a mejorar la seguridad y confiabilidad del sistema.