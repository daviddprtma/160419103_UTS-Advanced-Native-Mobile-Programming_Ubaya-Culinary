package id.davidpratama.a160419103_ubayaculinary.model

import androidx.room.Dao
import androidx.room.Query

@Dao
interface SupportDao {
    @Query("SELECT * FROM support")
    suspend fun selectAllRecommendRestaurant(): List<Support>
}