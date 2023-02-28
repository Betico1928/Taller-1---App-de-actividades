package javeriana.edu.co.taller1_appdeactividades

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonParser
import com.google.gson.reflect.TypeToken
import com.squareup.picasso.Picasso
import javeriana.edu.co.taller1_appdeactividades.databinding.ActivityMostrarPaisBinding
import org.json.JSONObject
import java.io.*

data class Pais(
    val capital: String,
    val nombre_pais: String,
    val nombre_pais_int: String,
    val sigla: String
)


class MostrarPaisActivity : AppCompatActivity()
{
    private lateinit var bindingMostrarPais: ActivityMostrarPaisBinding

    fun copyJsonToInternalStorage(context: Context, fileName: String) {
        val inputStream = context.assets.open(fileName)
        val outputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE)
        inputStream.copyTo(outputStream)
        inputStream.close()
        outputStream.close()
    }

    fun buscarPaisPorNombre(context: Context, nombrePais: String): JSONObject? {
        val fileName = "paises.json"
        copyJsonToInternalStorage(context, fileName)

        val fileInputStream = context.openFileInput(fileName)
        val bufferedReader = BufferedReader(InputStreamReader(fileInputStream))
        val jsonString = bufferedReader.readText()

        val jsonObject = JSONObject(jsonString)
        val paises = jsonObject.getJSONArray("paises")

        for (i in 0 until paises.length()) {
            val pais = paises.getJSONObject(i)
            if (pais.getString("nombre_pais") == nombrePais) {
                return pais
            }
        }

        return null
    }
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        bindingMostrarPais = ActivityMostrarPaisBinding.inflate(layoutInflater)
        setContentView(bindingMostrarPais.root)

        // Recibir pais seleccionado
        var nombrePais = intent.getStringExtra("paisSeleccionado")
        Log.i("Mostrar Pais", "Pais Recibido: $nombrePais")

        val pais = nombrePais?.let { buscarPaisPorNombre(this, it) }

        if (pais != null) {
            val capital = pais.getString("capital")
            val nombrePais = pais.getString("nombre_pais")
            val nombrePaisInt = pais.getString("nombre_pais_int")
            val sigla = pais.getString("sigla")

            mostrarDatos(capital, nombrePais, nombrePaisInt, sigla)

        } else {
            Log.i("MostrarPaisActivity", "Pais no encontrado")
            Toast.makeText(this, "País no encontrado", Toast.LENGTH_SHORT).show()
        }
    }

    fun mostrarDatos(capital: String, nombrePais: String, nombrePaisInt: String, sigla: String)
    {
        bindingMostrarPais.capital.text = capital
        bindingMostrarPais.nombrePais.text = nombrePais
        bindingMostrarPais.nombrePaisInt.text = nombrePaisInt
        bindingMostrarPais.sigla.text = sigla

        // Mostrar bandera utilizando la libreria Picasso
        mostrarBandera(sigla)
    }

    fun mostrarBandera(siglaPais: String) {
        //val url = " "https://countryflagsapi.com/png/"$siglaPais""
        Picasso.get().load("https://countryflagsapi.com/png/"+siglaPais).into(bindingMostrarPais.imageViewBandera)
    }















    /*
    private lateinit var bindingMostrarPais: ActivityMostrarPaisBinding


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        bindingMostrarPais = ActivityMostrarPaisBinding.inflate(layoutInflater)
        setContentView(bindingMostrarPais.root)

        // Recibir pais seleccionado
        var nombrePais = intent.getStringExtra("paisSeleccionado")
        Log.i("Mostrar Pais", "Pais Recibido: $nombrePais")

        bindingMostrarPais.nombrePais.text = nombrePais

        var nombrePaisString : String = nombrePais.toString()


        val pais = buscarPais("Alemania")
        if (pais != null) {
            with(bindingMostrarPais) {
                tvCapital.text = pais.capital
                tvNombrePais.text = pais.nombre_pais
                tvNombrePaisInt.text = pais.nombre_pais_int
                tvSigla.text = pais.sigla
            }
        }

    }

    fun buscarPais(context: Context, nombrePais: String): Pais? {
        val json = obtenerJsonDesdeArchivo(context, "paises.json")
        val gson = Gson()
        val listaPaises = gson.fromJson(json, Array<Pais>::class.java)

        for (pais in listaPaises) {
            if (pais.nombre_pais == nombrePais) {
                return pais
            }
        }

        return null
    }


    /*
        val paisBuscado = buscarPais("Argentina")
        if (paisBuscado != null) {
            println("Capital: ${paisBuscado.capital}")
            println("Nombre del país: ${paisBuscado.nombre_pais}")
            println("Nombre del país en inglés: ${paisBuscado.nombre_pais_int}")
            println("Sigla: ${paisBuscado.sigla}")
        } else {
            println("El país buscado no se encuentra en la lista")
        }



    fun obtenerDetallesDelPais(nombrePais: String, context: Context): Pais? {
        val gson = Gson()
        val inputStream: InputStream = context.assets.open("paises.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val paisesJson = gson.fromJson(String(buffer), Paises::class.java)
        return paisesJson.paises.find { it.nombre_pais == nombrePais }
    }

     */


    /*
    fun buscarEnElJSON(paisSeleccionado : String)
    {
        val pais = buscarPais(this, paisSeleccionado)

        if (pais != null) {
            println("Capital: ${pais.capital}")
            println("Nombre del país: ${pais.nombre_pais}")
            println("Nombre internacional: ${pais.nombre_pais_int}")
            println("Sigla: ${pais.sigla}")
        } else {
            println("El país no se encuentra en la lista.")
        }
    }

    private fun buscarPais(context: MostrarPaisActivity, nombrePais: String): Pais? {
        val gson = Gson()
        val inputStream = context.assets.open("paises.json")
        val reader = InputStreamReader(inputStream)
        val paises = gson.fromJson(reader, Array<Pais>::class.java)

        return paises.find { it.nombre_pais == nombrePais }
    }

     */
}

     */
}