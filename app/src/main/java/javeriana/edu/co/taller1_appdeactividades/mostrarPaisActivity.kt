package javeriana.edu.co.taller1_appdeactividades

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import javeriana.edu.co.taller1_appdeactividades.databinding.ActivityMostrarPaisBinding

class mostrarPaisActivity : AppCompatActivity()
{
    private lateinit var bindingmostrarPais: ActivityMostrarPaisBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        bindingmostrarPais = ActivityMostrarPaisBinding.inflate(layoutInflater)
        setContentView(bindingmostrarPais.root)

        // Obtener los datos que fueron pasados como extras
        //val pais = intent.getParcelableExtra<pais>("pais")

// Utilizar los valores de la instancia de Pais para mostrarlos en la interfaz
        //capitalTextView.text = pais.capital
        //nombrePaisTextView.text = pais.nombrePais
        //nombrePaisintTextView.text = pais.nombrePaisint
        //siglaTextView.text = pais.sigla
        /*
        var paisSeleccionado = intent.getSerializableExtra("paisSeleccionado")

        //bindingmostrarPais.nombrePais.text = paisSeleccionado

         */
    }
}