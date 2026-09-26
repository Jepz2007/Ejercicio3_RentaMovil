# Ejercicio3_RentaMovil

# Análisis

## Requisitos

- Registro de información de todo vehículo al ingresar, incluyendo estado entre alguilado/disponible.
- Placas únicas.
- Registro de nuevos vehículos.
- Calcular el cobro correspondiente a cada vehículo y su uso.
- Permitir cotizaciones de todo vehículo.
- Dar opción de alquilar si el vehículo está disponible.
- Consultar informe de agencia.

## Reglas de Cobro
### General:
- Tarifa diaria por cantidad de días.

### Automóvil:
- Si es automático se le recargan Q50.00 cada día.

### Motocicleta:
- Si la motocicleta supera los 250 cc se agrega un cargo adicional de Q75.00 al total.

### Camioneta de Carga:
- Según las toneladas de capacidad máxima de un vehículo se cobran (Q100.00 multiplicado por dicha capacidad) al día.
  
## Condiciones de Operaciones
- Para el registro de información se deben de ingresar todos los datos solicitados en el formato adecuado y coherente.
- Validar que una nueva placa registrada no se repita.
- Los nuevos vehículos registrados deben de aparecer disponibles automáticamente.
- Deben de mostrarse claros los datos más solicitados por los tipos de clientes.
- Para el alquiler de los vehículos se debe de solicitar los días que se usará el vehículo.
- Se debe de validar que toda la info. solicitada sea coherente para poder trabajar adecuadamente con las operaciones de cobros.

## Clases
### Vehículo

Esta clase será la clase padre de la que tendrán herencia las clases automóvil, motocicleta y camioneta. Tendrá los datos que todas las clases mencionadas comparten: placa, marca, modelo, tarifa diaria y disponibilidad, además tendrá el dato de días de alguiler que será 0 siempre que esté disponible y cuando se alquile se le asignará la cantidad de días; entre sus comportamientos tendrá la opción de obtener todos los datos de la clase, también de solo obtener los días de alquiler o solo la disponibilidad y también debe de calcular el cobro solo de la tarifa diaria por los días de alguiler para la cotización, que se llamará tarifa parcial, además podrá realizar la devolución y tendrá que poder establecer/cambiar la disponibilidad y los días de alquiler.

### Automóvil

Esta clase hija de la clase vehículo tendrá como extra las caracetrísticas de: Cantidad de pasajeros y tipo de transimisión; entre sus comportamientos podrá crear autos, además podrá calcular la tarifa final utilizando la tarifa parcial de la clase vehículo y agregando los cargos adicionales según las características del automóvil. 

### Motocicleta

Esta clase hija de la clase vehículo tendrá como característica extra el cilindraje; entre sus comportamientos podrá crear motocicletas y calcular la tarifa final utilizando la tarifa parcial de la clase vehículo y agregando los cargos adicionales según las características de la motocicleta.

### Camioneta

Esta clase hija de la clase vehículo tendrá como característica extra la capacidad máxima de carga, la cual se expresará en toneladas; entre sus comportamientos podrá crear camionetas y calcular la tarifa final utilizando la tarifa parcial de la clase vehículo y agregando los cargos adicionales según las características de la camioneta.

### Registro

Esta clase tendrá listas para almacenar por separado los registros de automóviles, motocicletas y camionetas, además tendrá una lista para registrar los ingresos obtenidos. Entre sus comportamientos podrá contar los registros totales y mostrar la cantidad de vehículos disponibles y alquilados según cada categoría de vehículo, además podrá calcular el total de ingresos según los alquileres confirmados.

### Controlador

Esta clase será la encargada de conectar la vista con las demás clases y controlar las operaciones solicitadas por el usuario; entre sus comportamientos permitirá registrar vehículos, consultar la flota, realizar cotizaciones, confirmar alquileres, registrar devoluciones y solicitar el reporte general. También comprobará que las operaciones sean válidas, como evitar placas repetidas, impedir el alquiler de vehículos ocupados y evitar la devolución de vehículos que ya estén disponibles. 

### Vista

Esta clase será la encargada de la interacción con el usuario por medio de la consola; mostrará un menú que permanecerá disponible hasta que el usuario decida salir y solicitará los datos necesarios para cada operación. También mostrará la información de los vehículos, las cotizaciones, los montos con dos decimales, los reportes y los mensajes correspondientes cuando una operación sea completada o rechazada. Además deberá controlar que las entradas con un formato incorrecto no provoquen que el programa termine inesperadamente.

### Todos los tipos de datos, parámetros y la disponibilidad se encuentran en el diagrama de clases UML.

Las características comunes de todos los vehículos, como la placa, marca, modelo, tarifa diaria, disponibilidad y días de alquiler, se organizarán dentro de la clase padre Vehículo para evitar repetir los mismos atributos y comportamientos en cada categoría; mientras que las características particulares, como la cantidad de pasajeros y transmisión de los automóviles, el cilindraje de las motocicletas y la capacidad máxima de las camionetas, estarán en sus respectivas clases hijas. De esta manera, si la empresa incorpora otra categoría, solamente sería necesario crear una nueva clase hija que herede de Vehículo, agregar sus características propias y definir la forma en que calculará su tarifa final, aunque también se tendría que agregar su almacenamiento y las opciones necesarias para registrarla y mostrarla dentro del sistema.
