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
        require(minuto >= 0) {"Los minutos no pueden ser negativos"}
        require(segundo >= 0) {"Los segundos no pueden ser negativos"}

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

    fun comparar(t: Tiempo): Int {
        if (this.hora > t.hora) {
            return -1
        }
        else if (t.hora > this.hora) {
            return 1
        }
        else {
            if (this.minuto > t.minuto) {
                return -1
            }
            else if (t.minuto > this.minuto) {
                return 1
            }
            else {
                if (this.segundo > t.segundo) {
                    return -1
                }
                else if (t.segundo > this.segundo) {
                    return 1
                }
                else {
                    return 0
                }
            }
        }
    }

    fun copiar() {
        print("Introduce la hora: ")
        var h = readln().toInt()
        print("Introduce los minutos: ")
        var m = readln().toInt()
        print("Introduce los segundos: ")
        var s = readln().toInt()
        this.hora = h
        this.minuto = m
        this.segundo = s
    }

    fun copiar(t: Tiempo) {
        this.hora = t.hora
        this.minuto = t.minuto
        this.segundo = t.segundo
    }

    fun sumar(t: Tiempo): Tiempo? {
        t.hora += this.hora
        t.minuto += this.minuto
        t.segundo += this.segundo

        if (t.segundo > 59) {
            t.minuto += t.segundo / 60
            t.segundo %= 60
        }

        if (t.minuto > 59) {
            t.hora += t.minuto / 60
            t.minuto %= 60
        }

        if (t.hora > 23) {
            return null
        }

        return t
    }

    fun restar(t: Tiempo): Tiempo? {
        t.hora -= this.hora
        t.minuto -= this.minuto
        t.segundo -= this.segundo

        if (t.segundo < 0) {
            t.minuto -= t.segundo / 60
            t.segundo %= 60
        }

        if (t.minuto < 0) {
            t.hora -= t.minuto / 60
            t.minuto %= 60
        }

        if (t.hora < 0) {
            return null
        }

        return t
    }

    fun esMayorQue (t: Tiempo): Boolean {
        if (this.hora > t.hora) {
            return true
        }
        else if (t.hora > this.hora) {
            return false
        }
        else {
            if (this.minuto > t.minuto) {
                return true
            }
            else if (t.minuto > this.minuto) {
                return false
            }
            else {
                if (this.segundo > t.segundo) {
                    return true
                }
                else if (t.segundo > this.segundo) {
                    return false
                }
                else {
                    return false
                }
            }
        }
    }

    fun esMenorQue (t: Tiempo): Boolean {
        if (this.hora > t.hora) {
            return false
        }
        else if (t.hora > this.hora) {
            return true
        }
        else {
            if (this.minuto > t.minuto) {
                return false
            }
            else if (t.minuto > this.minuto) {
                return true
            }
            else {
                if (this.segundo > t.segundo) {
                    return false
                }
                else if (t.segundo > this.segundo) {
                    return true
                }
                else {
                    return false
                }
            }
        }
    }
}