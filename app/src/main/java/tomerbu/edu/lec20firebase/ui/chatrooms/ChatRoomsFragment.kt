package tomerbu.edu.lec20firebase.ui.chatrooms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import tomerbu.edu.lec20firebase.R
import tomerbu.edu.lec20firebase.databinding.FragmentChatroomsBinding

class ChatRoomsFragment : Fragment() {

    private lateinit var galleryViewModel: ChatRoomsViewModel
    private var _binding: FragmentChatroomsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        galleryViewModel =
            ViewModelProvider(this).get(ChatRoomsViewModel::class.java)

        _binding = FragmentChatroomsBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.fabAddRoom.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_nav_gallery_to_addRoomDialogFragment)
        }

        galleryViewModel.rooms.observe(viewLifecycleOwner){rooms->
            val recycler = binding.recyclerRooms
            recycler.layoutManager = LinearLayoutManager(requireContext())
            val adapter = ChatRoomsAdapter(rooms)
            recycler.adapter = adapter
            /*
            with(binding.recyclerRooms){
                layoutManager = LinearLayoutManager(requireContext())
                adapter = ChatRoomsAdapter(rooms)
            }*/
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}