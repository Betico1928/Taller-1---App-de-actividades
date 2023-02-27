package javeriana.edu.co.taller1_appdeactividades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import javeriana.edu.co.taller1_appdeactividades.databinding.ActivityRandomGreetBinding

class RandomGreetActivity : AppCompatActivity()
{
    private lateinit var bindingRandomGreet : ActivityRandomGreetBinding


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        bindingRandomGreet = ActivityRandomGreetBinding.inflate(layoutInflater)
        setContentView(bindingRandomGreet.root)

        // Recibir idioma
        var idiomaSeleccionado = intent.getStringExtra("idiomaSeleccionado")
        Log.i("Random Greet", "Idioma seleccionado: $idiomaSeleccionado")

        // Imprimir idioma
        if (idiomaSeleccionado != null)
        {
            imprimirIdioma(idiomaSeleccionado)
        }
    }

    // Imprimir idioma
    fun imprimirIdioma(idiomaSeleccionado: String)
    {
        // Hacer un "switch"
        when (idiomaSeleccionado)
        {
            "Español"    -> bindingRandomGreet.idiomaSeleccionado.text = "Hola!"
            "Inglés"     -> bindingRandomGreet.idiomaSeleccionado.text = "Hello!"
            "Francés"    -> bindingRandomGreet.idiomaSeleccionado.text = "Bonjour!"
            "Alemán"     -> bindingRandomGreet.idiomaSeleccionado.text = "Guten Morgen!"
            "Portugués"  -> bindingRandomGreet.idiomaSeleccionado.text = "Olá!"
            "Italiano"   -> bindingRandomGreet.idiomaSeleccionado.text = "Buongiorno!"
            "Toki pona"  -> bindingRandomGreet.idiomaSeleccionado.text = "Kama Pona!"
            "Japonés"    -> bindingRandomGreet.idiomaSeleccionado.text = "おはよう!"
            "Ruso"       -> bindingRandomGreet.idiomaSeleccionado.text = "Доброе утро!"
            "Esperanto"  -> bindingRandomGreet.idiomaSeleccionado.text = "Bonan matenon!"
        }
    }
}