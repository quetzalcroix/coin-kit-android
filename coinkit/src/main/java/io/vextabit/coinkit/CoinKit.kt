package io.vextabit.coinkit

import android.content.Context
import io.vextabit.coinkit.models.Coin
import io.vextabit.coinkit.models.CoinType
import io.vextabit.coinkit.providers.CoinManager
import io.vextabit.coinkit.providers.CoinProvider
import io.vextabit.coinkit.storage.Database
import io.vextabit.coinkit.storage.Storage

class CoinKit(private val coinManager: CoinManager) {

    fun getCoins(): List<Coin> {
        return coinManager.getCoins()
    }

    fun getDefaultCoins(): List<Coin> {
        return coinManager.getDefaultCoins()
    }

    fun getCoin(id: String): Coin? {
        return coinManager.getCoin(id)
    }

    fun getCoin(type: CoinType): Coin? {
        return coinManager.getCoin(type.getCoinId())
    }

    fun saveCoins(coins: List<Coin>) {
        return coinManager.saveCoins(coins)
    }

    companion object {

        fun create(context: Context, isTestnet: Boolean = false): CoinKit {
            val storage = Storage(Database.create(context))
            val coinProvider = CoinProvider(context, isTestnet)
            val coinManager = CoinManager(coinProvider, storage)

            return CoinKit(coinManager)
        }
    }
}