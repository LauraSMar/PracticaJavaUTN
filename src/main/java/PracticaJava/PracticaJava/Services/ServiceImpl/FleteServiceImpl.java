package PracticaJava.PracticaJava.Services.ServiceImpl;


import PracticaJava.PracticaJava.Entitys.Dtos.FleteDto;
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
    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Override
    public FleteDto actualizarEstadoFlete(Long id) {
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
            FleteDto fleteDTO = new FleteDto();
            fleteDTO.setId(found.get().getId());
            fleteDTO.setEstado(found.get().getEstado());
            fleteDTO.setTransporte(found.get().getTransporte().getNombre());
            fleteDTO.setId_transporte(found.get().getTransporte().getId());
            String nuevo = found.get().getDescripcion() + " " +found.get().getEstado().toString();

            rabbitTemplate.convertAndSend("fleteQueue", nuevo);
            System.out.println("Estado de Flete actualizado y enviado: " + nuevo);
            return fleteDTO;
        }
        return null;

    }


}