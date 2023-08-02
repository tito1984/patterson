
# Technic test Patterson

Part of the aptitude test for the position of software developer



![Static Badge](https://img.shields.io/badge/Java-17-red)
![Static Badge](https://img.shields.io/badge/Spring%20Boot-2.7.14-green)


## Statement

Un cliente nos solicita realizarle una aplicación que le permita generar formularios que puedan ser 
rellenados por los usuarios del aplicativo. Estos podrán acceder a los formularios mediante una URL pública y personalizada para cada usuario.

Las respuestas de cada uno de estos formularios tienen que ser almacenadas para luego poder ser 
explotadas en un Dashboard que estará personalizado según la respuesta que se haya realizado en el formulario correspondiente.

No entrará dentro del alcance de este caso práctico la generación de formularios, ya que se supondrá que para la parte de Back únicamente se debe tener en cuenta que existirá una entidad formulario y respuestas que serán explotadas en un Dashboard.

Por tanto, el alcance del caso práctico debe cubrir las siguientes funcionalidades:

• Modelo de datos del proyecto: Basta realizar el MER con sus relaciones entre tablas e indicando los campos más importantes de cada una de las tablas. También se debe decidir y justificar la BBDD seleccionada, pudiendo ser relacional o no según se considere.

• Patrón de diseño de las aplicaciones Back: Se debe seleccionar y justificar el patrón de diseño 
utilizado, el Framework seleccionado, capa de persistencia si se considera, …
• Justificar cómo se gestionarán y generarán éstas URLs públicas de los formularios. Se quiere una explicación de la forma en que se explotarán éstas URLs, además de los parámetros necesarios para poder hacerlo.

Suposiciones

✓ Se supone que la personalización del dashboard vendrá dada por la respuesta en alguna de las 
preguntas del formulario. Para simplificar el caso se supone tener un listado de 2 posibles valores (pudiendo ser inventados) sobre los cuales se llevará a cabo la personalización.

✓ El equipo de Front trabajará de forma que solo necesitará del JSON del Back para poder pintar el 
Dashboard.

✓ Todo el tema de DevOps queda fuera del caso y se supondrá que estará realizado con un sistema de CI / CD (opcional plantear solución)

✓ Será un plus todo el detalle que se especifique a la hora de justificar los patrones de diseño, 
tecnologías y frameworks utilizados.

✓ No se pretende que el caso cubra todo el código fuente del aplicativo, pero se requiere el tener al menos el diseño de la aplicación, clases y métodos más importantes

## API Reference

#### Get all forms for user

```http
  GET /forms/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Long` | **Required**. Id of user |

#### Get item

```http
  Post /answers/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Long` | **Required**. Id of user |
| Body |      |                        |
| `question`      | `String` | **Required**. Question you want to answer |
| `answer`      | `String` | **Required**. Question answer |




