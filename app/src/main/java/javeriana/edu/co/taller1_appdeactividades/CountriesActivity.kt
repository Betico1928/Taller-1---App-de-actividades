package javeriana.edu.co.taller1_appdeactividades

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import javeriana.edu.co.taller1_appdeactividades.databinding.ActivityCountriesBinding
import org.json.JSONObject
import java.io.InputStream
import java.nio.charset.Charset

class CountriesActivity : AppCompatActivity() {

    private lateinit var bindingCountries: ActivityCountriesBinding
    private lateinit var countryList: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingCountries = ActivityCountriesBinding.inflate(layoutInflater)
        setContentView(bindingCountries.root)
        loadCountryList()
        val adaptadorDePaises = ArrayAdapter(this, android.R.layout.simple_list_item_1, countryList)
        bindingCountries.listaDePaises.adapter = adaptadorDePaises
    }

    private fun loadCountryList()
    {
        countryList = ArrayList<String>()
        val jsonObject = JSONObject(loadCountriesFromAssets())
        val countriesArray = jsonObject.getJSONArray("paises")
        for (i in 0 until countriesArray.length()) {
            val country = countriesArray.getJSONObject(i)
            val countryName = country.get("nombre_pais").toString()
            countryList.add(countryName)
        }
    }

    private fun loadCountriesFromAssets(): String {
        var json = ""
        try {
            val inputStream: InputStream = assets.open("paises.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, Charset.defaultCharset())
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        return json
    }
}




































/*
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

        binding.listaDePaises.setOnItemClickListener { p1, p2, p3, p4 ->


            /*
            val paisSeleccionado = arregloPais[p3]

            val pasarAMostrarPaisActivity = Intent(this, mostrarPaisActivity::class.java)
            Log.i("ContriesActivity", "Flag 1")
            pasarAMostrarPaisActivity.putExtra("paisSeleccionado", paisSeleccionado )
            Log.i("ContriesActivity", "Flag 2")

             */
        }
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

 */


































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


