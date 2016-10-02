package com.example;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DummyCLR implements CommandLineRunner {

	private final ReservationRepository reservationRepository;
	
	@Autowired	
	public DummyCLR(ReservationRepository reservationRepository) {
		this.reservationRepository = reservationRepository;
	}

	@Override
	public void run(String... arg0) throws Exception {
		Stream.of("Spencer", "Mark", "Stefan", "Maria", "Arnaud", "Antonio")
			.forEach(n -> reservationRepository.save(new Reservation(n)));
		
		reservationRepository.findAll().forEach(System.out::println);
	}

}
