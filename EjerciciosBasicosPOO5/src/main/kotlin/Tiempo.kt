class Tiempo(hora: Int) {
    var hora: Int = hora
        set(value) {
            requireHora()
            field = value
        }

    var minuto: Int = 0
        set(value) {
            require(value in 0..59) {"Los minutos no pueden ser mas de 59."}
            field = value
        }

    var segundo: Int = 0
        set(value) {
            require(value in 0..59) {"Los segundos no pueden ser mas de 59."}
            field = value
        }

    init {
        requireHora()
        require(minuto > 0) {"Los minutos no pueden ser negativos"}
        require(segundo > 0) {"Los segundos no pueden ser negativos"}

        if (this.segundo > 59) {
            this.minuto += this.segundo / 60
            this.segundo %= 60
        }

        if (this.minuto > 59) {
            this.hora += this.minuto / 60
            this.minuto %= 60
        }

    }



    constructor(hora: Int, minuto: Int) : this(hora){
        this.hora = hora
        this.minuto = minuto
        this.segundo = 0
    }

    constructor(hora: Int, minuto: Int, segundo: Int) : this(hora){
        this.hora = hora
        this.minuto = minuto
        this.segundo = segundo
    }

    private fun requireHora() {
        require(hora in 0..23) {"La hora no puede ser mayor que 23."}
    }

    override fun toString(): String {
        return "${"%02d".format(this.hora)}h ${"%02d".format(this.minuto)}m ${"%02d".format(this.segundo)}s"
    }

    fun incrementar(t: Tiempo): Boolean {
        this.hora += t.hora
        this.minuto += t.minuto
        this.segundo += t.segundo

        if (this.segundo > 59) {
            this.minuto += this.segundo / 60
            this.segundo %= 60
        }

        if (this.minuto > 59) {
            this.hora += this.minuto / 60
            this.minuto %= 60
        }

        if (this.hora > 23) {
            return false
        }

        return true
    }

    fun decrementar(t: Tiempo): Boolean {
        this.hora -= t.hora
        this.minuto -= t.minuto
        this.segundo -= t.segundo

        if (this.segundo > 59) {
            this.minuto += this.segundo / 60
            this.segundo %= 60
        }

        if (this.minuto > 59) {
            this.hora += this.minuto / 60
            this.minuto %= 60
        }

        if (this.hora > 23) {
            return false
        }

        return true
    }


}