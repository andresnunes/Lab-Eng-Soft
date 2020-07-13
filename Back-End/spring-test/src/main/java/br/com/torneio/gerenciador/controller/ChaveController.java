package br.com.torneio.gerenciador.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.torneio.gerenciador.model.Atleta;
import br.com.torneio.gerenciador.model.Organizador;
import br.com.torneio.gerenciador.repository.AtletaRepository;
import br.com.torneio.gerenciador.repository.OrganizadorRepository;
import br.com.torneio.gerenciador.repository.PartidaRepository;
import br.com.torneio.gerenciador.repository.PartidasRepository;

@Controller
@RequestMapping("{id_organizador}/{id_torneio}/chaves")
public class ChaveController {
	@Autowired
	OrganizadorRepository or;
	@Autowired
	PartidaRepository pr;
	@Autowired
	PartidasRepository psr;
	@Autowired
	AtletaRepository ar;
	
	@RequestMapping("/view")
	public ModelAndView listChaves(@PathVariable("id_organizador") long id_organizador, @PathVariable("id_torneio") long id_torneio) {
		ModelAndView mv = new ModelAndView("chaves");
		Organizador organizador = or.findById(id_organizador);
		mv.addObject("organizador", organizador);  
		
		List<Atleta> atletas = ar.findAll();
		mv.addObject("atletas", atletas);
		
		//List<Partida> partida = pr.findAll();
		//List<Partidas> partidas = psr.findAll();
		//mv.addObject("partidas", partidas);  
		
		//System.out.println(" "+ partida);
		//System.out.print(" "+ partidas);
		//PROVISORIAMENTE APENAS PARA TESTAR O FRONT!!
		//Iterable<PartidaPK> partidaPK = pr.findAll();
		//mv.addObject("partidas",partidaPK);
		//torneio.getPartidas? - Vai ser necessario a remodelação do banco
		//Adicionei valores fantasia pelo data.sql mas na pratica nao sera assim
		//adicionar a entidade partidas no torneio, ou partidas de grupo
		//em fim, poderia ter partidas e na partida especificar o tipo da partida
		//ver isso urgente 
		/*


//
	<form th:each="partidas : ${torneio.partidas}" method="post">
		<div class="row">
			<h5>Chaves</h5>
			<div class="input-field col s12">
				<span>jogador1</span>
				<label for="nome">pontos: </label> <input type="number"
					th:value="" name="nome" />
			</div>
			<div class="input-field col s12">
				<span>jogador2</span>
				<label for="nome">pontos: </label> <input type="number"
				th:value="" name="nome" />
			</div>
		</div>
	</form>

	//logica das chaves que o murillo implementou
	partida (PARTIDA)
		partidaPK (CHAVE)
			partidas  (SETS)
				torneio -> sets pertencem a um torneio, verificar esse campo


//nessa logica primeiro eu tenho que salvar todos os pontos de todos os sets
//de uma vez, ao final da partida eu tenho que inserir todos os pontos de uma
//vez, dai eu gero uma chave, verificar essa lógica...
//porque primeiro o programa deveria dizer com quem o atleta vai jogar
//depois o organizador colocaria os pontos no programa, e ele calcularia o vencedor
//da chave pra gerar uma proxima chave, nesse caso nao consigo gerar chaves sem 
//pontos
 
 
		 * */
		
		//ele nao aceita criar uma 'partidas' sem totalização de ponto, 
		//ao posso que ele nao aceita criar partida sem partidas 
		
		
		//verificar a possibilidade de trocar mapemento, ja que é onetoone, mas esta mapeado com onetomany
		//mesmo assim manter onetomany, mas trocar para manytoone?

//partidaPK nao tem identificador de atleta, nao sei qual atleta marcou qual ponto
		return mv;
	}
}
