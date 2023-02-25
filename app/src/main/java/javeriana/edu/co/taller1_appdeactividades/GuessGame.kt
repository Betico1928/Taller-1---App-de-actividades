package javeriana.edu.co.taller1_appdeactividades

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import javeriana.edu.co.taller1_appdeactividades.databinding.ActivityGuessGameBinding
import java.util.*

class GuessGame : AppCompatActivity()
{
    private lateinit var bindingGuessGame: ActivityGuessGameBinding

    // Creacion del random
    val random = Random()
    val numeroAleatorio = random.nextInt(1000)

    // Contador de intentos
    var attemptCounter = 1


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        bindingGuessGame = ActivityGuessGameBinding.inflate(layoutInflater)
        setContentView(bindingGuessGame.root)

        Log.i("GuessGame", "Numero aleatorio: $numeroAleatorio")

        // Recibir el numero del main
        var numeroRetornado: Int = recibirNumeroDelMain()
        Log.i("GuessGame", "Numero retornado: $numeroRetornado")


        seguirAdivinando(numeroRetornado)
        /*
        bindingGuessGame.playButton.setOnClickListener{
            Log.i("GuessGame", "Ir a play guessing numbers")

        }

         */
    }

    private fun recibirNumeroDelMain(): Int {
        var numeroSugerido = intent.getIntExtra("numeroSugerido", 0)

        Log.i("recibirNumeroDelMain", "Numero recibido " + numeroSugerido)
        Log.i("recibirNumeroDelMain", "Numero aleatorio generado " + numeroAleatorio)


        if (numeroSugerido != numeroAleatorio)
        {
            if (numeroSugerido > numeroAleatorio)
            {
                bindingGuessGame.gameStatus.text = "Fallaste, el numero debe ser menor!: "

                bindingGuessGame.attemptCounter.text = "Attempt Counter: " + attemptCounter
                return numeroSugerido
            }

            if (numeroSugerido < numeroAleatorio)
            {
                bindingGuessGame.gameStatus.text = "Fallaste, el numero debe ser mayor!: "

                bindingGuessGame.attemptCounter.text = "Attempt Counter: " + attemptCounter
                return numeroSugerido
            }
        }
        else
        {
            bindingGuessGame.gameStatus.text = "GANASTE! El numero era: " + numeroSugerido
            bindingGuessGame.attemptCounter.text = "Attempt Counter: " + attemptCounter
        }
        return -1
    }


    private fun seguirAdivinando(numeroRetornado: Int)
    {
        Log.i("seguirJugando", "Entrada")
        Log.i("seguirJugando", "Numero retornado: $numeroRetornado")


        // Logica general
        bindingGuessGame.playButton.setOnClickListener{

            var numeroAJugar = bindingGuessGame.suggestedNumber.text.toString().toInt()

            if (numeroAJugar < 0)
            {
                bindingGuessGame.gameStatus.text = "Tu numero es demasiado pequeño"
                Toast.makeText(baseContext, "Recuerda, el numero debe empieza en 0", Toast.LENGTH_LONG).show()
            }
            else if (numeroAJugar > 1000)
            {
                bindingGuessGame.gameStatus.text = ("Tu numero es demasiado grande")
                Toast.makeText(baseContext, "Recuerda, el numero debe terminar en 1000", Toast.LENGTH_LONG).show()
            }
            else if (numeroAJugar > numeroAleatorio && numeroAJugar <= 1000)
            {
                bindingGuessGame.gameStatus.text = ("Fallaste, el numero debe ser menor!")
                Log.i("Numero no adivinado (menor)", "Se pide numero menor, el numero fue $numeroAJugar y se necesita $numeroAleatorio")

                attemptCounter = attemptCounter + 1

                bindingGuessGame.attemptCounter.text = "Attempt Counter: " + attemptCounter
                Log.i("Intentos: ", "Numero de Intentos: $attemptCounter")
            }
            else if (numeroAJugar < numeroAleatorio && numeroAJugar >= 0)
            {
                bindingGuessGame.gameStatus.text = ("Fallaste, el numero debe ser mayor!")
                Log.i("Numero no adivinado (mayor)", "Se pide numero mayor, el numero fue $numeroAJugar y se necesita $numeroAleatorio")

                attemptCounter = attemptCounter + 1

                bindingGuessGame.attemptCounter.text = "Attempt Counter: " + attemptCounter
                Log.i("Intentos: ", "Numero de Intentos: $attemptCounter")
            }
            else
            {
                bindingGuessGame.gameStatus.text = ("GANASTE! El numero era $numeroAleatorio")
                bindingGuessGame.attemptCounter.text = ("Numero de Intentos: $attemptCounter")

                Log.i("Estado del juego: ", "Finalizado :D")
            }
        }
    }


}