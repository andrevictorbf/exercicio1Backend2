package com.aula.biblioteca;

import com.aula.biblioteca.repository.LivroRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartupBiblioteca {

	@Autowired
	private LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(StartupBiblioteca.class, args);
	}


	@PostConstruct
	public void MongoDBTest(){
		//System.out.println(livroRepository.findByTitulo("Livro B"));
		//System.out.println(livroRepository.findByNotaAndQtdePaginasGreaterThanEqual(300, 8f));
	}

}
