package tomerbu.edu.lec20firebase.models

import com.google.firebase.Timestamp


class Message(val id: String,
              val ownerID: String,
              val ownerName: String,
              val timestamp: Timestamp,
              val text: String)