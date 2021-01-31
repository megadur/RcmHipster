import _root_.io.gatling.core.scenario.Simulation
import ch.qos.logback.classic.{Level, LoggerContext}
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import org.slf4j.LoggerFactory

import scala.concurrent.duration._

/**
 * Performance test for the IpAccess entity.
 */
class IpAccessGatlingTest extends Simulation {

    val context: LoggerContext = LoggerFactory.getILoggerFactory.asInstanceOf[LoggerContext]
    // Log all HTTP requests
    //context.getLogger("io.gatling.http").setLevel(Level.valueOf("TRACE"))
    // Log failed HTTP requests
    //context.getLogger("io.gatling.http").setLevel(Level.valueOf("DEBUG"))

    val baseURL = Option(System.getProperty("baseURL")) getOrElse """http://localhost:8080"""

    val httpConf = http
        .baseUrl(baseURL)
        .inferHtmlResources()
        .acceptHeader("*/*")
        .acceptEncodingHeader("gzip, deflate")
        .acceptLanguageHeader("fr,fr-fr;q=0.8,en-us;q=0.5,en;q=0.3")
        .connectionHeader("keep-alive")
        .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.10; rv:33.0) Gecko/20100101 Firefox/33.0")
        .silentResources // Silence all resources like css or css so they don't clutter the results

    val headers_http = Map(
        "Accept" -> """application/json"""
    )

    val headers_http_authentication = Map(
        "Content-Type" -> """application/json""",
        "Accept" -> """application/json"""
    )

    val headers_http_authenticated = Map(
        "Accept" -> """application/json""",
        "Authorization" -> "${access_token}"
    )

    val scn = scenario("Test the IpAccess entity")
        .exec(http("First unauthenticated request")
        .get("/api/account")
        .headers(headers_http)
        .check(status.is(401))
        ).exitHereIfFailed
        .pause(10)
        .exec(http("Authentication")
        .post("/api/authenticate")
        .headers(headers_http_authentication)
        .body(StringBody("""{"username":"admin", "password":"admin"}""")).asJson
        .check(header("Authorization").saveAs("access_token"))).exitHereIfFailed
        .pause(2)
        .exec(http("Authenticated request")
        .get("/api/account")
        .headers(headers_http_authenticated)
        .check(status.is(200)))
        .pause(10)
        .repeat(2) {
            exec(http("Get all ipAccesses")
            .get("/api/ip-accesses")
            .headers(headers_http_authenticated)
            .check(status.is(200)))
            .pause(10 seconds, 20 seconds)
            .exec(http("Create new ipAccess")
            .post("/api/ip-accesses")
            .headers(headers_http_authenticated)
            .body(StringBody("""{
                "id":null
                , "anschlussbilanzierung":"SAMPLE_TEXT"
                , "bssoeorderid":"SAMPLE_TEXT"
                , "coanakreaction":"SAMPLE_TEXT"
                , "credentialsrequested":"SAMPLE_TEXT"
                , "delegatedipv6prefix":"SAMPLE_TEXT"
                , "delegatedipv6prefixlength":"SAMPLE_TEXT"
                , "dnsprofile":"SAMPLE_TEXT"
                , "filterid":"SAMPLE_TEXT"
                , "fonAktiv":"SAMPLE_TEXT"
                , "framedipv6prefix":"SAMPLE_TEXT"
                , "framedipv6prefixlength":"SAMPLE_TEXT"
                , "haMSISDN":"SAMPLE_TEXT"
                , "influencesession":"SAMPLE_TEXT"
                , "iptvEnabled":"SAMPLE_TEXT"
                , "ipv4address":"SAMPLE_TEXT"
                , "ipv4netmask":"SAMPLE_TEXT"
                , "ipversion":"SAMPLE_TEXT"
                , "lineid":"SAMPLE_TEXT"
                , "maxdownspeed":"SAMPLE_TEXT"
                , "maxsessionduration":"SAMPLE_TEXT"
                , "maxupspeed":"SAMPLE_TEXT"
                , "mehrfachzugang":"SAMPLE_TEXT"
                , "profileid":"SAMPLE_TEXT"
                , "profilset":"SAMPLE_TEXT"
                , "rechtAufFesteIpadresse":"SAMPLE_TEXT"
                , "reserveprefix":"SAMPLE_TEXT"
                , "teilnehmersperre":"SAMPLE_TEXT"
                , "terminationprofile":"SAMPLE_TEXT"
                , "toNr":"SAMPLE_TEXT"
                , "tunnelprofile":"SAMPLE_TEXT"
                , "umtServiceDataOcssubscriptionid":"SAMPLE_TEXT"
                , "umtServiceDataThrottledownl3":"SAMPLE_TEXT"
                , "umtServiceDataThrottleprofile":"SAMPLE_TEXT"
                , "umtServiceDataThrottleupl3":"SAMPLE_TEXT"
                , "usecase":"SAMPLE_TEXT"
                , "userauthenticationrequired":"SAMPLE_TEXT"
                , "voipIsPresent":"SAMPLE_TEXT"
                }""")).asJson
            .check(status.is(201))
            .check(headerRegex("Location", "(.*)").saveAs("new_ipAccess_url"))).exitHereIfFailed
            .pause(10)
            .repeat(5) {
                exec(http("Get created ipAccess")
                .get("${new_ipAccess_url}")
                .headers(headers_http_authenticated))
                .pause(10)
            }
            .exec(http("Delete created ipAccess")
            .delete("${new_ipAccess_url}")
            .headers(headers_http_authenticated))
            .pause(10)
        }

    val users = scenario("Users").exec(scn)

    setUp(
        users.inject(rampUsers(Integer.getInteger("users", 100)) during (Integer.getInteger("ramp", 1) minutes))
    ).protocols(httpConf)
}
