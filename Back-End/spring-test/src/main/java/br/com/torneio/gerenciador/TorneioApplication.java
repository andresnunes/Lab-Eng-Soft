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
-revisitar e otimizar os controllers, fazer funções para comandos repetidos
-revisitar todas as mensagens de aviso e fazer personalizada pra cada campo de inserção
Front partidas testar com valores fantasia
Preencher o banco com atletas validos com cpfs validos, clubes existentes 
na persistencia do banco controller alterar para nao salvar com cpf invalido?
fazer contador de atletas
melhorar rotas de clube	
-fazer hall de torneios para clube também poder cadastrar seus atletas em torneios de terceiros
-pesar na lógica de inabilitar botões por torneio lotado de atleta
-logica de inabitar demais botões como excluir torneio em andamento, excluir atleta de torneio em andamento	
-um torneio nao pode ser inserido com uma data anterior a sua criação
-um atleta nao pode ter 600 anos
-futuramente implementar 1-n organizador
-furutametne organizador so pode alterar seu torneio	
-torneios vencidos pora atletas filiados ao clube	
-subir no heroku
-fazer logica pra nao deixar de cadastrar mais de X atletas por torneio
	
		- mensagem verifique os campos por enquanto/fazer mensagem para campo de senha nao pode ser vazio
		nao pode ser feito, pesquisar depois/-Criar template /error
		inviavel para esta release/-fazer detalhes club, onde aparece organizador e torneios sediados
		timeout/-verificar dto ..
	OKmandar print tela Clube input travado
	OKformClube, Clube - nao aparece mensagem
	OKnome Login tem que ocupar a linha toda
	OK-logica para email cpf e ecnpj existente em todas as telas
	OK-Trocar nascimento por idade em todas as telas, no banco e no bbackend ;-;
	OK-Nome de torneio / em torneios sediados tbm
	OK-Ordernar por data torneios. 
	OK-Ocultar ID
	OKalterar titulo cadastro>dados organizador > // clube
	OKalterar botão cadastro clube > email e cpf
	OKtransferir propriedade > botão criar um novo form em branco /mantendo o clube 
	OKimplementar função de verificação de cpf existente e cnpj existente em todos os saves e updates / atleta, clube e organizador
	OK-data.sql cadastrar cpf e cnpj valido porque mascaras de validação foram adicionadas
	Ok-verificar porque as validações nao correm nos formularios de edição
	OK-urgente ele nao faz update de clube corretamente em vez disso cria outro clube
	OK-tirar sombreado de memoria do input
	OK-resolver problema de id unico nos inputs
	OK-LocalDate - alterar a para dd/mm/yy para USABILIDADE
	OKdefinir oq ue vai ser feito com formorganizador
	OKarrumar mensagem flutuante de aviso
	OK arrumar mensagens de validação
	OKpermitir alterar organizador pelo formulario do clube
	OK-fazer ficha de atleta, quantos torneios ganhou e quantos torneios participou
	OK--criar a edição de organizadores
	OK- deixar os mapeamentos  coerentes
	OK-arrumar o design
	OK-testar todas as validações
	OK-implementar controller form > FOI IMPLEMENTADO NO LOGIN PARA USAR AS VALIDAÇÕES PARA LOCAR COM EMAIL E SENHA de organizador
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
https://lptennis.com/home
 */