package com.joko.plugins

import com.joko.customerRouting
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*

fun Application.configureRouting() {

    routing {
        get("/") {
                call.respond(HttpStatusCode.NotFound, mapOf("status" to true))
            }

        customerRouting()
    }
}
