package com.example.recyclerviewexample.model

class Item {
    var campo1: String = ""
    var campo2: String = ""
    var campo3: String = ""
    var campo4: String = ""
    var campo5: String = ""
    var bandera: String = ""

    constructor(linea: String) {
        var campos = linea.split('#')
        this.campo1 = campos.get(0)
        this.campo2 = campos.get(1)
        this.campo3 = campos.get(2)
        this.campo4 = campos.get(3)
        this.campo5 = campos.get(4)
        this.bandera = campos.get(5)
    }
}