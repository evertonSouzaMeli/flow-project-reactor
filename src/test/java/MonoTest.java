import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

/*
* Reative Streams
* 1. Assincrono
* 2. Non-bloqueante
* 3. Lidar com o backpressure
*
* Publisher -→ quem emite os eventos [cold]
* Subscriber -→ quem se inscreve no Publisher para consumir
* Subscription -→ contrato gerado no momento da inscrição Pub|Sub
*
* Publisher -→ (onNext)
*   1.Quando o Publisher envia todos os elementos
*   2.Quando o Publisher envia todos os elementos pedidos
*   3.Quando ocorre algum erro
* */

@Slf4j
public class MonoTest {

    @Test
    public void test(){
        log.info("Everything working as intended");
    }

    @Test
    public void monoSubscriber(){
        var hello = "Hello World";
        var mono = Mono.just(hello).log();

        mono.subscribe(str -> log.info("Mono - {}", str));

        StepVerifier.create(mono)
                .expectSubscription()
                .expectNext(hello)
                .verifyComplete();
    }
}
