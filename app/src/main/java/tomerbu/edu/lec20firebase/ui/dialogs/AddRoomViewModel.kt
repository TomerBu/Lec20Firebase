package tomerbu.edu.lec20firebase.ui.dialogs

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import tomerbu.edu.lec20firebase.models.ChatRoom
import tomerbu.edu.lec20firebase.models.UserRoom

class AddRoomViewModel() : ViewModel() {

    fun addRoom(
        userID: String,
        userName: String,
        roomName: String,
        imageUrl: String?
    ) {

        //new Doc:
        val roomDocument = FirebaseFirestore.
        getInstance().
        collection("ChatRooms").
        document()


        //get the id from the new doc:

        //דה-נירמול - שמירה ב-2 מקומות:
        //ChatRoom
        val id = roomDocument.id
        val room = ChatRoom(id, roomName, imageUrl)
        roomDocument.set(room)

        //UserRoom
        val doc = FirebaseFirestore.
        getInstance().
        collection("UserRooms").
        document(userID).
        collection("Rooms").document()
        val userRoom = UserRoom(doc.id, userID, id,roomName, imageUrl )
        doc.set(userRoom)
    }
}