import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.maintapp.R
import android.widget.Spinner
import com.example.maintapp.MainActivity



class ViewLogin : Fragment() {

    private lateinit var rangoSeleccion: Spinner
    private lateinit var btnLogin: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.login_view, container, false)

        // Configura el Spinner con opciones
        rangoSeleccion = view.findViewById(R.id.rangoSeleccion)
        val options = arrayOf("Usuario", "Operario")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, options)
        rangoSeleccion.adapter = adapter

        // Agrega un listener al Spinner para manejar la selección
        rangoSeleccion.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Manejar la selección del Spinner
                val selectedOption = options[position]
                Toast.makeText(requireContext(), "Seleccionaste: $selectedOption", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Puedes dejar esto vacío si no necesitas manejar la opción de "nada seleccionado"
            }
        }

        // Agrega un listener al botón de login
        btnLogin = view.findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener {
            val selectedOption = rangoSeleccion.selectedItem.toString()

            when (selectedOption) {
                "Usuario" -> {
                    Toast.makeText(requireContext(), "Abrir ventana 1", Toast.LENGTH_SHORT).show()
                    (activity as? MainActivity)?.abrirVentanaUsuario()
                }
                "Operario" -> {
                    Toast.makeText(requireContext(), "Abrir ventana 2", Toast.LENGTH_SHORT).show()
                    (activity as? MainActivity)?.abrirVentanaOperario()
                }
            }
        }

        return view
    }
}
