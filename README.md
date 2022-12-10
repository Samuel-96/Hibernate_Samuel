# ejercicioHibernate
repositorio encargado de alojar la actividad de HIbernate.

El proyecto está organizado en paquetes, uno para cada tipo de relación, también otro para las consultas. He dejado comentadas tanto las clases instanciables como
las clases con main para explicar el funcionamiento de cada una y facilitar la corrección del ejercicio. En dichos comentarios dejo aclarado el tipo de relación, 
las clases que intervienen en la relación, quién es el propietario y el resultado de la ejecución del main (las tablas que se generan en la BD), también está explicado la cardinalidad y direccionalidad de la relación.

He querido probar a persistir una clase con un atributo de tipo Date para ver cómo es el proceso, también he hecho uso de dos tipos de estrategia para la relación de herencia, la de SINGLE TABLE y la de Join, en el código de las clases del paquete de herencia está explicado. Y por último he añadido una app con main encargada de crear la base de datos con nombre samuel, así que sería conveniente comenzar por ejecutar dicha clase.
