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
	OK-Front partidas testar com valores fantasia
	OK-Preencher o banco com atletas validos com cpfs validos, clubes existentes 
na persistencia do banco controller alterar para nao salvar com cpf invalido?
	OK-fazer contador de atletas
melhorar rotas de clube	
	OK-fazer hall de torneios para clube também poder cadastrar seus atletas em torneios de terceiros
	OK-pesar na lógica de inabilitar botões por torneio lotado de atleta
-logica de inabitar demais botões como excluir torneio em andamento, excluir atleta de torneio em andamento	
	OK-um torneio nao pode ser inserido com uma data anterior a sua criação
	OK-um atleta nao pode ter 600 anos
-futuramente implementar 1-n organizador
-furutametne organizador so pode alterar seu torneio	
-torneios vencidos pora atletas filiados ao clube	
-subir no heroku
	OK-fazer logica pra nao deixar de cadastrar mais de X atletas por torneio	
		- mensagem verifique os campos por enquanto/fazer mensagem para campo de senha nao pode ser vazio
		- nao pode ser feito, pesquisar depois/-Criar template /error
		- inviavel para esta release/-fazer detalhes club, onde aparece organizador e torneios sediados
		- timeout/-verificar dto ..


https://www.4devs.com.br/gerador_de_cnpj

 */