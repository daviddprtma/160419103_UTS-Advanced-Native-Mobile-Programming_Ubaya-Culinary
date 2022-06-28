package id.davidpratama.a160419103_ubayaculinary.model

import androidx.room.Dao
import androidx.room.Query

@Dao
interface RecommendedRestaurantDao {
    @Query("SELECT * FROM recommendedrestaurant ")
    suspend fun selectAllRecommendRestaurant(): List<RecommendedRestaurant>

    @Query("SELECT MAX(rr.rating) FROM recommendedrestaurant rr INNER JOIN Restaurant r on r.idRestaurant == rr.idRecommended WHERE r.idRestaurant =:id")
    suspend fun selectRecommendRestaurant(id:Int):RecommendedRestaurant
}