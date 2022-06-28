package id.davidpratama.a160419103_ubayaculinary.model

import androidx.room.Dao
import androidx.room.Query

@Dao
interface DrinkDao {
    @Query("SELECT * FROM drink")
    suspend fun selectAllDrink(): List<Drink>

    @Query("SELECT * FROM drink WHERE idDrink=:id")
    suspend fun selectDrink(id:Int):Drink
}