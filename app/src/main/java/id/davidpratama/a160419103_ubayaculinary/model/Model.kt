package id.davidpratama.a160419103_ubayaculinary.model

import com.google.gson.annotations.SerializedName

data class Restaurant(
    @SerializedName("id")
    val idRestaurant: String?,
    @SerializedName("name")
    val namaRestaurant: String?,
    @SerializedName("rating")
    val ratingRestaurant: String?,
    @SerializedName("lokasi")
    val lokasiRestaurant: String?,
    @SerializedName("kategori")
    val kategoriRestaurant: String?,
    @SerializedName("url")
    val urlRestaurant: String?,
    @SerializedName("review")
    val review : ArrayList<ReviewRestaurant>
)

data class ReviewRestaurant(
    val nama:String?,
    val komentar:String?
)


data class Food(
    @SerializedName("namaResto")
    val namaResto:String?,
    @SerializedName("nama")
    val namaMakanan: String?,
    @SerializedName("harga")
    val harga: Int?,
    @SerializedName("url")
    val urlFood: String?
)

data class Drink(
    @SerializedName("namaDrink")
    val namaMinuman: String?,
    @SerializedName("harga")
    val hargaMinuman: Int?,
    @SerializedName("url")
    val urlMinuman: String?
)

data class RecommendedRestaurant(
    @SerializedName("id")
    val idRecommended: String?,
    @SerializedName("name")
    val namaRecommended: String?,
    @SerializedName("url")
    val urlRecommended: String?
)

data class Profile(
    @SerializedName("idProfile")
    val idProfile: String?,
    @SerializedName("namaProfile")
    val namaProfile:String?,
    @SerializedName("usernameProfile")
    val usernameProfile: String?,
    @SerializedName("url")
    val url: String?
)

data class About(
    @SerializedName("about")
    val about: String?
)

data class Support(
    val phone: String?,
    val email: String?
)