package javeriana.edu.co.taller1_appdeactividades

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

        // Guessing Number
        bindingMain.guessGameButton.setOnClickListener{
            Log.i("onCreate", "Presionar boton")
            guessingNumbers()
        }

        //
    }

    fun guessingNumbers()
    {
        Log.i("Guessing Numbers", "Entrada")

        var numeroIngresado = bindingMain.numeroAdivinadoText.text
        Log.i("Guessing Numbers", "Imprimir numero" + numeroIngresado)

        // TODO: Ir a la siguiente actividad (GuessGame)
    }
}