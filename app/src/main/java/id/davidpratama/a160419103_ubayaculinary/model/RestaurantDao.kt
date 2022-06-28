package id.davidpratama.a160419103_ubayaculinary.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RestaurantDao
{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllRestaurant(vararg restaurant: Restaurant)

    @Query("SELECT * FROM restaurant")
    suspend fun selectAllRestaurant(): List<Restaurant>

    @Query("SELECT * FROM restaurant WHERE idRestaurant =:id")
    suspend fun selectRestaurant(id:Int):Restaurant
}