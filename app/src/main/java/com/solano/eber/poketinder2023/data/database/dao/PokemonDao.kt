package com.solano.eber.poketinder2023.data.database.dao
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.solano.eber.poketinder2023.data.database.entities.MyPokemonEntity

@Dao
interface PokemonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pokemon: MyPokemonEntity)

    @Query("SELECT * FROM pokemon_table")
    suspend fun getAllPokemons(): List<MyPokemonEntity>

    @Query("DELETE FROM pokemon_table")
    suspend fun deleteTable();

}