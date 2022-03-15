package com.projeto.devagro;

import com.projeto.devagro.entities.*;
import com.projeto.devagro.entities.enums.Sexo;
import com.projeto.devagro.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
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

		Funcao f1 = new Funcao(1L, "Operador de Colheitadeira");
		Funcao f2 = new Funcao(2L, "Operador de Plantador");
		Funcao f3 = new Funcao(3L, "Piloto de Drone");

		Funcionario func1 = new Funcionario(1L, "Dennis", "Ritchie", Sexo.MASCULINO,"Rua 2 num 4", 1200.0,  "(49) 916787675", "01/01/2001", "01/01/2022", null);
		Funcionario func2 = new Funcionario(2L, "Ada","Lovelace", Sexo.FEMININO, "Rua 7 num 32", 2000.0,  "(21) 916787675", "02/01/2001", "02/01/2022", null);
		Funcionario func3 = new Funcionario(3L, "Linus", "Torvalds", Sexo.MASCULINO,"Rua 1 num 42", 800.0,  "(31) 916787675", "03/01/2001",  "03/01/2022", null);
		Funcionario func4 = new Funcionario(4L, "Bjarn", "Stroustrup", Sexo.NAO_INFORMADO,"Rua 1 num 43", 500.0,  "(51) 916787675", "04/01/2001", "04/01/2022", null);
		Funcionario func5 = new Funcionario(5L, "Guido", "van Rossum", Sexo.MASCULINO,"Rua 42 num 6", 3000.0,  "(44) 916787675", "05/01/2001", "05/01/2022", null);

		funcaoRepository.saveAll(Arrays.asList(f1, f2, f3));


		func1.getFuncoes().add(f2);
		func2.getFuncoes().add(f1);
		func2.getFuncoes().add(f3);
		func3.getFuncoes().add(f3);
		func4.getFuncoes().add(f3);
		func5.getFuncoes().add(f2);

		funcionarioRepository.saveAll(Arrays.asList(func1, func2, func3, func4, func5));

		Empresa e1 = new Empresa(1L, "Empresa Java LTDA", "97.753.887/0001-20", "Rua 8 num 90");
		Empresa e2 = new Empresa(2L, "Empresa Python SA", "36.890.964/0001-08", "Rua 4 num 2");

		empresaRepository.saveAll(Arrays.asList(e1, e2));

		func1.setEmpresa(e1);
		func2.setEmpresa(e1);
		func3.setEmpresa(e1);

		funcionarioRepository.saveAll(Arrays.asList(func1, func2, func3, func4, func5));

		Grao milho = new Grao(1L,"Milho", 120, e1);
		Grao soja = new Grao(2L,"Soja", 150,  e1);
		Grao feijao = new Grao(3L,"Feijão", 110, e2);
		Grao arroz = new Grao(4L,"Arroz", 5000, e2);

		graoRepository.saveAll(Arrays.asList(milho, soja, feijao, arroz));

		Fazenda fazenda1 = new Fazenda(1L, "Fazenda Arrocha","Rua 1 num 3", feijao,  Instant.parse("2022-03-11T19:53:07Z"), e1, 1000.00);
		Fazenda fazenda2 = new Fazenda(2L, "Fazenda DevInHouse", "Rua 2 num 2",milho, Instant.parse("2022-03-11T03:42:10Z"), e2, 500.00);
		Fazenda fazenda3 = new Fazenda(3L, "Fazenda Ai Papai", "Rua 3 num 1", soja, Instant.parse("2022-03-11T15:21:22Z"), e2, 3000.00);
		Fazenda fazenda4 = new Fazenda(4L, "Fazenda Cavalo", "Rua 8 num 8", arroz, Instant.parse("2022-03-11T15:21:22Z"), e2, 3000.00);

		empresaRepository.saveAll(Arrays.asList(e1, e2));
		fazendaRepository.saveAll(Arrays.asList(fazenda1, fazenda2, fazenda3, fazenda4));

		fazendaRepository.saveAll(Arrays.asList(fazenda1, fazenda2, fazenda3, fazenda4));

	}

}
