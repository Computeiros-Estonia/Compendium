package com.estoniatech.compendium.model.room

import androidx.room.Dao
import androidx.room.Insert
import com.estoniatech.compendium.model.Book
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CompendiumDao {
    @Query("SELECT * FROM Book ORDER BY key DESC")
    fun getBookList(): LiveData<List<Book>>

    @Query("SELECT * FROM Book WHERE key = :key ")
    suspend fun getBook(key: String): Book?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(book: Book)
    @Delete
    suspend fun delete(book: Book)
}