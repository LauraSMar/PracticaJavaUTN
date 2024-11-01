package PracticaJava.PracticaJava.Controllers;

import PracticaJava.PracticaJava.Entitys.Dtos.FleteDto;
import PracticaJava.PracticaJava.Entitys.Flete;
import PracticaJava.PracticaJava.Repos.FleteRepository;
import PracticaJava.PracticaJava.Services.FleteService;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FleteController {
    private final String QUEUE_NAME = "fleteQueue";

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private FleteService fleteService;

    @GetMapping("/notificacion/{id}")
    public ResponseEntity<FleteDto> enviarNotificacion(@PathVariable Long id) {
        FleteDto flete = fleteService.actualizarEstadoFlete(id);

        if (flete!=null) {
            return ResponseEntity.ok(flete);
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}

