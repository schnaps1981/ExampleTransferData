package com.data.transfer

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Data(val name: String, val surname: String, val age: Int) : Parcelable

