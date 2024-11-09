package com.aula.biblioteca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aula.biblioteca.repository.LivroRepository;

@SpringBootApplication
public class StartupBiblioteca {

    @Autowired
    private LivroRepository livroRepository;

    public static void main(String[] args) {
        SpringApplication.run(StartupBiblioteca.class, args);
    }

    // @Test
    // void main() {
    //     BibliotecaApplication.main(new String[]{});
    // }
	public void MongoDBTest() {
        //System.out.println(livroRepository.findByTitulo("Livro B"));
        //System.out.println(livroRepository.findByNotaAndQtdePaginasGreaterThanEqual(300, 8f));
    }

}
