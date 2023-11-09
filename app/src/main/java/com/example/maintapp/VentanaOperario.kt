import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.maintapp.R
import com.example.maintapp.TareaDetalleActivity
import com.example.maintapp.Task

class VentanaOperario : RecyclerView.Adapter<VentanaOperario.ViewHolder>() {
    private val taskList: List<Task> = getSampleTasks()

    private fun getColorForState(urgency: String, context: Context): Int {
        return when (urgency) {
            "Mantenimiento" -> ContextCompat.getColor(context, R.color.color_mantenimiento)
            "Incidencia" -> ContextCompat.getColor(context, R.color.color_incidencia)
            "Urgencia" -> ContextCompat.getColor(context, R.color.color_urgencia)
            else -> ContextCompat.getColor(context, R.color.color_predeterminado)
        }
    }

    private fun getSampleTasks(): List<Task> {
        val titles = arrayOf(
            "Mantenimiento programado",
            "Incidencia en ascensor",
            "Urgencia en puertas",
            "Mantenimiento de luces",
            "Reparación de caldera",
            "Incidencia en sistema de seguridad",
            "Revisión de tuberías de gas",
            "Cambio de cerraduras",
            "Instalación de cámaras de seguridad",
            "Limpieza de desagües",
            "Reparación de sistemas eléctricos",
            "Control de plagas en el jardín",
            "Revisión de tuberías de gas",
            "Cambio de cerraduras",
            "Instalación de cámaras de seguridad",
            "Limpieza de desagües",
            "Reparación de sistemas eléctricos",
            "Control de plagas en el jardín"
        )

        val details = arrayOf(
            "Mantenimiento programado de 2 ascensores.",
            "No funcionan las luces del ascensor.",
            "El ascensor abre las puertas en cualquier momento.",
            "Mantenimiento de luces en pasillo del edificio.",
            "Reparación de caldera en el sótano.",
            "Incidencia en el sistema de seguridad del edificio.",
            "Inspección de tuberías de gas en el edificio.",
            "Reemplazo de cerraduras en las puertas de acceso.",
            "Configuración de cámaras de seguridad en todo el perímetro.",
            "Eliminación de obstrucciones en los desagües de la cocina.",
            "Reparación de fallas en el sistema eléctrico del edificio.",
            "Control de plagas en el jardín y áreas comunes",
            "Inspección de tuberías de gas en el edificio.",
            "Reemplazo de cerraduras en las puertas de acceso.",
            "Configuración de cámaras de seguridad en todo el perímetro.",
            "Eliminación de obstrucciones en los desagües de la cocina.",
            "Reparación de fallas en el sistema eléctrico del edificio.",
            "Control de plagas en el jardín y áreas comunes."
        )

        val addresses = arrayOf(
            "Av. Libertador 2255",
            "Viamonte 933",
            "Av. Santa Fe 1399",
            "Av. San Martín 550",
            "Calle 123, Nº 456",
            "Av. Corrientes 2000",
            "Calle Principal 123",
            "Av. del Pueblo 456",
            "Calle de la Seguridad 789",
            "Av. de las Aguas 345",
            "Av. de la Electricidad 987",
            "Jardín Central 654",
            "Calle Principal 123",
            "Av. del Pueblo 456",
            "Calle de la Seguridad 789",
            "Av. de las Aguas 345",
            "Av. de la Electricidad 987",
            "Jardín Central 654"
        )

        val imageResources = arrayOf(
            android.R.drawable.ic_menu_manage,
            android.R.drawable.ic_lock_idle_low_battery,
            android.R.drawable.ic_popup_disk_full,
            android.R.drawable.ic_menu_send,
            android.R.drawable.ic_dialog_alert,
            android.R.drawable.ic_input_add,
            android.R.drawable.ic_popup_sync,
            android.R.drawable.ic_menu_zoom,
            android.R.drawable.ic_menu_save,
            android.R.drawable.ic_lock_idle_low_battery,
            android.R.drawable.ic_menu_mapmode,
            android.R.drawable.ic_lock_power_off,
            android.R.drawable.ic_dialog_map,
            android.R.drawable.ic_menu_view,
            android.R.drawable.ic_input_get,
            android.R.drawable.ic_menu_share,
            android.R.drawable.ic_btn_speak_now,
            android.R.drawable.ic_notification_overlay
            )

        val urgencies = arrayOf(
            "Mantenimiento",
            "Incidencia",
            "Urgencia",
            "Mantenimiento",
            "Mantenimiento",
            "Incidencia",
            "Mantenimiento",
            "Urgencia",
            "Mantenimiento",
            "Incidencia",
            "Urgencia",
            "Mantenimiento",
            "Urgencia",
            "Mantenimiento",
            "Incidencia",
            "Urgencia",
            "Mantenimiento",
            "Mantenimiento"
        )

        val sampleTasks = mutableListOf<Task>()
        for (i in titles.indices) {
            sampleTasks.add(Task(titles[i], details[i], addresses[i], imageResources[i], urgencies[i]))
        }
        return sampleTasks
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.ventana_operario_0, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val task = taskList[position]
        viewHolder.itemTitle.text = task.title
        viewHolder.itemDetail.text = task.details
        viewHolder.itemAdress.text = task.address
        viewHolder.itemImage.setImageResource(task.imageResource)

        val stateColorHex = getColorForState(task.urgency, viewHolder.itemView.context)
        //viewHolder.itemView.setBackgroundColor(stateColorHex)
        val cardView = viewHolder.itemView.findViewById<CardView>(R.id.Backgroundcard)
        //val cardView = findViewById<CardView>(R.id.cardViewTitleDescription)
        //cardView.setBackgroundColor(stateColorHex)
        cardView.setCardBackgroundColor(stateColorHex)


        val colorDecimal = getColorForState(task.urgency, viewHolder.itemView.context) // Obtén el color en formato decimal
        val colorHex = String.format("#%06X", 0xFFFFFF and colorDecimal) // Convierte a formato hexadecimal



        viewHolder.itemView.setOnClickListener {

            val intent = Intent(viewHolder.itemView.context, TareaDetalleActivity::class.java)
            intent.putExtra("tituloTarea", task.title)
            intent.putExtra("descripcionTarea", task.details)
            intent.putExtra("colordetarea", colorHex)

            viewHolder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView = itemView.findViewById(R.id.imageTaskId)
        var itemTitle: TextView = itemView.findViewById(R.id.titleTextView)
        var itemAdress: TextView = itemView.findViewById(R.id.addressTextView)
        var itemDetail: TextView = itemView.findViewById(R.id.descriptionTextView)
    }
}