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

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener
{
    private lateinit var bindingMain : ActivityMainBinding
    private lateinit var adapterLanguages : ArrayAdapter<String>


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        bindingMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingMain.root)

        inicializarElementos()
    }

    private fun inicializarElementos()
    {
        // Guessing Number
        bindingMain.guessGameButton.setOnClickListener{
            Log.i("Main", "Ir a guessingNumbers")
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

        TODO("Pasar a la siguiente actividad (CountriesActivity) con API")
    }


    //Para seleccionar del Spinner
    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long)
    {
        val idiomaSeleccionado = adapterLanguages.getItem(position)

        Log.i("Random Greet", "Seleccion inicial: $idiomaSeleccionado")

        bindingMain.randomGreetButton.setOnClickListener{

            //var idiomaSeleccionado = onItemSelected(p2 = Int)
            Log.i("Random Greet", "El idioma es: $idiomaSeleccionado")


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
}