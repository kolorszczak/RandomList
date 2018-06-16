package eu.mihau.randomlist.model

import android.databinding.BaseObservable

data class Element(
        var counter: Long,
        var colorRes: Int) : BaseObservable()