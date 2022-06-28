package id.davidpratama.a160419103_ubayaculinary.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Restaurant::class, ReviewRestaurant::class, Food::class, Drink::class
,RecommendedRestaurant::class,Profile::class, About::class,Support::class), version = 1)
abstract class RestaurantDatabase:RoomDatabase() {
    abstract fun restaurantDao(): RestaurantDao

    companion object{
        @Volatile private var instance: RestaurantDatabase?= null
        private val LOCK = Any()

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                RestaurantDatabase::class.java,
                "newrestaurantdb").build()

        operator fun invoke(context:Context) {
            if(instance!=null) {
                synchronized(LOCK) {
                    instance ?: buildDatabase(context).also {
                        instance = it
                    }
                }
            }
        }
    }
}