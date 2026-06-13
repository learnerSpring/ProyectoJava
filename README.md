# ⛪ Sistema de Gestión Parroquial (Sacramentos)


Este proyecto es una aplicación de escritorio desarrollada en **Java Standard Edition (Java SE)** y diseñada con **Swing** para automatizar, digitalizar y optimizar los procesos manuales de registro y control de sacramentos (Bautizos, Confirmaciones y Matrimonios) en una institución eclesiástica.

El sistema reemplaza las bitácoras físicas tradicionales por un almacenamiento relacional robusto, agilizando las búsquedas de actas y automatizando la expedición de documentos oficiales mediante plantillas de impresión profesional.

---

## 🚀 Características Principales

El sistema organiza la información parroquial mediante flujos de trabajo claros y módulos especializados:

* **Gestión Completa de Sacramentos (CRUD):**
    * **Bautizos:** Registro detallado del bautizado, padres, padrinos, datos de nacimiento y asignación de ministros.
    * **Confirmaciones:** Control cronológico y registro de confirmandos y padrinos.
    * **Matrimonios:** Control y archivo de actas matrimoniales de los contrayentes y sus testigos.
* **Operaciones de Datos Avanzadas:**
    * **Ingreso Eficiente:** Formularios con validación de campos obligatorios y cálculo automático de secuencias eclesiásticas (ej. número de Registro Parroquial incrementado dinámicamente mediante consultas del valor máximo en la base de datos).
    * **Consultas Dinámicas:** Búsqueda flexible de registros integrando filtros por nombres del sacramentado o familiares directos.
    * **Modificación Dinámica:** Recuperación completa de registros existentes para corregir o actualizar datos en tiempo real.

* **Módulo de Autoridades Eclesiásticas:** Catálogo independiente para administrar el registro de Sacerdotes, Párrocos y Ministros autorizados para oficiar las ceremonias y firmar los certificados (desplegados de forma dinámica en componentes `JComboBox`).
* **Reportería Automatizada e Impresión:** Generación instantánea de actas, fes de bautismo y certificados eclesiásticos oficiales utilizando **JasperReports**, listos para previsualización e impresión física.

---

## 🛠️ Stack Tecnológico

* **Lenguaje de Programación:** Java SE (Java Standard Edition) con componentes de interfaz gráfica **Java Swing**.
* **Persistencia de Datos:** **JDBC (Java Database Connectivity)** para transacciones directas, nativas y de alto rendimiento con el motor de base de datos sin sobrecarga de ORMs.
* **Motor de Base de Datos:** **MySQL**, implementando queries optimizados, conversiones explícitas de tipos (`CAST(... AS UNSIGNED)`).
* **Motor de Reportes:** **JasperReports / iReport**, para la compilación de archivos `.jrxml` a `.jasper` e inyección de parámetros dinámicos en tiempo de ejecución.

---

## 📐 Estructura de Código

El código fuente implementa una separación clara de responsabilidades para favorecer el mantenimiento:

* `com.iglesia.bautizos`: Contiene las interfaces gráficas de usuario (`gui_Consulta`, `gui_Ingreso_Bautizo`, `gui_Modifica_bautizo`) que controlan los eventos de pantalla y la lógica de interacción inmediata.
* `com.iglesia.autoridades`: Clases de entidad y lógica asociadas al cuerpo eclesiástico.
* `com.iglesia.funciones`: Encargada del despacho de conexiones a la base de datos.

---






















 
