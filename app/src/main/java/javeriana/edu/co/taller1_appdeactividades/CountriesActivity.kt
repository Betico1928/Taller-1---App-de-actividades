package javeriana.edu.co.taller1_appdeactividades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import javeriana.edu.co.taller1_appdeactividades.databinding.ActivityCountriesBinding
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset

class CountriesActivity : AppCompatActivity() {
    private lateinit var binding : ActivityCountriesBinding
    private lateinit var arregloPais : ArrayList<Country>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountriesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        cargarArregloTipoCountry()
        val adapter = ArrayAdapter<Country>(this, android.R.layout.simple_list_item_1, arregloPais)
        binding.listaDePaises.adapter=adapter
    }

    fun loadCountries() : String{
        var json : String
        var istr : InputStream = this.assets.open("paises.json")
        val size = istr.available()
        val byteArray = ByteArray(size)
        istr.read(byteArray)
        istr.close()
        json = String(byteArray, Charset.defaultCharset())
        return json
    }

    fun cargarArregloTipoCountry(){
        arregloPais = ArrayList<Country>()
        val jsonObject = JSONObject(loadCountries())
        var arrayCountries = jsonObject.getJSONArray("paises")
        for (i in 0 until arrayCountries.length()){
            val countryObject = arrayCountries.getJSONObject(i)
            val name = countryObject.getString("nombre_pais")
            val capital = countryObject.getString("capital")
            val intName = countryObject.getString("nombre_pais_int")
            val sigla = countryObject.getString("sigla")
            val country = Country(name, capital, intName, sigla)
            arregloPais.add(country)
        }
    }
}

class Country(
    val name: String,
    val capital: String,
    val intName: String,
    val sigla: String
) {
    override fun toString(): String {
        return "$name ($sigla)"
    }
}


































/*

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_countries)

        read_json()
        llenarLaLista()
    }

    fun read_json()
    {
        var json : String? = null

        try
        {
            // Para abrir el archivo
            val inputStream: InputStream = assets.open("paises.json")
            json = inputStream.bufferedReader().use { it.readText() }


        }
        catch (e : IOException)
        {

        }

    }

    fun llenarLaLista()
    {




        // Trabajar en los elementos dentro del list view (el asterisco es diciendo que el Array va
        // a tener datos de cualquier tipo)
        val arrayAdapter: ArrayAdapter<*>

        val paises = mutableListOf("Alemania" , "Argentina, Australia, Austria, Bélgica, Bolívia, Brasil, Chile, Colombia, Cuba, Ecuador, España, Estados Unidos, Francia, Reino Unido, Grecia, Holanda, Hungria, Irlanda, Islandia, Israel, Italia, Japón, Uruguay, Venezuela")

        // Lo que se va a llenar con los datos
        val listaPaises = findViewById<ListView>(R.id.listaPaises)

        // Llenar
        arrayAdapter = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, paises)

        listaPaises.adapter = arrayAdapter

        // Para cuando le den click
        listaPaises.setOnItemClickListener { adapterView, view, position, id ->
            // Poner lo que sea que quiera poner (ej:)
            //Toast.makeText(applicationContext, parent.getText(position).toString(), Toast.LENGTH_LONG).show()
        }

    }

*/


