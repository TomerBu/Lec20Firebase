package tomerbu.edu.lec20firebase.models

import java.sql.Timestamp

/**
 * טבלה מקשרת
 * תכיל ID של המשתמש וגם של החדר
 * תכלול את המידע שאנו רוצים להציג במסך חדרי צ'אט שהמשתמש נוכח בהם
 */
class UserRoom(val id: String = "",
               val userID: String = "",
               val roomID: String = "",
               val roomName: String = "",
               val imageURL: String? = "")

//userID
//roomID
//שם חדר
//אייקון