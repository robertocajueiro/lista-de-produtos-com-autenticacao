# Lista de produtos utilizando acesso com autenticação
Criar um recurso rest de lista de Produtos utilizando autenticação oauthe2 JWT 

- Criar o modelo de classe e o repositorio;

- Criar tabela com um esquema de versionamento com Flyway
	- V001_cria_tabela_produto
	- popular a tabela com arquivo import.sql
	- add o campo quantidade
	
- Criar o recurso para listar, salvar, atualizar e deletar produto.
	- listando produtos na API. Ok!

![image](https://user-images.githubusercontent.com/28118980/217341295-a7362699-b010-4ca7-a305-30d4b92c79c9.png)

- Criar Modelagem da entidade usuário.
- Criar API de Registro de Usuários

- Adicionando as dependências de segurança do spring boot
	- OBSERVAÇÃO: precisei fazer um downgrade do projeto do spring boot 3.0.2 para 2.7.8 a versão atual
	não funcionou a herança da classe WebSecurityConfigurerAdapter. Precisei refatorar todos os import de
	jakarta para javax persistence. Em outro momento tentarei utilizar a versão mais atualizada.
	
- Após aplicar as dependências

![image](https://user-images.githubusercontent.com/28118980/217396816-6cb1b844-a033-42ea-80e8-799ba38382fe.png)
 

