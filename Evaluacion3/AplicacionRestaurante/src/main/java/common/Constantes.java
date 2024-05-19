package common;

public class Constantes {

    //Menu inicial
    public static final String MENU_INICIAL = "Bienvenido al restaurante, escoga su rol: ";
    public static final String CLIENTE = "1. Cliente ";
    public static final String TRABAJADOR = "2. Trabajador ";



    //Menu Usuario
    public static final String  MENU_USUARIO = "Introduzca una opcion: ";
    public static final String AÑADIR_PLATO = "1. Añadir platos ";
    public static final String VER_CESTA = "2. Ver la cesta ";
    public static final String OPCION_ELIMINAR_PLATO = "3. Eliminar platos ";
    public static final String INICIAR_PEDIDO = "4. Pedir la comida ";
    public static final String TIEMPO_ESPERA = "5. Consultar el tiempo estimado de preparacion de su pedido ";
    public static final String NO_EXISTE_PEDIDO = "Todavia no se ha iniciado ese nuevo pedido, pulse '1' si desea crear uno nuevo, pulse '2' si quiere introducir de nuevo el numero de pedido ";
    public static final String NOMBRE_PLATO = "Introduce el nombre del plato que quiere añadir, si no quiere añadir mas platos escriba 'suficiente': ";
    public static final String CANTIDAD = "Introduzca la cantidad: ";
    public static final String SUFICIENTE = "suficiente";
    public static final String ELIMINAR_PLATO = "¿Que plato desea eliminar? (si no desea eliminar ninguno introduzca 'ninguno')";
    //public static final String INTRODUZCA_NOMBRE = "Introduzca su nombre se usuario: ";
    public static final String PEDIDO_COMENZADO = "Su pedido ha comenzado a preparase";
    public static final String QUIERE_AÑADIR_CUPONES = "¿Quiere añadir algun cupon a su pedido?";
    public static final String INTRODUZCA_CUPON = "Introduzca el cupon que desea añadir a su pedido";
    public static final String INTRODUZCA_ID_PEDIDO = "Introduzca el id del pedido, si lo que desea es introducir un nuevo pedido introduzca 'nuevo pedido' ";
    public static final String PEDIDO_NO_ENCONTRADO = "ID de pedido no valido, intentelo otra vez";
    public static final String INTRODUZCA_ID_USUARIO = "Introduzca su id de Usuario";
    public static final String EL_TIEMPO_ESTIMAD_ES = "El tiempo estimado de rpeapracion de su producto es de ";
    public static final String TIPO_PLATO = "Introduzca el tipo de plato que desea ver (recuerde que solo disponemos de pincipal, acompañante, guarnicion y postre) ";
    public static final String PLATO_AÑADIDO_CORRECTAMENTE = "Su plato ha sido añadido con exito ";
    public static final String PLATO_ELIMINADO_CORRECTAMENTE = "El plato ha sido eliminado con exito ";
    public static final String VER_PLATOS_POR_TIPO = "6. Ver la carta filtrada por tipo de plato ";
    public static final String PEDIR_CUENTA = "7. Pedir la cuenta ";



    //Menu Personal
    public static final String ELEGIR_ROL = "¿Que trabajo desempeña en la empresa? (recuerde que solo trabajan camareros y cocineros en el restaurante) ";
    public static final String CAMARERO = "Camarero ";
    public static final String COCINERO = "Cocinero ";
    public static final String MENU_EMPLEADO = "Introduzca lo que quiere hacer: ";
    public static final String AYUDAR_CLIENTE = "1. Visualizar los clientes que necesitan asistencia ";
    public static final String VER_PEDIDOS_CAMARERO = "2. Ver las comandas del restaurante ";
    public static final String VER_PLATOS = "1. Ver los platos a preparar ";
    public static final String COMFIRMAR_PLATO = "2. Comfirmar un plato ";
    public static final String PREPARADO = "listo ";
    public static final String NO_PREPARADO = "en preparacion ";
    public static final String INTRODUZCA_ID_PLATO = "Introuzca el id del pedido: ";
    public static final String NUEVO_PECIO = "Introduzca el nuevo precio: ";
    public static final String PRECIO_CAMBIADO = "El precio ha sido actualizado con exito ";
    public static final String ERROR_CAMBIAR_PRECIO = "Ha ocurrido un error inesperado y no se ha podido actualizar el precio del producto, intentlo de nuevo ";
    public static final String PEDIDO_LLEGARA = "Su pedido sera entregado en torno a las ";
    public static final String COMFIRMACION_ELIMINAR_PEDIDO = "¿Esta seguro de que quiere eliminar la carta? (esta accion podra no podra ser revertida) ";
    public static final String CARTA_ELIMINADA = "Se ha eliminado la carta ";



    //Errores
    public static final String OPCION_NO_VALIDA = "Opcion no, valida, pruebe otra vez ";
    public static final String SOLO_NUMEROS = "Porfavor, introduzca solamente números ";
    public static final String CAMARERO_CLIENTE = "En la empresa solamente trabajan camareros o cocineros, pruebe otra vez ";
    public static final String NOMBRE_USUARIO_INCORRCTO = "Nombre de usuario incorrecto";
    public static final String CONTRASEÑA_INCORRECTA = "Constraseña incorrecta";
    public static final String ERROR_PEDIDO = "No se ha podido completar la accion porque no existe pedido";
    public static final String CUPON_NO_VALIDO = "El cupon introducido no es válido ";
    public static final String TIPO_NO_VALIDO = "No disponesmos de ese tipo de plato, pruebe otra vez o indique 'salir'";
    public static final String IO_EXCEPTION_ERROR = "Ha ocurrido un error por falta de permisos de usuario, obtenga permiso para crear archivos antes de iniciar la aplicacion";
    public static final String ERROR_AÑADIR_PLATO = "Ha ocurrido un error al añadir su plato, compruebe que ha introducido el nombre del plato correctamente. Si lo desea, puede solicitar la asistencia de un camarero. ";
    public static final String ERROR_ELIMINAR_PLATO = "Ha ocurrido un error al eliminar su plato, compruebe que ha introducido correctamente el id ";
    public static final String ERROR_ELIMINAR_CARTA = "No se ha podido eliminar la carta, compruebe sus privilegios sobre el archivo carta.json ";
    public static final String ERROR_NO_REGISTRADO = "No se ha podido iniciar sesion porque el id introducido no esta registrado ";
    public static final String ERROR_NUEVO_PEDIDO = "Debido a un error inesperado no se ha podido crear su pedido, intentelo de nuevo ";



    //utilidades
    public static final String INTRODUZCA_CONTRASEÑA = "Porfavor, introduzca su contraseña de empleado ";
    public static final String CARTA_JSON = "carta.json";
    public static final String CLIENTES_TXT = "clientes";
    public static final String SEPARADOR_FICHEROSTXT = ";";
    public static final String PEDIDO = "Pedido ";
    public static final String NINGUNO = "Ninguno";
    public static final String MINUTOS = "min ";
    public static final String SEPARADOR_COLECCIONES = ":";
    public static final String SEPARADOR_ELEMENTOS_FACTURA = ",";


    //Logs
    public static final String LOG_FILE_NOT_FOUND = "No se ha encintrado el fichero y el programa se ha parado ";
}
