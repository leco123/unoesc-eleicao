package br.edu.unoesc.java.eleicao.ui;

import java.util.List;

import br.edu.unoesc.java.eleicao.dao.impl.jdbc.Conexao;
import br.edu.unoesc.java.eleicao.dao.impl.jdbc.PartidoDAOJdbc;
import br.edu.unoesc.java.eleicao.model.Candidato;
import br.edu.unoesc.java.eleicao.model.Cargo;
import br.edu.unoesc.java.eleicao.model.Partido;

/**
 * Executa a aplica��o da Elei��o
 * 
 * @author Roberson Alves
 *
 */
public class EleicaoApp {

	public static void main(String[] args) {
		// Conex�o na base de dados - testar a conex�o
		Conexao.conectar("jdbc:postgresql:unoesceleicao", "postgres", "postgres", "org.postgresql.Driver");
		
		// cria��o de um novo partido

		Partido partido = new Partido(10, "Partido", "PRT");
		// dados do partido
		System.out.println("-----------------------");
		System.out.println(partido.getNome());
		System.out.println(partido.getSigla());
		
		PartidoDAOJdbc partidoDAO = new PartidoDAOJdbc();
		partidoDAO.salvar(partido);		
		
		Partido partido1 = new Partido();
		partido1.setCodigo(20);
		partido1.setNome("Partido da TI");
		partido1.setSigla("PTI");
		
		partidoDAO.salvar(partido1);		
		
		List<Partido> partidos = partidoDAO.listar();
		for (Partido partido2 : partidos) {
			System.out.println(partido2.getNome());
		}
		
		
		System.out.println("-----------------------");
		System.out.println(partido1.getNome());
		System.out.println(partido1.getSigla());
		
		
//		
//		PartidoDAO partidoDao = new PartidoDAOJdbc();
//		partidoDao.salvar(partido);

		Candidato candidato = new Candidato();
		candidato.setCodigoRegistro(123);
		candidato.setCpf(123L);
		candidato.setNome("Candidato");
		candidato.setPartido(partido);
		candidato.setCargo(Cargo.GOVERNADOR);

		// dados do candidato
		System.out.println("-----------------------");
		System.out.println(candidato.getCpf());
		System.out.println(candidato.getCargo().toString());
//		// acessando dados do partido a partir de candidato
//		System.out.println(candidato.getPartido().getSigla());
//		System.out.println(candidato.getCargo().toString());
//
//		// testando a funcionalida da interface de validar documentos
//		if (candidato.validarDocumento(candidato.getCpf()))
//			System.out.println("V�lido!");
//		else
//			System.out.println("Inv�lido!");
	}
}
