package br.com.torneio.gerenciador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TorneioApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TorneioApplication.class, args);
	}
}
/* CHECK LIST
-Criar template /error
-fazer detalhes club, onde aparece organizador e torneios sediados
OK-fazer ficha de atleta, quantos torneios ganhou e quantos torneios participou
-fazer hall de torneios para clube também poder cadastrar seus atletas em torneios de terceiros
-criar a edição de organizadores
- deixar os mapeamentos  coerentes
- converter os controles pra restcontroller(), acho que o motivo que não tá dando certo é que, precisa retornar uma url no json e eu não sei fazer isso nessa versão do spring que estamos usando
-arrumar os formulários de edição pra PUT, em vez de post
-arrumar o design
-testar todas as validações
-implementar controller form e dto ..
-fazer tela de detalhamento torneios particulados e torneios vencidos por atleta
-pesar na lógica de inabilitar botões por torneio lotado de atleta
-logica de inabitar demais botões como excluir torneio em andamento, excluir atleta de torneio em andamento
 */