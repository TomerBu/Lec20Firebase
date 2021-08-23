package tomerbu.edu.lec20firebase.firebase

import com.google.firebase.auth.FirebaseAuth

/**
 * Created by tomerbuzaglo on 19/08/2021.
 * Copyright 2021 tomerbuzaglo. All Rights Reserved
 *
 * Licensed under the Apache License, Version 2.0
 * you may not use this file except
 * in compliance with the License
 */
object AuthManager {

    //sign out
    //is user signed in
    //get current User

    fun getUserName(): String {
        //nullable
        val user = FirebaseAuth.getInstance().currentUser

        user?.let {
            var name: String = user.displayName ?: ""

            if (name.isEmpty()) {
                name = user.email ?: ""
            }

            if (name.isEmpty()) {
                name = user.phoneNumber ?: ""
            }

            if (name.isEmpty()) {
                name = "Guest"
            }

            return name
        }
        return ""
    }

    //get the user ID:
    fun getUserID(): String? {
        return FirebaseAuth.getInstance().currentUser?.uid
    }

    //same in one line:
    fun getUserID2(): String? = FirebaseAuth.getInstance().currentUser?.uid

}