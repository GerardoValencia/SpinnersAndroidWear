package edu.iest.spinnersandroidwear

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import edu.iest.spinnersandroidwear.databinding.ActivityMainBinding

class MainActivity : Activity() {

    private lateinit var binding: ActivityMainBinding
    private var numSeleccionado: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner1: Spinner = findViewById(R.id.sp1)
        val spinner2: Spinner = findViewById(R.id.sp2)

        // Crear un ArrayAdapter usando un array de valores del 1 al 10
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.Opciones,
            android.R.layout.simple_spinner_item
        )

        // Especificar el layout que se usará para mostrar los valores en el Spinner
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Asignar el ArrayAdapter a los Spinners
        spinner1.adapter = adapter
        spinner2.adapter = adapter

        val bnComparar: Button = findViewById(R.id.bnComparar)
        bnComparar.setOnClickListener {
            val value1 = spinner1.selectedItem.toString().toInt()
            val value2 = spinner2.selectedItem.toString().toInt()

            val maxSpinner = if (value1 > value2) "Spinner 1" else "Spinner 2"

            // Mostrar una alerta con el Spinner que contiene el valor máximo
            AlertDialog.Builder(this)
                .setTitle("Valor Máximo")
                .setMessage("El valor máximo se encuentra en $maxSpinner.")
                .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
                .create()
                .show()
        }

    }
}
