package br.edu.infnet.calculoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import br.edu.infnet.calculoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //-------------------------------------------//

        binding.buttonCalculate.setOnClickListener(this)
        binding.buttonClear.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if(view.id == R.id.button_calculate) {
            calculate()
        }
        if(view.id == R.id.button_clear) {
            clears()
        }
    }

    private fun valid(): Boolean {
        return (binding.editDistance.text.toString() != ""
                && binding.editAutonomy.text.toString() != ""
                && binding.editPrice.text.toString() != ""
                && binding.editDistance.text.toString().toFloat() != 0f
                && binding.editAutonomy.text.toString().toFloat() != 0f
                && binding.editPrice.text.toString().toFloat() != 0f)
    }

    private fun calculate() {
        if(valid()) {
            val distance = binding.editDistance.text.toString().toFloat()
            val autonomy = binding.editAutonomy.text.toString().toFloat()
            val price = binding.editPrice.text.toString().toFloat()

            val total = (distance * price) / autonomy

            val totalString = "R$ ${"%.2f".format(total)}"

            binding.textValueTotal.text = totalString

        } else {
            Toast.makeText(this, R.string.Fill_in_the_empty_fields, Toast.LENGTH_LONG).show()
        }
    }

    private fun clears() {
        binding.editDistance.text.clear()
        binding.editAutonomy.text.clear()
        binding.editPrice.text.clear()
        binding.textValueTotal.text = "R$ 0"
    }

}