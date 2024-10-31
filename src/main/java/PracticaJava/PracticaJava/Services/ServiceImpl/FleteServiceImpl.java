package PracticaJava.PracticaJava.Services.ServiceImpl;


import PracticaJava.PracticaJava.Entitys.EstadoFlete;
import PracticaJava.PracticaJava.Entitys.Flete;
import PracticaJava.PracticaJava.Repos.FleteRepository;
import PracticaJava.PracticaJava.Services.FleteService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class FleteServiceImpl implements FleteService {



    @Autowired
    private FleteRepository fleteRepository;
    private final RabbitTemplate rabbitTemplate = new RabbitTemplate();

    @Override
    public Optional<Flete> actualizarEstadoFlete(Long id) {
        Optional<Flete> found = fleteRepository.findById(id);

        if(found.isPresent()){

            LocalDateTime ahora = LocalDateTime.now();
            if(found.get().getInit().isBefore(ahora) && ahora.isAfter(found.get().getEnd())){
                EstadoFlete nuevoEstado = EstadoFlete.EN_HORARIO;
                found.get().setEstado(nuevoEstado.toString());

            } else {
                EstadoFlete nuevoEstado = EstadoFlete.DEMORADO;
                found.get().setEstado(nuevoEstado.toString());
            }

            fleteRepository.save(found.get());

            rabbitTemplate.convertAndSend("fleteQueue", found.get());
            System.out.println("Estado de Flete actualizado y enviado: " + found.get().getDescripcion());
        }
        return Optional.empty();

    }


}