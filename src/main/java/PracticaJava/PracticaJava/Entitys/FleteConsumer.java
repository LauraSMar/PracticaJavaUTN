package PracticaJava.PracticaJava.Entitys;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FleteConsumer {


    @RabbitListener(queues = "fleteQueue")
    public void receiveFlete(Flete flete) {

        System.out.println("Flete recibido: " + flete);
    }
}
