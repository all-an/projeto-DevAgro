package com.projeto.devagro;

import com.projeto.devagro.entities.Empresa;
import com.projeto.devagro.entities.Funcao;
import com.projeto.devagro.entities.Funcionario;
import com.projeto.devagro.entities.Grao;
import com.projeto.devagro.entities.enums.Sexo;
import com.projeto.devagro.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class DevagroApplication implements CommandLineRunner {

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private FazendaRepository fazendaRepository;

	@Autowired
	private FuncaoRepository funcaoRepository;

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private GraoRepository graoRepository;


	public static void main(String[] args) {
		SpringApplication.run(DevagroApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// instanciações somente para testes

		Empresa e1 = new Empresa(1L, "Empresa Java LTDA", "97.753.887/0001-20", "Rua 8 num 90");
		Empresa e2 = new Empresa(2L, "Empresa Python SA", "36.890.964/0001-08", "Rua 4 num 2");

		empresaRepository.saveAll(Arrays.asList(e1, e2));

		Funcao f1 = new Funcao(1L, "Operador de Colheitadeira");
		Funcao f2 = new Funcao(2L, "Operador de Plantador");
		Funcao f3 = new Funcao(3L, "Piloto de Drone");

		Funcionario func1 = new Funcionario(1L, "Dennis", "Ritchie", "100.643.880-77", Sexo.MASCULINO,"Rua 2 num 4", 1200.0,  "(49) 916787675", "01/01/2001", "01/01/2022", e1);
		Funcionario func2 = new Funcionario(2L, "Ada","Lovelace", "516.538.720-80", Sexo.FEMININO, "Rua 7 num 32", 2000.0,  "(21) 916787675", "02/01/2001", "02/01/2022", e1);
		Funcionario func3 = new Funcionario(3L, "Linus", "Torvalds","089.470.250-54", Sexo.MASCULINO,"Rua 1 num 42", 800.0,  "(31) 916787675", "03/01/2001",  "03/01/2022", e1);
		Funcionario func4 = new Funcionario(4L, "Bjarn", "Stroustrup","011.763.210-48", Sexo.NAO_INFORMADO,"Rua 1 num 43", 500.0,  "(51) 916787675", "04/01/2001", "04/01/2022", e2);
		Funcionario func5 = new Funcionario(5L, "Guido", "van Rossum","069.010.080-90", Sexo.MASCULINO,"Rua 42 num 6", 3000.0,  "(44) 916787675", "05/01/2001", "05/01/2022", e2);

		funcaoRepository.saveAll(Arrays.asList(f1, f2, f3));


		func1.getFuncoes().add(f2);
		func2.getFuncoes().add(f1);
		func2.getFuncoes().add(f3);
		func3.getFuncoes().add(f3);
		func4.getFuncoes().add(f3);
		func5.getFuncoes().add(f2);

		funcionarioRepository.saveAll(Arrays.asList(func1, func2, func3, func4, func5));

		Grao milho = new Grao(null,"Milho", 120, e1);
		Grao soja = new Grao(null,"Soja", 150,  e1);
		Grao feijao = new Grao(null,"Feijão", 110, e2);
		Grao arroz = new Grao(null,"Arroz", 5000, e2);

		graoRepository.saveAll(Arrays.asList(milho, soja, feijao, arroz));
	}

}
