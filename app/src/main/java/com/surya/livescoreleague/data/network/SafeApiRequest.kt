package com.surya.livescoreleague.data.network

import com.surya.livescoreleague.util.ApiException
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response
import java.lang.StringBuilder

/**
 * Created by suryamudti on 03/08/2019.
 */
abstract class SafeApiRequest {

    suspend fun <T:Any> apiRequest(call: suspend ()-> Response<T>) : T{

        val response = call.invoke()

        if (response.isSuccessful){
            return response.body()!!
        }else{
            val  error = response.errorBody()?.string()
            val message = StringBuilder()

            error?.let {
                try {
                    message.append(JSONObject(it).getString("message"))
                }catch (e: JSONException){

                }
                message.append("\n")

            }
            message.append("Error code ${response.code()}")

            throw ApiException(message.toString())
        }

    }
}