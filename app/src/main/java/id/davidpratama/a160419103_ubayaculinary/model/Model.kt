package id.davidpratama.a160419103_ubayaculinary.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

//test
@Entity
data class Restaurant(
    @ColumnInfo(name = "name")
    var name: String?,
    @ColumnInfo(name = "rating")
    var rating: String?,
    @ColumnInfo(name = "lokasi")
    var lokasi: String?,
    @ColumnInfo(name = "kategori")
    var kategori: String?,
    @ColumnInfo(name = "url")
    var url: String?,
    @ColumnInfo(name = "review")
    var review: String?
) {
    @PrimaryKey(autoGenerate = true)
    var idRestaurant: Int = 0
}

@Entity
data class ReviewRestaurant(
    @ColumnInfo(name = "nama")
    var nama:String?,
    @ColumnInfo(name = "komentar")
    var komentar:String?
) {
    @PrimaryKey(autoGenerate = true)
    var idReviewRestaurant: Int = 0
}

@Entity
data class Food(
//    @SerializedName("namaResto")
    @ColumnInfo(name = "namaResto")
    var namaResto:String?,
//    @SerializedName("nama")
    @ColumnInfo(name = "namaMakanan")
    var namaMakanan: String?,
//    @SerializedName("harga")
    @ColumnInfo(name = "harga")
    var harga: Int?,
//    @SerializedName("url")
    @ColumnInfo(name = "url")
    var urlFood: String?
){
    @PrimaryKey(autoGenerate = true)
    var idFood: Int = 0
}

@Entity
data class Drink(
//    @SerializedName("namaDrink")
    @ColumnInfo(name = "namaDrink")
    var namaDrink: String?,
//    @SerializedName("harga")
    @ColumnInfo(name = "harga")
    var harga: Int?,
//    @SerializedName("url")
    @ColumnInfo(name = "urlMinuman")
    var urlMinuman: String?
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
    @ColumnInfo(name = "namaRecommended")
    var namaRecommended: String?,
//    @SerializedName("url")
    @ColumnInfo(name = "urlRecommended")
    var urlRecommended: String?,
    @ColumnInfo(name = "ratingResto")
    var ratingResto : String?,
){
    @PrimaryKey(autoGenerate = true)
    var idRecommended: Int = 0
}

@Entity
data class Profile(
//    @SerializedName("idProfile")
//    @ColumnInfo(name = "idProfile")
//    val idProfile: String?,
//    @SerializedName("namaProfile")
    @ColumnInfo(name = "namaProfile")
    var namaProfile:String?,
//    @SerializedName("usernameProfile")
    @ColumnInfo(name = "usernameProfile")
    var usernameProfile: String?,
//    @SerializedName("url")
    @ColumnInfo(name = "url")
    var url: String?
){
    @PrimaryKey(autoGenerate = true)
    var idProfile: Int = 0
}

@Entity
data class About(
//    @SerializedName("about")
    @ColumnInfo(name = "about")
    var about: String?
)
{
    @PrimaryKey(autoGenerate = true)
    var idAbout: Int = 0
}

@Entity
data class Support(
    @ColumnInfo(name = "phone")
    var phone: String?,
    @ColumnInfo(name = "email")
    var email: String?
)
{
    @PrimaryKey(autoGenerate = true)
    var idSupport: Int = 0
}