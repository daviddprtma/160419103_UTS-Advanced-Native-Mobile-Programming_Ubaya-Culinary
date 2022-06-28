package id.davidpratama.a160419103_ubayaculinary.model

import androidx.room.Dao
import androidx.room.Query

@Dao
interface ProfileDao {
    @Query("SELECT * FROM profile")
    suspend fun selectAllProfile(): List<Profile>
}