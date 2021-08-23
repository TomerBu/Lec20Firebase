package tomerbu.edu.lec20firebase.ui.chatrooms

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tomerbu.edu.lec20firebase.databinding.RoomItemBinding
import tomerbu.edu.lec20firebase.models.UserRoom

class ChatRoomsAdapter(val rooms: List<UserRoom>) :
    RecyclerView.Adapter<ChatRoomsAdapter.VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RoomItemBinding.inflate(inflater, parent, false)
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val room = rooms[position]
        holder.binding.textRoomName.text = room.roomName

        holder.binding.root.setOnClickListener{
            //
        }
    }

    override fun getItemCount(): Int = rooms.size

    class VH(val binding: RoomItemBinding) : RecyclerView.ViewHolder(binding.root)
}