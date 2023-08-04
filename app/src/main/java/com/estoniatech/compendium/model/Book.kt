package com.estoniatech.compendium.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Book (
    @PrimaryKey var key: String,
    @ColumnInfo(name = "titulo") var title: String? = null,
    @ColumnInfo(name = "autor") var author: String? = null,
    @ColumnInfo(name = "editora") var publisher: String? = null,
    @ColumnInfo(name = "ano") var publicationYear: String? = null
    )
