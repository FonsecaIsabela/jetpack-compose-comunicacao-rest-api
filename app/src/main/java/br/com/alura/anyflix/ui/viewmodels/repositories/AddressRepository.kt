package br.com.alura.anyflix.ui.viewmodels.repositories

import android.util.Log
import br.com.alura.anyflix.model.Address
import br.com.alura.anyflix.network.services.AddressService
import br.com.alura.anyflix.network.services.toAddress
import coil.network.HttpException
import java.net.ConnectException
import javax.inject.Inject

private const val TAG = "AddressRepository"

class AddressRepository @Inject constructor(
    private val service: AddressService
) {
    suspend fun findAddress(cep: String): Address? {
        return try {
            service.findAddress(cep).toAddress()
        } catch (e: HttpException) {
            Log.e(TAG, "findAddress: ", e)
            null
        } catch (e: ConnectException) {
            Log.e(TAG, "findAddress: ", e)
            null
        }
    }
}