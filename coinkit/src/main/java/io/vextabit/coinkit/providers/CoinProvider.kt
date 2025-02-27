package io.vextabit.coinkit.providers

import android.content.Context
import io.vextabit.coinkit.models.CoinResponse

class CoinProvider(private val context: Context, isTestnet: Boolean) {

    private val filename: String = if (!isTestnet) "default.coins.json" else "default.coins.testnet.json"

    fun defaultCoins(): CoinResponse {
        return CoinResponse.parseFile(context, filename)
    }
}