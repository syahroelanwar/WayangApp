package com.skripsi155410177.wayangapp.model

import com.google.gson.annotations.SerializedName

data class Tokoh(
    @SerializedName("id") var id : String,
    @SerializedName("nama") var nama : String,
    @SerializedName("nama_lain") var nama_lain : String,
    @SerializedName("senjata") var senjata : String,
    @SerializedName("negara") var negara : String,
    @SerializedName("ayah") var ayah : String,
    @SerializedName("ibu") var ibu : String,
    @SerializedName("pasangan") var pasangan : String,
    @SerializedName("anak") var anak : String,
    @SerializedName("keterangan") var keterangan : String,
    @SerializedName("foto") var foto : String
)

data class TokohResult(@SerializedName("wayang") val wayang : List<Tokoh>)