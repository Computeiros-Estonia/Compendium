package com.estoniatech.compendium.model.room

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import android.content.Context
import androidx.room.Room

class RoomInstance {

        companion object {
            private var database: CompendiumDatabase? = null

            private val MIGRATION_1_2 = object : Migration(1, 2) {
                override fun migrate(database: SupportSQLiteDatabase) {
                    database.execSQL("DROP TABLE `Book`")
                    database.execSQL("CREATE TABLE IF NOT EXISTS `Book` (`key` TEXT NOT NULL, `Titulo` TEXT, `Autor` TEXT, `Editora` TEXT, `Ano` TEXT, PRIMARY KEY(`key`))")
                }
            }

            fun getInstance(applicationContext: Context): CompendiumDatabase {
                if (database == null) {

                    database = Room.databaseBuilder(
                        applicationContext,
                        CompendiumDatabase::class.java,
                        "ToDoList-Database"
                    )
                        .addMigrations(MIGRATION_1_2)
                        .build()
                }
                return database as CompendiumDatabase
            }
        }
    }