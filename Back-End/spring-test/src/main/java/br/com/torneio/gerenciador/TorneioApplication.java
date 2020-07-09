package br.com.torneio.gerenciador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TorneioApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TorneioApplication.class, args);
	}
}
/**/

/* CHECK LIST 
	alterar organizador
	nao pode ser feito 	/-Criar template /error
	inviavel para esta release/-fazer detalhes club, onde aparece organizador e torneios sediados
	OK-fazer ficha de atleta, quantos torneios ganhou e quantos torneios participou
-fazer hall de torneios para clube também poder cadastrar seus atletas em torneios de terceiros
	OK--criar a edição de organizadores
	OK- deixar os mapeamentos  coerentes
-arrumar o design
	OK-testar todas as validações
	-implementar controller form > FOI IMPLEMENTADO NO LOGIN PARA USAR AS VALIDAÇÕES PARA LOCAR COM EMAIL E SENHA de organizador
	timeout/-verificar dto ..
-pesar na lógica de inabilitar botões por torneio lotado de atleta
-logica de inabitar demais botões como excluir torneio em andamento, excluir atleta de torneio em andamento
	OK-definir mascaras para os inputs restrições
Links interessantes
https://blog.caelum.com.br/entendendo-o-serialversionuid/
		https://www.it-swarm.dev/pt/spring/thymeleaf-mostra-o-texto-se-o-atributo-e-propriedade-existirem/1043677425/ 
		https://pt.stackoverflow.com/questions/192115/como-limitar-um-input-do-tipo-number-para-apenas-3-caracteres
//GERAR LISTAGEM https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html	
//https://stackoverflow.com/questions/24256051/delete-or-put-methods-in-thymeleaf
https://auth0.com/blog/automatically-mapping-dto-to-entity-on-spring-boot-apis/	
 */