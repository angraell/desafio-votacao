import io.gatling.core.Predef.*;
import io.gatling.http.Predef.*;
import io.gatling.core.structure.ScenarioBuilder;
import io.gatling.http.protocol.HttpProtocolBuilder;

public class MinhaSimulacao extends Simulation {

    HttpProtocolBuilder httpProtocol = http()
            .baseUrl("http://localhost:8080/") // Substitua pela URL do seu servidor
            .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
            .doNotTrackHeader("1")
            .acceptLanguageHeader("en-US,en;q=0.5")
            .acceptEncodingHeader("gzip, deflate")
            .userAgentHeader("Mozilla/5.0 (Windows NT 5.1; rv:40.0) Gecko/20100101 Firefox/40.0");

    ScenarioBuilder scn = scenario("Minha Simulacao")
            .exec(http("Requisição de Exemplo")
                    .get("/exemplo"));

    setUp(
            scn.inject(atOnceUsers(10)) // 10 usuários simultâneos
            ).protocols(httpProtocol);
}
