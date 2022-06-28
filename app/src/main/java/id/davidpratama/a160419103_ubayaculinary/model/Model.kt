package id.davidpratama.a160419103_ubayaculinary.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Restaurant(
//    @SerializedName("id")
//    @ColumnInfo(name = "id")
//    val idRestaurant: String?,
//    @SerializedName("name")
    @ColumnInfo(name = "name")
    val namaRestaurant: String?,
//    @SerializedName("rating")
    @ColumnInfo(name = "rating")
    val ratingRestaurant: String?,
//    @SerializedName("lokasi")
    @ColumnInfo(name = "lokasi")
    val lokasiRestaurant: String?,
//    @SerializedName("kategori")
    @ColumnInfo(name = "kategori")
    val kategoriRestaurant: String?,
//    @SerializedName("url")
    @ColumnInfo(name = "url")
    val urlRestaurant: String?,
//    @SerializedName("review")
    @ColumnInfo(name = "review")
    val review : ArrayList<ReviewRestaurant>
) {
    @PrimaryKey(autoGenerate = true)
    var idRestaurant: Int = 0
}

@Entity
data class ReviewRestaurant(
    @ColumnInfo(name = "nama")
    val nama:String?,
    @ColumnInfo(name = "komentar")
    val komentar:String?
) {
    @PrimaryKey(autoGenerate = true)
    var idReviewRestaurant: Int = 0
}

@Entity
data class Food(
//    @SerializedName("namaResto")
    @ColumnInfo(name = "namaResto")
    val namaResto:String?,
//    @SerializedName("nama")
    @ColumnInfo(name = "namaMakanan")
    val namaMakanan: String?,
//    @SerializedName("harga")
    @ColumnInfo(name = "harga")
    val harga: Int?,
//    @SerializedName("url")
    @ColumnInfo(name = "url")
    val urlFood: String?
){
    @PrimaryKey(autoGenerate = true)
    var idFood: Int = 0
}

@Entity
data class Drink(
//    @SerializedName("namaDrink")
    @ColumnInfo(name = "namaDrink")
    val namaMinuman: String?,
//    @SerializedName("harga")
    @ColumnInfo(name = "harga")
    val hargaMinuman: Int?,
//    @SerializedName("url")
    @ColumnInfo(name = "url")
    val urlMinuman: String?
)
{
    @PrimaryKey(autoGenerate = true)
    var idDrink: Int = 0
}

@Entity
data class RecommendedRestaurant(
//    @SerializedName("id")
//    @ColumnInfo(name = "id")
//    val idRecommended: String?,
//    @SerializedName("name")
    @ColumnInfo(name = "name")
    val namaRecommended: String?,
//    @SerializedName("url")
    @ColumnInfo(name = "url")
    val urlRecommended: String?,
    @ColumnInfo(name = "rating")
    val ratingResto : String?,
){
    @PrimaryKey(autoGenerate = true)
    val idRecommended: Int = 0
}

@Entity
data class Profile(
//    @SerializedName("idProfile")
//    @ColumnInfo(name = "idProfile")
//    val idProfile: String?,
//    @SerializedName("namaProfile")
    @ColumnInfo(name = "namaProfile")
    val namaProfile:String?,
//    @SerializedName("usernameProfile")
    @ColumnInfo(name = "namaProfile")
    val usernameProfile: String?,
//    @SerializedName("url")
    @ColumnInfo(name = "url")
    val url: String?
){
    @PrimaryKey(autoGenerate = true)
    val idProfile: Int = 0
}

@Entity
data class About(
//    @SerializedName("about")
    @ColumnInfo(name = "about")
    val about: String?
)
{
    @PrimaryKey(autoGenerate = true)
    var idAbout: Int = 0
}

@Entity
data class Support(
    @ColumnInfo(name = "phone")
    val phone: String?,
    @ColumnInfo(name = "email")
    val email: String?
)
{
    @PrimaryKey(autoGenerate = true)
    var idSupport: Int = 0
}