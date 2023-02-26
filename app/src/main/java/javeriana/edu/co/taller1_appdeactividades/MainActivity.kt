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
            Log.i("Inicializar botones", "Ir a guessingNumbers")
            guessingNumbers()
        }

        // Factorial
        bindingMain.factorialButton.setOnClickListener{
            Log.i("Inicializar botones", "Ir a Factorial")
            factorial()
        }

        bindingMain.fibonacciButton.setOnClickListener{
            Log.i("Inicializar botones", "Ir a Fibonacci")
            fibonacci()
        }


        // Inicializar Spinner
        adapterLanguages = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item)
        adapterLanguages.addAll(listOf("Español", "Inglés", "Francés", "Alemán", "Portugués", "Italiano", "Toki pona", "Japonés", "Ruso", "Esperanto"))

        bindingMain.spinnerRandomGreet.onItemSelectedListener = this
        bindingMain.spinnerRandomGreet.adapter = adapterLanguages



        bindingMain.countriesButton.setOnClickListener{
            Log.i("Inicializar botones", "Ir a countries")
            countries()
        }
    }



    private fun guessingNumbers()
    {
        Log.i("Guessing Numbers", "Entrada")

        var numeroIngresado = bindingMain.numeroAdivinadoText.text.toString().toInt()

        //Log.i("Guessing Numbers", "Imprimir numero " + numeroIngresado)
        Log.i("Guessing Numbers", "Imprimir numero $numeroIngresado")

        // Verificar que el numero ingresado sea correcto
        if (numeroIngresado in 0..1000)
        {
            Log.i("Guessing Numbers", "Entrada al if")
            val pasarAGuessingGame = Intent(this, GuessGame::class.java)
            Log.i("Guessing Numbers", "Flag 1")
            pasarAGuessingGame.putExtra("numeroSugerido", numeroIngresado )
            Log.i("Guessing Numbers", "Flag 2")
            //startActivity(Intent(this, GuessGame::class.java))

            startActivity(pasarAGuessingGame)
        }
        else
        {
            Toast.makeText(baseContext, "Solo números entre el 0 y el 1000", Toast.LENGTH_LONG).show()
        }

    }


    private fun factorial()
    {
        Log.i("Factorial", "Entrada")

        // TODO: Ir a la siguiente actividad (FactorialActivity)
    }


    private fun fibonacci()
    {
        Log.i("Fibonacci", "Entrada")

        // TODO: Ir a la siguiente actividad (FibonacciActivity)
    }


    private fun countries()
    {
        Log.i("Countries", "Entrada")

        // TODO: Pasar a la siguiente actividad (CountriesActivity)
    }


    //Para seleccionar del Spinner
    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        var idiomaSeleccionado = adapterLanguages.getItem(position)
        Log.i("Random Greet", "Seleccion inicial: $idiomaSeleccionado")

        bindingMain.randomGreetButton.setOnClickListener{

            //var idiomaSeleccionado = onItemSelected(p2 = Int)
            Log.i("Random Greet", "El idioma es: $idiomaSeleccionado")
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}