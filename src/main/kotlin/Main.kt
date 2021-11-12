data class Alumno(
    var nombre: String,
    var ap1: String,
    var ap2: String,
    var id: String
)

class Modulo(
    var maxAlumnos: Int
) {
    var alumnos = arrayOfNulls<Alumno>(maxAlumnos)
    var alumnosOrdenados = arrayOfNulls<Alumno>(maxAlumnos)
    var evaluaciones = Array(4) { arrayOfNulls<String>(maxAlumnos) }
    var almacenIndex: Int = 0

    fun matricularAlumno(alumno: Alumno): Boolean {
        when (alumnos.indexOfFirst { it == null }) {
            in 0..maxAlumnos - 1 -> almacenIndex = alumnos.indexOfFirst { it == null }
            !in 0..maxAlumnos - 1 -> almacenIndex = -1
        }
        return if (almacenIndex.equals(-1)) {
            false
        } else {
            alumnos[almacenIndex] = alumno
            true
        }

    }

    fun bajaAlumno(idAlumno: String): Boolean {
        when (alumnos.indexOfFirst { it?.id == idAlumno }) {
            in 0..maxAlumnos - 1 -> almacenIndex = alumnos.indexOfFirst { it?.id == idAlumno }
            !in 0..maxAlumnos - 1 -> almacenIndex = -1
        }
        return if (almacenIndex.equals(-1)) {
            false
        } else {
            alumnos[almacenIndex] = null
            true
        }

    }

    //SOLO PARA TESTEO
    fun imprimirListaAlumnos() {
        alumnosOrdenados = alumnos
        alumnosOrdenados.sortWith(nullsLast(compareBy { it.id }))

        println("--------------------------------")
        println("LISTA ALUMNOS")
        println("--------------------------------")
        alumnosOrdenados.forEach { println("${it?.nombre} ${it?.ap1} || Identificador: ${it?.id}") }
        println("--------------------------------")
        println("")
    }

    fun establecerNotaV1() {
        for (i in 0..maxAlumnos-1){
            evaluaciones[0][i] = (0..10).random().toDouble().toString()
            evaluaciones[1][i] = (0..10).random().toDouble().toString()
            evaluaciones[2][i] = (0..10).random().toDouble().toString()
            evaluaciones[3][i] = (0..10).random().toDouble().toString()
        }
    }

    fun listaNotasV1(evaluacion: Int) {
        if (evaluacion in 0..3) {
            println("--------------------------------")
            println("LISTA NOTAS DE LA EVALUACION ${evaluacion + 1}")
            println("--------------------------------")
            for (i in 0..maxAlumnos-1){
                print("|${i + 1}: ${evaluaciones[0][i]}|")
            }
            println("")
            println("--------------------------------")
            println("")
        } else {
            println("Evaluacion no valida")
        }
    }
}

fun main() {
    var alumno1 = Alumno("Juen", "Carglas", "Lunas", "1")
    var alumno2 = Alumno("Pablo", "Carglas", "Lunas", "3")
    var alumno3 = Alumno("Pedro", "Carglas", "Lunas", "2")

    var moduloPROG = Modulo(20)

    moduloPROG.matricularAlumno(alumno1)
    moduloPROG.matricularAlumno(alumno2)
    moduloPROG.matricularAlumno(alumno3)

    moduloPROG.imprimirListaAlumnos()

    moduloPROG.establecerNotaV1()

    moduloPROG.listaNotasV1(1)

}