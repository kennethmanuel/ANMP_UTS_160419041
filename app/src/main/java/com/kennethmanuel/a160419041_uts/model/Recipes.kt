package com.kennethmanuel.a160419041_uts.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Recipes (
    @ColumnInfo(name="name")
    var name:String?,
    @ColumnInfo(name="category")
    var category:String?,
    @ColumnInfo(name="ingredients")
    var ingredients:String?,
    @ColumnInfo(name="preparation")
    var preparation:String?,
    @ColumnInfo(name="picURL")
    var picURL:String?,
    @ColumnInfo(name="is_liked")
    var is_liked:Int?
) {
    @PrimaryKey(autoGenerate = true)
    var uuid:Int = 0
}