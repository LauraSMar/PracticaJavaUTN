package PracticaJava.PracticaJava.Controllers;

import PracticaJava.PracticaJava.Entitys.Dtos.FleteDto;
import PracticaJava.PracticaJava.Excepcion.ErrorResponse;
import PracticaJava.PracticaJava.Services.FleteService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class FleteController {
    private final String QUEUE_NAME = "fleteQueue";

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private FleteService fleteService;

    @GetMapping("/notificacion/{id}")
    public ResponseEntity<?> enviarNotificacion(@PathVariable Long id) {
        FleteDto flete = fleteService.actualizarEstadoFlete(id);

        if (flete!=null) {
            return ResponseEntity.ok(flete);
        } else {
            ErrorResponse errorResponse = new ErrorResponse("Flete no encontrado con ID: " + id, HttpStatus.NOT_FOUND.value());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);


        }

    }
}

