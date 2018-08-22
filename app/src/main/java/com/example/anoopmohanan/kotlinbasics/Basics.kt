package com.example.anoopmohanan.kotlinbasics

class SimpleSpice {
    var spiceName: String? = null
    var spiciness: String? = null
    var heat: Double = 0.0
        get() {
            return when (spiciness) {
                "mild" -> 5.0
                else -> 0.0
            }
        }

}


