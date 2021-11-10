data class Alumno(
    var nombreAlumno: String,
    var apellido1Alumno: String,
    var apellido2Alumno: String,
    var identificadorInstituto: String
)

class Modulo(
    var numeroAlumnos: Int
) {
    var arrayAlumnos = arrayOfNulls<Alumno>(numeroAlumnos)
    var arrayAlumnosOrdenados = arrayOfNulls<Alumno>(numeroAlumnos)
    var arrayNotas = Array(4) { arrayOfNulls<Float>(numeroAlumnos) }

    fun anadirAlumno(alumnoAnadido: Alumno) {
        // Añade alumno en una posicion vacia dentro del array "arrayAlumno"
        // TODO Revisar indexOfFirst para quitar try-catch
        try {
            arrayAlumnos[arrayAlumnos.indexOfFirst { it == null }] = alumnoAnadido
        } catch (_: ArrayIndexOutOfBoundsException) {
            println("Es imposible a este alumno")
        }

    }

    fun eliminarAlumno(alumnoEliminado: Alumno) {
        // TODO Revisar indexOfFirst para quitar try-catch
        try {
            arrayAlumnos[arrayAlumnos.indexOfFirst { it == alumnoEliminado }] = null
        } catch (_: ArrayIndexOutOfBoundsException) {
            println("No se ha encontrado el alumno")
        }

    }

    // SOLO PARA TESTING
    fun imprimirListaAlumnos(){
        arrayAlumnosOrdenados = arrayAlumnos
        arrayAlumnosOrdenados.sortWith(nullsLast(compareBy {it.identificadorInstituto}))

        println("--------------------------------")
        println("LISTA ALUMNOS")
        println("--------------------------------")
        arrayAlumnosOrdenados.forEach { println("${it?.nombreAlumno} ${it?.apellido1Alumno} || Identificador: ${it?.identificadorInstituto}") }
        println("--------------------------------")
        println("")
    }

    // SOLO PARA TESTING
    fun imprimirListaNotas(){
        println("--------------------------------")
        println("LISTA NOTAS ALUMNOS")
        println("--------------------------------")
        arrayNotas.forEach { println("${it[0]}, ${it[1]}, ${it[2]}, ${it[3]}") }
        println("--------------------------------")
        println("")
    }

}

fun main() {
    var AlumnoA = Alumno("Pata", "Carglas", "Lunas", "3")
    var AlumnoB = Alumno("Peta", "Carglas", "Lunas", "1")
    var AlumnoC = Alumno("Pita", "Carglas", "Lunas", "2")
    var AlumnoD = Alumno("Pota", "Carglas", "Lunas", "4")
    var AlumnoE = Alumno("Maria", "Carglas", "Lunas", "5")
    var AlumnoF = Alumno("Puta", "Carglas", "Lunas", "6")

    var moduloProgramacion = Modulo(5)

    moduloProgramacion.anadirAlumno(AlumnoA)
    moduloProgramacion.anadirAlumno(AlumnoB)
    moduloProgramacion.anadirAlumno(AlumnoC)
    moduloProgramacion.anadirAlumno(AlumnoD)
    moduloProgramacion.anadirAlumno(AlumnoE)
    moduloProgramacion.anadirAlumno(AlumnoF)

    moduloProgramacion.imprimirListaAlumnos()

    moduloProgramacion.eliminarAlumno(AlumnoC)
    moduloProgramacion.eliminarAlumno(AlumnoF)

    moduloProgramacion.imprimirListaAlumnos()

    moduloProgramacion.imprimirListaNotas()
}