data class Alumno(
    var nombre: String,
    var ap1: String,
    var ap2: String,
    var id: String
)

class Modulo(
    var maxAlumnos: Int
) {
    var arrayAlumnos = arrayOfNulls<Alumno>(maxAlumnos)
    var arrayAlumnosOrdenados = arrayOfNulls<Alumno>(maxAlumnos)
    var arrayNotas = Array(4) { arrayOfNulls<Float>(maxAlumnos) }
    var almacenIndex: Int = 0

    fun matricularAlumno(alumno: Alumno): Boolean {
        when (arrayAlumnos.indexOfFirst { it == null }) {
            in 0..maxAlumnos - 1 -> almacenIndex = arrayAlumnos.indexOfFirst { it == null }
            !in 0..maxAlumnos - 1 -> almacenIndex = -1
        }
        return if (almacenIndex.equals(-1)) {
            false
        } else {
            arrayAlumnos[almacenIndex] = alumno
            true
        }

    }

    fun bajaAlumno(idAlumno: String): Boolean {
        when (arrayAlumnos.indexOfFirst { it?.id == idAlumno }) {
            in 0..maxAlumnos - 1 -> almacenIndex = arrayAlumnos.indexOfFirst { it?.id == idAlumno }
            !in 0..maxAlumnos - 1 -> almacenIndex = -1
        }
        return if (almacenIndex.equals(-1)) {
            false
        } else {
            arrayAlumnos[almacenIndex] = null
            true
        }

    }

    // SOLO PARA TESTING
    fun imprimirListaAlumnos() {
        arrayAlumnosOrdenados = arrayAlumnos
        arrayAlumnosOrdenados.sortWith(nullsLast(compareBy { it.id }))

        println("--------------------------------")
        println("LISTA ALUMNOS")
        println("--------------------------------")
        arrayAlumnosOrdenados.forEach { println("${it?.nombre} ${it?.ap1} || Identificador: ${it?.id}") }
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

    moduloProgramacion.matricularAlumno(AlumnoA)
    moduloProgramacion.matricularAlumno(AlumnoB)
    moduloProgramacion.matricularAlumno(AlumnoC)
    moduloProgramacion.matricularAlumno(AlumnoD)
    moduloProgramacion.matricularAlumno(AlumnoE)
    moduloProgramacion.matricularAlumno(AlumnoF)

    moduloProgramacion.imprimirListaAlumnos()

    moduloProgramacion.bajaAlumno("2")
    moduloProgramacion.bajaAlumno("4")

    moduloProgramacion.imprimirListaAlumnos()
}