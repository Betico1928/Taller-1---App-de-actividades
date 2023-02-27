package javeriana.edu.co.taller1_appdeactividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import javeriana.edu.co.taller1_appdeactividades.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener
{
    private lateinit var bindingMain : ActivityMainBinding

    // Adapter para el Spinner
    private lateinit var adapterLanguages : ArrayAdapter<String>

    // Variables para los counters de entradas
    private var guessGameCount = 0
    private var randomGreetCount = 0
    private var guessGameLastUse = ""
    private var randomGreetLastUse = ""


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        bindingMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingMain.root)

        inicializarElementos()
    }

    private fun inicializarElementos()
    {

        // Inicializar el contador y la hora/fecha de la última utilización
        guessGameCount = 0
        randomGreetCount = 0
        guessGameLastUse = ""
        randomGreetLastUse = ""

        var status = "Juego de adivinanza: $guessGameCount - Último uso: $guessGameLastUse\n" + "Saludos aleatorios: $randomGreetCount - Último uso: $randomGreetLastUse"

        bindingMain.statusText.text  = status



        // Guessing Number
        bindingMain.guessGameButton.setOnClickListener{
            Log.i("Main", "Ir a guessingNumbers")

            // Revisar los ingresos
            guessGameCount++
            guessGameLastUse = getCurrentTime()

            guessingNumbers()
        }


        // Inicializar Spinner
        adapterLanguages = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item)
        adapterLanguages.addAll(listOf("Español", "Inglés", "Francés", "Alemán", "Portugués", "Italiano", "Toki pona", "Japonés", "Ruso", "Esperanto"))

        bindingMain.spinnerRandomGreet.onItemSelectedListener = this
        bindingMain.spinnerRandomGreet.adapter = adapterLanguages


        // Countries
        bindingMain.countriesButton.setOnClickListener{
            Log.i("Main", "Ir a countries")
            countries()
        }
    }



    private fun guessingNumbers()
    {
        Log.i("Main", "Entrada - Guessing Numbers")

        val numeroIngresado = bindingMain.numeroAdivinadoText.text.toString().toInt()

        //Log.i("Guessing Numbers", "Imprimir numero " + numeroIngresado)
        Log.i("Main", "Imprimir numero ingresado para adivinar: $numeroIngresado")

        // Verificar que el numero ingresado sea correcto
        if (numeroIngresado in 0..1000)
        {
            Log.i("Guessing Numbers", "Entrada al if")
            val pasarAGuessingGame = Intent(this, GuessGame::class.java)
            Log.i("Main", "Flag 1 - Guessing Numbers")
            pasarAGuessingGame.putExtra("numeroSugerido", numeroIngresado )
            Log.i("Main", "Flag 2 - Guessing Numbers")
            //startActivity(Intent(this, GuessGame::class.java))

            startActivity(pasarAGuessingGame)
        }
        else
        {
            Toast.makeText(baseContext, "Solo números entre el 0 y el 1000", Toast.LENGTH_LONG).show()
        }

    }


    private fun countries()
    {
        Log.i("Main", "Entrada - Countries")

        // Pasar a la siguiente actividad
        val pasarACountries = Intent(this, CountriesActivity::class.java)
        startActivity(pasarACountries)
    }


    //Para seleccionar del Spinner
    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long)
    {
        val idiomaSeleccionado = adapterLanguages.getItem(position)

        Log.i("Random Greet", "Seleccion inicial: $idiomaSeleccionado")

        bindingMain.randomGreetButton.setOnClickListener{

            //var idiomaSeleccionado = onItemSelected(p2 = Int)
            Log.i("Random Greet", "El idioma es: $idiomaSeleccionado")

            // Revisar los ingresos
            randomGreetCount++
            randomGreetLastUse = getCurrentTime()

            // Pasarlo a la actividad random greet.
            val pasarARandomGret = Intent(this, RandomGreet::class.java)
            Log.i("Main", "Flag 1 - Random Greet")
            pasarARandomGret.putExtra("idiomaSeleccionado", idiomaSeleccionado )
            Log.i("Main", "Flag 2 - Random Greet")

            startActivity(pasarARandomGret)
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }





    private fun getCurrentTime(): String {
        // Obtener la hora y fecha actual en un formato legible
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val date = Date()
        return dateFormat.format(date)
    }

    override fun onResume() {
        super.onResume()

        // Mostrar el contador y la hora/fecha de la última utilización
        val countText = "Juego de adivinanza: $guessGameCount - Último uso: $guessGameLastUse\n" +
                "Saludos aleatorios: $randomGreetCount - Último uso: $randomGreetLastUse"

        bindingMain.statusText.text = countText
    }
}