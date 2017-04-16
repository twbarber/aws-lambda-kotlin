package lambda

import com.amazonaws.services.lambda.runtime.Context
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils

class Main {

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            print(Main().getIp())
        }
    }

    fun handler(context: Context): String {
        val lambdaLogger = context.logger
        val ip = getIp()
        lambdaLogger.log("Current IP is: $ip\n")
        lambdaLogger.log("Successfully executed Main.handler()\n")
        return "Successfully executed Main.handler()"
    }

    fun getIp() : String {
        val httpclient = HttpClients.createDefault();
        val httpGet = HttpGet("http://ip.jsontest.com/")
        val response = httpclient.execute(httpGet)
        return EntityUtils.toString(response.entity)
    }
}