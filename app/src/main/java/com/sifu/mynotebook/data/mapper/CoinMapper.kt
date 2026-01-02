package com.sifu.mynotebook.data.mapper

import com.sifu.mynotebook.data.dto.coin.CoinDto
import com.sifu.mynotebook.data.dto.coinId.CoinDetails
import com.sifu.mynotebook.data.dto.coinId.Links
import com.sifu.mynotebook.data.dto.coinId.LinksExtended
import com.sifu.mynotebook.data.dto.coinId.Stats
import com.sifu.mynotebook.data.dto.coinId.Tag
import com.sifu.mynotebook.data.dto.coinId.Team
import com.sifu.mynotebook.data.dto.coinId.Whitepaper
import com.sifu.mynotebook.domain.model.coin.CoinModel
import com.sifu.mynotebook.domain.model.coinDetail.CandleData
import com.sifu.mynotebook.domain.model.coinDetail.CoinDetailModel
import com.sifu.mynotebook.domain.model.coinDetail.LinksExtendedModel
import com.sifu.mynotebook.domain.model.coinDetail.LinksModel
import com.sifu.mynotebook.domain.model.coinDetail.StatsModel
import com.sifu.mynotebook.domain.model.coinDetail.TagModel
import com.sifu.mynotebook.domain.model.coinDetail.TeamModel
import com.sifu.mynotebook.domain.model.coinDetail.WhitepaperModel
import java.time.Instant

fun <T, R> List<T>?.safeMapToArrayList(transform: (T) -> R): ArrayList<R> =
    this?.map(transform)?.toCollection(ArrayList()) ?: arrayListOf()

fun CoinDto.toDomain(): CoinModel {
    return CoinModel(
        id = id.orEmpty(),
        isActive = isActive ?: true,
        isNew = isNew ?: true,
        name = name.orEmpty(),
        rank = rank ?: 0,
        symbol = symbol.orEmpty(),
        type = type.orEmpty()
    )
}

fun CoinDetails.toDomain(): CoinDetailModel{
    return CoinDetailModel(
        id = id.orEmpty(),
        rank = rank ?: 0,
        hardwareWallet = hardwareWallet ?: true,
        isActive = isActive ?: true,
        isNew = isNew ?: true,
        openSource = openSource ?: true,
        description = description.orEmpty(),
        developmentStatus = developmentStatus.orEmpty(),
        firstDataAt = firstDataAt.orEmpty(),
        hashAlgorithm = hashAlgorithm.orEmpty(),
        lastDataAt = lastDataAt.orEmpty(),
        logo = logo.orEmpty(),
        message = message.orEmpty(),
        name = name.orEmpty(),
        orgStructure = orgStructure.orEmpty(),
        proofType = proofType.orEmpty(),
        startedAt = startedAt.orEmpty(),
        symbol = symbol.orEmpty(),
        type = type.orEmpty(),
        tags = tags.safeMapToArrayList { it.toDomain()},
        team = team.safeMapToArrayList { it.toDomain() },
        linksExtended = linksExtended.safeMapToArrayList { it.toDomain() },
        whitepaper = whitepaper.safeMapToArrayList { it.toDomain() },
        links = links.safeMapToArrayList { it.toDomain() },
    )
}

fun Tag.toDomain(): TagModel{
    return TagModel(
        coinCounter = coinCounter ?: 0,
        icoCounter = icoCounter ?: 0,
        id = id.orEmpty(),
        name = name.orEmpty()
    )
}

fun Team.toDomain(): TeamModel{
    return TeamModel(
        id = id.orEmpty(),
        name = name.orEmpty(),
        position = position.orEmpty()
    )
}

fun LinksExtended.toDomain(): LinksExtendedModel{
    return LinksExtendedModel(
        stats = stats?.safeMapToArrayList { it.toDomain() },
        type = type.orEmpty(),
        url = url.orEmpty()
    )
}

fun Stats.toDomain(): StatsModel {
    return StatsModel(
        contributors = contributors ?: 0,
        followers = followers ?: 0,
        stars = stars ?: 0,
        subscribers = subscribers ?: 0
    )
}

fun Whitepaper.toDomain(): WhitepaperModel {
    return WhitepaperModel(
        link = link.orEmpty(),
        thumbnail = thumbnail.orEmpty()
    )
}
fun Links.toDomain(): LinksModel {
    return LinksModel(
        explorer = explorer.safeMapToArrayList { it },
        facebook = facebook.safeMapToArrayList { it },
        reddit = reddit.safeMapToArrayList { it },
        sourceCode = sourceCode.safeMapToArrayList { it },
        website = website.safeMapToArrayList { it },
        youtube = youtube.safeMapToArrayList { it }
    )
}