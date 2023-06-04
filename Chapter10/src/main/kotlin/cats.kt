import cats.CatsService

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

fun Routing.cats(service: CatsService) {
    route("/cats") {
        post {
            val parameters: Parameters = call.receiveParameters()
            val name = requireNotNull(parameters["name"])
            val age = parameters["age"]?.toInt() ?: 0
            service.create(name, age)
            call.respond(HttpStatusCode.Created)
        }
        get {
            val cats = service.findAll()
            call.respond(cats)
        }
        get("/{id}") {
//            val id = requireNotNull(call.parameters["id"]).toInt()
//
//            val cat = service.find(id)
//
//            if (cat == null) {
//                call.respond(HttpStatusCode.NotFound)
//            } else {
//                call.respond(cat)
//            }
            val id = requireNotNull(call.parameters["id"]).toInt()
            val cat = transaction {
                CatsTable.select {
                    CatsTable.id.eq(id)
                }.firstOrNull()
            }
            call.respond("found cat: $cat")
        }
    }
}




