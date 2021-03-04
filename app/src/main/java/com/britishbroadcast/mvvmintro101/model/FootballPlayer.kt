package com.britishbroadcast.mvvmintro101.model

import android.os.Parcelable
import androidx.versionedparcelable.ParcelField
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FootballPlayer(val name: String, val team: String) : Parcelable