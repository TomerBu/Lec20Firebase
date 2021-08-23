package tomerbu.edu.lec20firebase.models

import android.os.Parcelable
import com.google.firebase.Timestamp
import kotlinx.parcelize.Parcelize
import javax.annotation.Nullable

@Parcelize
class User(
    val uid: String = "",
    val name: String = "",
    val timeStamp: Timestamp = Timestamp.now(),
    val imageURL: String? = null
) : Parcelable
