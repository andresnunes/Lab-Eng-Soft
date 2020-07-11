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
Trocar nascimento por idade em todas as telas, no banco e no bbackend ;-;
	OK-Nome de torneio / em torneios sediados tbm
Ordernar por data torneios. 
	OK-Ocultar ID
	OKalterar titulo cadastro>dados organizador > // clube
	OKalterar botão cadastro clube > email e cpf
	OKtransferir propriedade > botão criar um novo form em branco /mantendo o clube 


na persistencia do banco controller alterar para nao salvar com cpf invalido?
	OK-data.sql cadastrar cpf e cnpj valido porque mascaras de validação foram adicionadas
	Ok-verificar porque as validações nao correm nos formularios de edição
	OK-urgente ele nao faz update de clube corretamente em vez disso cria outro clube
	OK-tirar sombreado de memoria do input
	OK-resolver problema de id unico nos inputs
	OK-LocalDate - alterar a para dd/mm/yy para USABILIDADE
fazer contador de atletas
definir oq ue vai ser feito com formorganizador
melhorar rotas de clube	
arrumar mensagem flutuante de aviso
	OK arrumar mensagens de validação
permitir alterar organizador pelo formulario do clube
	nao pode ser feito 	/-Criar template /error
	inviavel para esta release/-fazer detalhes club, onde aparece organizador e torneios sediados
	OK-fazer ficha de atleta, quantos torneios ganhou e quantos torneios participou
-fazer hall de torneios para clube também poder cadastrar seus atletas em torneios de terceiros
	OK--criar a edição de organizadores
	OK- deixar os mapeamentos  coerentes
	OK-arrumar o design
	OK-testar todas as validações
	-implementar controller form > FOI IMPLEMENTADO NO LOGIN PARA USAR AS VALIDAÇÕES PARA LOCAR COM EMAIL E SENHA de organizador
	timeout/-verificar dto ..
-pesar na lógica de inabilitar botões por torneio lotado de atleta
-logica de inabitar demais botões como excluir torneio em andamento, excluir atleta de torneio em andamento
	OK-definir mascaras para os inputs restrições
	
Links interessantes
https://www.4devs.com.br/gerador_de_cnpj
https://blog.caelum.com.br/entendendo-o-serialversionuid/
		https://www.it-swarm.dev/pt/spring/thymeleaf-mostra-o-texto-se-o-atributo-e-propriedade-existirem/1043677425/ 
		https://pt.stackoverflow.com/questions/192115/como-limitar-um-input-do-tipo-number-para-apenas-3-caracteres
//GERAR LISTAGEM https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html	
//https://stackoverflow.com/questions/24256051/delete-or-put-methods-in-thymeleaf
https://auth0.com/blog/automatically-mapping-dto-to-entity-on-spring-boot-apis/	
http://www.fidelis.work/chega-de-gambeta-como-validar-cnpj-e-cpf-corretamente/

 */