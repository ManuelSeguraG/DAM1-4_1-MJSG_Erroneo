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
    var arrayNotas = Array(4) { arrayOfNulls<String>(maxAlumnos) }
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

}

fun main() {

}