package javeriana.edu.co.taller1_appdeactividades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import javeriana.edu.co.taller1_appdeactividades.databinding.ActivityRandomGreetBinding

class RandomGreet : AppCompatActivity()
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
        bindingRandomGreet.idiomaSeleccionado.text = idiomaSeleccionado
    }
}