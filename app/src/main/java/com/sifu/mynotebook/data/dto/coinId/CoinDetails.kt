package com.sifu.mynotebook.data.dto.coinId


import com.google.gson.annotations.SerializedName

data class CoinDetails(
    @SerializedName("id")
    val id: String?,
    @SerializedName("rank")
    val rank: Int?,
    @SerializedName("hardware_wallet")
    val hardwareWallet: Boolean?,
    @SerializedName("is_active")
    val isActive: Boolean?,
    @SerializedName("is_new")
    val isNew: Boolean?,
    @SerializedName("open_source")
    val openSource: Boolean?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("development_status")
    val developmentStatus: String?,
    @SerializedName("first_data_at")
    val firstDataAt: String?,
    @SerializedName("hash_algorithm")
    val hashAlgorithm: String?,
    @SerializedName("last_data_at")
    val lastDataAt: String?,
    @SerializedName("logo")
    val logo: String?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("org_structure")
    val orgStructure: String?,
    @SerializedName("proof_type")
    val proofType: String?,
    @SerializedName("started_at")
    val startedAt: String?,
    @SerializedName("symbol")
    val symbol: String?,
    @SerializedName("tags")
    val tags: ArrayList<Tag>?,
    @SerializedName("team")
    val team: ArrayList<Team>?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("links")
    val links: ArrayList<Links>?,
    @SerializedName("links_extended")
    val linksExtended: ArrayList<LinksExtended>?,
    @SerializedName("whitepaper")
    val whitepaper: ArrayList<Whitepaper>?
)