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

	v2/na persistencia do banco controller alterar para nao salvar com cpf invalido?
	v2/melhorar rotas de clube	
	v2/-futuramente implementar 1-n organizador
	v2/-furutametne organizador so pode alterar seu torneio	
	rever/-subir no heroku
	v2- /-Criar template /error
	- timeout/-verificar dto ..


https://www.4devs.com.br/gerador_de_cnpj
https://bcrypt-generator.com/

 */