package io.vextabit.coinkit.demo

import android.content.Context
import io.vextabit.coinkit.CoinKit
import io.vextabit.coinkit.models.Coin
import io.vextabit.coinkit.models.CoinType

class CoinManager(context: Context, isTestnet: Boolean) {
    private val coinKit = CoinKit.create(context, isTestnet)

    fun getCoins() : List<Coin>{
        return coinKit.getCoins()
    }

    fun getCoin(coinType: CoinType) : Coin? {
        return coinKit.getCoin(coinType)
    }

}