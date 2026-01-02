package com.sifu.mynotebook.domain.model.coinDetail

data class CoinDetailModel(
    val id: String = "",
    val rank: Int = 0,
    val hardwareWallet: Boolean = true,
    val isActive: Boolean = true,
    val isNew: Boolean = true,
    val openSource: Boolean = true,
    val description: String = "",
    val developmentStatus: String = "",
    val firstDataAt: String = "",
    val hashAlgorithm: String = "",
    val lastDataAt: String = "",
    val logo: String = "",
    val message: String = "",
    val name: String = "",
    val orgStructure: String = "",
    val proofType: String = "",
    val startedAt: String = "",
    val symbol: String = "",
    val type: String = "",
    val tags: ArrayList<TagModel> = arrayListOf(),
    val team: ArrayList<TeamModel> = arrayListOf(),
    val links: ArrayList<LinksModel> = arrayListOf(),
    val linksExtended: ArrayList<LinksExtendedModel> = arrayListOf(),
    val whitepaper: ArrayList<WhitepaperModel> = arrayListOf()
)
