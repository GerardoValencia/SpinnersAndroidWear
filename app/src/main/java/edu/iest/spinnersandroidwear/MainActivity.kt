package edu.iest.spinnersandroidwear

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import edu.iest.spinnersandroidwear.databinding.ActivityMainBinding

class MainActivity : Activity() {

    private lateinit var binding: ActivityMainBinding
    private var numSeleccionado: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvSaludo.text = "Elige un numero"
        binding.bnComparar.text = "Comparar"

        val adaptador = ArrayAdapter.createFromResource(this, R.array.Opciones, android.R.layout.simple_spinner_item)
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spOp1.adapter = adaptador
        binding.spOp2.adapter = adaptador
        binding.spOp1.onItemSelectedListener = this
        binding.spOp2.onItemSelectedListener = this

        binding.bnComparar.setOnClickListener {
            val resultado = AlertDialog.Builder(this)
            resultado.setTitle("Mayor")
                .setMessage("El número mayor es $")
                .setPositiveButton("OK",
                DialogInterface.OnClickListener{ dialogInterface, i ->
                    binding.tvSaludo.text = numSeleccionado.toString()
                }).show()
        }

    }

    override fun onItemSelected(vistaPadre: AdapterView<*>?, vistaRow: View?, posicion: Int, idVista: Long) {
        numSeleccionado =
            vistaPadre?.getItemAtPosition(posicion).toString()
        Toast.makeText(this, "El numero mayor es $numSeleccionado", Toast.LENGTH_LONG).show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}