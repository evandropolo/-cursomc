package com.evandropolo.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.evandropolo.cursomc.domain.Categoria;
import com.evandropolo.cursomc.domain.Cidade;
import com.evandropolo.cursomc.domain.Cliente;
import com.evandropolo.cursomc.domain.Endereco;
import com.evandropolo.cursomc.domain.Estado;
import com.evandropolo.cursomc.domain.Produto;
import com.evandropolo.cursomc.domain.enums.TipoCliente;
import com.evandropolo.cursomc.repositories.CategoriaRepository;
import com.evandropolo.cursomc.repositories.CidadeRepository;
import com.evandropolo.cursomc.repositories.ClienteRepository;
import com.evandropolo.cursomc.repositories.EnderecoRepository;
import com.evandropolo.cursomc.repositories.EstadoRepository;
import com.evandropolo.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria (null, "Informática");
		Categoria cat2 = new Categoria (null, "Escritório");
		
		Produto p1 = new Produto (null, "Computador", 2000.00);
		Produto p2 = new Produto (null, "Impressora", 800.00);
		Produto p3 = new Produto (null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategoria().addAll(Arrays.asList(cat1));
		p2.getCategoria().addAll(Arrays.asList(cat1, cat2));
		p3.getCategoria().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		
		Estado est1 = new Estado (null, "Minas Gerais");
		Estado est2 = new Estado (null, "São Paulo");
		
		Cidade c1 = new Cidade (null, "Uberlândia", est1);
		Cidade c2 = new Cidade (null, "Campinas", est2);
		Cidade c3 = new Cidade (null, "São Paulo", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		
		Cliente cli1 = new Cliente(null, "Maria da Silva", "maria@gmail", 
				"36378912377", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393" ));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303",
				"Jardim", "38220834", cli1, c2);
		
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800",
				"Centro", "38777012", cli1, c1);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		Cliente cli2 = new Cliente(null, "Rafael Bras da Silva", "rbSilva@gmail", 
				"1050766787", TipoCliente.PESSOAJURIDICA);
		
		cli2.getTelefones().addAll(Arrays.asList("34567890", "26654545" ));
		
		Endereco e3 = new Endereco(null, "Rua Alvorada", "44", "",
				"Rudgi", "45220994", cli2, c3);
		
		cli2.getEnderecos().addAll(Arrays.asList(e3));
		
		clienteRepository.saveAll(Arrays.asList(cli2));
		enderecoRepository.saveAll(Arrays.asList(e3));
	}
	
	

}
