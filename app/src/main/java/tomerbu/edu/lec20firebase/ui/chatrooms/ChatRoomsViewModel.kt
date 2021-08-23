package tomerbu.edu.lec20firebase.ui.chatrooms

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import tomerbu.edu.lec20firebase.firebase.AuthManager
import tomerbu.edu.lec20firebase.models.User
import tomerbu.edu.lec20firebase.models.UserRoom

class ChatRoomsViewModel : ViewModel() {

    init {
        //id of the user:
        AuthManager.getUserID()?.let { uid ->
            FirebaseFirestore.getInstance().collection("UserRooms").document(uid)
                .collection("Rooms").addSnapshotListener { value, err ->
                if (err != null || value == null) {
                    return@addSnapshotListener
                }

                if (value.isEmpty) {
                    _rooms.postValue(emptyList())
                } else {
                    //new empty list:
                    val roomList = mutableListOf<UserRoom>()// ArrayList<UserRoom>()

                    //fill the list with documents from the collection:
                    for (doc in value) {
                        roomList.add(doc.toObject(UserRoom::class.java))
                    }
                    //post the live data:
                    _rooms.postValue(roomList)
                }
            }
        }
    }

    //private Mutable:
    private val _rooms = MutableLiveData<List<UserRoom>>()

    //Getter as read only:
    val rooms: LiveData<List<UserRoom>> = _rooms //read only version of _rooms
}