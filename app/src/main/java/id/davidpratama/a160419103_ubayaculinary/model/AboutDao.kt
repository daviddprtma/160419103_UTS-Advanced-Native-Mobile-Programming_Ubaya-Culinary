package id.davidpratama.a160419103_ubayaculinary.model

import androidx.room.Dao
import androidx.room.Query

@Dao
interface AboutDao {
    @Query("SELECT * FROM about ")
    suspend fun selectAllAbout(): List<About>
}