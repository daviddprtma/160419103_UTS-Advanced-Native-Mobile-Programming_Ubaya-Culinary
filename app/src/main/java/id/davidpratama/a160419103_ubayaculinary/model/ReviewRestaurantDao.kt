package id.davidpratama.a160419103_ubayaculinary.model

import androidx.room.Dao
import androidx.room.Query

@Dao
interface ReviewRestaurantDao {
    @Query("SELECT * FROM reviewrestaurant rr INNER JOIN Restaurant r on r.idRestaurant = rr.idReviewRestaurant")
    suspend fun selectAllReviewRestaurant(): List<ReviewRestaurant>
}