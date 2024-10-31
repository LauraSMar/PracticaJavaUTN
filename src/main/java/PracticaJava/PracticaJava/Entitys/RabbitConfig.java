package PracticaJava.PracticaJava.Entitys;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RabbitConfig {
    @Bean
    public Queue fleteQueue() {
        return new Queue("fleteQueue", true);
    }
}
