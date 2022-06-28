package id.davidpratama.a160419103_ubayaculinary.model

import androidx.room.Dao
import androidx.room.Query

@Dao
interface FoodDao {
    @Query("SELECT * FROM food")
    suspend fun selectAllFood(): List<Food>

    @Query("SELECT * FROM food WHERE idFood =:id")
    suspend fun selectFood(id:Int):Food
}