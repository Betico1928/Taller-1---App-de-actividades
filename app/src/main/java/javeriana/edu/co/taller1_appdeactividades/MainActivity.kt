package javeriana.edu.co.taller1_appdeactividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import javeriana.edu.co.taller1_appdeactividades.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var bindingMain : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        bindingMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingMain.root)

        inicializarBotones()
    }

    fun inicializarBotones()
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

        bindingMain.randomGreetButton.setOnClickListener{
            Log.i("Inicializar botones", "Ir a random Greet")
            randomGreet()
        }

        bindingMain.countriesButton.setOnClickListener{
            Log.i("Inicializar botones", "Ir a countries")
            countries()
        }
    }



    fun guessingNumbers()
    {
        Log.i("Guessing Numbers", "Entrada")

        var numeroIngresado = bindingMain.numeroAdivinadoText.text.toString().toInt()

        //Log.i("Guessing Numbers", "Imprimir numero " + numeroIngresado)
        Log.i("Guessing Numbers", "Imprimir numero $numeroIngresado")

        // Verificar que el numero ingresado sea correcto
        if (numeroIngresado in 0..1000)
        {
            val pasarAGuessingGame = Intent(this, GuessGame::class.java)
            pasarAGuessingGame.putExtra("numeroSugerido", numeroIngresado )
            //startActivity(Intent(this, GuessGame::class.java))
        }
        else
        {
            Toast.makeText(baseContext, "Solo números entre el 0 y el 1000", Toast.LENGTH_LONG).show()
        }
    }


    fun factorial()
    {
        Log.i("Factorial", "Entrada")

        // TODO: Ir a la siguiente actividad (FactorialActivity)
    }


    fun fibonacci()
    {
        Log.i("Fibonacci", "Entrada")

        // TODO: Ir a la siguiente actividad (FibonacciActivity)
    }


    fun randomGreet()
    {
        Log.i("Random Greet", "Entrada")

        // TODO: Verificar el idioma seleccionado en el spinner y pasar a la actividad (RandomGreet)
    }

    fun countries()
    {
        Log.i("Countries", "Entrada")

        // TODO: Pasar a la siguiente actividad (CountriesActivity)
    }
}