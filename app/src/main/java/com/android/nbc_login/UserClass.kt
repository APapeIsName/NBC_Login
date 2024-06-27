package com.android.nbc_login

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserClass(val id: String, val pwd: String, val name: String, val chicken: String) : Parcelable