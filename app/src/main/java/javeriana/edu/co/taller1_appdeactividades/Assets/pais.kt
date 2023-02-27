package javeriana.edu.co.taller1_appdeactividades.Assets

import android.os.Parcel
import android.os.Parcelable

@Parcelize
data class Pais(val nombre: String?, val capital: String?, val nombrePaisInt: String?, val sigla: String?):
    Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(capital)
        parcel.writeString(nombrePaisInt)
        parcel.writeString(sigla)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pais> {
        override fun createFromParcel(parcel: Parcel): Pais {
            return Pais(parcel)
        }

        override fun newArray(size: Int): Array<Pais?> {
            return arrayOfNulls(size)
        }
    }
}

annotation class Parcelize
/*
data class pais(
    val capital: String,
    val nombrePais: String,
    val nombrePaisInt: String,
    val sigla: String
) {
    override fun toString(): String {
        return nombrePais
    }
}

 */