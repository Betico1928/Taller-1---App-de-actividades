package javeriana.edu.co.taller1_appdeactividades

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import javeriana.edu.co.taller1_appdeactividades.databinding.ActivityMostrarPaisBinding

class MostrarPaisActivity : AppCompatActivity()
{
    private lateinit var bindingMostrarPais: ActivityMostrarPaisBinding


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        bindingMostrarPais = ActivityMostrarPaisBinding.inflate(layoutInflater)
        setContentView(bindingMostrarPais.root)
    }
}