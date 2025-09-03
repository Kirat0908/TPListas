package br.unisanta.tp3
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.unisanta.tp3.model.Task

class TaskAdapter(
    private val tasks: List<Task>,
    private val onCompleteClick: (Int) -> Unit
) : RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txvName: TextView = itemView.findViewById(R.id.txv_Name)
        val txvDescription: TextView = itemView.findViewById(R.id.txv_Description)
        val txvStatus: TextView = itemView.findViewById(R.id.txv_Status)
        val btnComplete: Button = itemView.findViewById(R.id.btn_Complete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val task = tasks[position]
        holder.txvName.text = task.name
        holder.txvDescription.text = task.description
        holder.txvStatus.text = if (task.isCompleted) "Concluída" else "Pendente"
        holder.btnComplete.isEnabled = !task.isCompleted
        holder.btnComplete.setOnClickListener {
            onCompleteClick(position)
        }
    }

    override fun getItemCount(): Int = tasks.size
}