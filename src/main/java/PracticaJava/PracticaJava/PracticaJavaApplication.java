package PracticaJava.PracticaJava;

import PracticaJava.PracticaJava.Entitys.Destino;
import PracticaJava.PracticaJava.Entitys.EstadoFlete;
import PracticaJava.PracticaJava.Entitys.Flete;
import PracticaJava.PracticaJava.Entitys.Transporte;
import PracticaJava.PracticaJava.Repos.DestinoRepository;
import PracticaJava.PracticaJava.Repos.FleteRepository;
import PracticaJava.PracticaJava.Repos.TransporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class PracticaJavaApplication {

@Autowired
private FleteRepository fleteRepository;
@Autowired
private DestinoRepository destinoRepository;
@Autowired
private TransporteRepository transporteRepository;

	public static void main(String[] args) {
		SpringApplication.run(PracticaJavaApplication.class, args);


	}
	@Bean
	CommandLineRunner run() {
		return args -> {
			crearFletes();
		};
	}
	public  void crearFletes() {
        crearDestinos();
		crearTransportes();
		LocalDateTime now = LocalDateTime.now();
        List<Transporte> transporteList = transporteRepository.findAll();
		List<Destino> destinos = destinoRepository.findAll();
		if(!destinos.isEmpty() && !transporteList.isEmpty()) {
			Random random = new Random();
			List<Flete> list = fleteRepository.findAll();

			if (list.isEmpty()) {
				List<Flete> nuevosFletes = new ArrayList<>();
				Flete flete1 = new Flete("Flete1", now.plusHours(12), now.plusHours(49), destinos.get(random.nextInt(destinos.size())), transporteList.get(random.nextInt(transporteList.size())),"Inicio");
				Flete flete2 = new Flete("Flete2", now.plusHours(14), now.plusHours(50), destinos.get(random.nextInt(destinos.size())), transporteList.get(random.nextInt(transporteList.size())),"Inicio");
				Flete flete3 = new Flete("Flete3", now.plusHours(16), now.plusHours(51), destinos.get(random.nextInt(destinos.size())), transporteList.get(random.nextInt(transporteList.size())),"Inicio");
				nuevosFletes.add(flete1);
				nuevosFletes.add(flete2);
				nuevosFletes.add(flete3);
				fleteRepository.saveAll(nuevosFletes);
			} else {
				System.out.println("Fletes ya creados!");
			}
		}
	}
	public void crearDestinos(){
		List<Destino> list = destinoRepository.findAll();
		List<Destino> nuevosDestinos = List.of(
				new Destino("Manzanares 135", "Córdoba"),
				new Destino("La Habana 256", "San Luis"),
				new Destino("Ombu 4", "Carlos Paz"),
				new Destino("Agrelo 500", "Ciudad Buenos Aires")
		);
		destinoRepository.saveAll(nuevosDestinos);

	}

	public void crearTransportes(){
		List<Transporte> list = transporteRepository.findAll();
		List<Transporte> nuevosTransportes = List.of(
				new Transporte("Transporte Calico", "Reparto"),
				new Transporte("Clever Logística", "Base")
		);
		transporteRepository.saveAll(nuevosTransportes);

	}

}
