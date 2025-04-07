import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a30daysapp.R
import com.example.a30daysapp.Tip

class TipAdapter(private val tips: List<Tip>) : RecyclerView.Adapter<TipAdapter.TipViewHolder>() {

    class TipViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dayTextView: TextView = view.findViewById(R.id.tip_day)
        val shortAdviceTextView: TextView = view.findViewById(R.id.tip_short_advice)
        val imageView: ImageView = view.findViewById(R.id.tip_image)
        val descriptionTextView: TextView = view.findViewById(R.id.tip_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tip, parent, false)
        return TipViewHolder(view)
    }

    override fun onBindViewHolder(holder: TipViewHolder, position: Int) {
        val tip = tips[position]
        holder.dayTextView.text = tip.day
        holder.shortAdviceTextView.text = tip.shortAdvice
        holder.imageView.setImageResource(tip.imageResId) // Убедитесь, что у вас есть ресурс изображения
        holder.descriptionTextView.text = tip.description
    }

    override fun getItemCount(): Int {
        return tips.size
    }
}
