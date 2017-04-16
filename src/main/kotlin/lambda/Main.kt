package lambda

import com.amazonaws.services.lambda.runtime.Context

class Main {

    fun handler(context: Context): String {
        val lambdaLogger = context.logger
        lambdaLogger.log("Successfully executed Main.handler()")
        return "Successfully executed Main.handler()"
    }
}