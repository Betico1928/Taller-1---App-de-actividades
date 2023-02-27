package javeriana.edu.co.taller1_appdeactividades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import javeriana.edu.co.taller1_appdeactividades.databinding.ActivityMainBinding
import javeriana.edu.co.taller1_appdeactividades.databinding.ActivityMostrarPaisBinding

class mostrarPaisActivity : AppCompatActivity()
{
    private lateinit var bindingmostrarPais: ActivityMostrarPaisBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        bindingmostrarPais = ActivityMostrarPaisBinding.inflate(layoutInflater)
        setContentView(bindingmostrarPais.root)

        var paisSeleccionado = intent.getSerializableExtra("paisSeleccionado")

        bindingmostrarPais.nombrePais.text = paisSeleccionado
    }
}