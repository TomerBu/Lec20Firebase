package tomerbu.edu.lec20firebase.ui.dialogs

import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

import tomerbu.edu.lec20firebase.databinding.FragmentAddRoomDialogBinding
import tomerbu.edu.lec20firebase.firebase.AuthManager

class AddRoomDialogFragment : BottomSheetDialogFragment() {
    //property:
    lateinit var addRoomViewModel: AddRoomViewModel
    private var _binding: FragmentAddRoomDialogBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        addRoomViewModel= ViewModelProvider(this).get(AddRoomViewModel::class.java)
        _binding = FragmentAddRoomDialogBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.animate().rotation(360f)

        val layoutParams = binding.root.layoutParams

        //Next lesson we will get the height of the window
        layoutParams.height = 1500

        binding.root.layoutParams = layoutParams


        binding.buttonAddRoom.setOnClickListener {
            val roomName = binding.editRoomName.text.toString()

            AuthManager.getUserID()?.let {uid->

                val userName = AuthManager.getUserName()
                addRoomViewModel.addRoom(uid, userName, roomName, null)

                dismiss()
            }
        }

        val behaviour = (dialog as BottomSheetDialog).behavior
        behaviour.state = BottomSheetBehavior.STATE_EXPANDED
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}