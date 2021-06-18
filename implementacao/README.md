## Instruções e informações gerais
### Hope - Web Application


*Os arquivos nesta pasta incluem as classes que possuem relação com os casos de uso selecionados, arquivos de configuração foram omitidos.*


### Estrutura hierárquica dos pacotes:
## hope-api
* src/main/java/br/com/fatec/ads/es:
	* [x] hopeapi
		* [x] hopeapi.controller
		* ~~hopeapi.dto~~
		* [x] hopeapi.model
		* [x] hopeapi.repository
		* [x] hopeapi.service
	
- src/main/resources/
	- ~~static~~
	- templates
      - [x] animal
	  - ~~cadasro~~
	  - [x] parceiro
	  - [x] pet
	  - [x] usuario
	- [x] base.html
	- [x] home.html
	- [x] login.html
	- [x] sobre.html
	* ~~application.properties~~
	* ~~messages.properties~~
	
### Observações
	Conforme conversado durante a aula, o projeto inicialmente estava sendo desenvolvido com autenticação e para implementar o CRUD com a integração no banco de dados e com as sugestões da aula, não foi possível seguir, por enquanto, nessa linha. Para isso, as classes que implementam o CRUD de configuração e Condução foram refeitas de forma a implementar da maneira mais simples possível o ciclo de vida de um cadastro.

### Instruções
1. A aplicação é iniciada a partir da classe HopeApiAplication:
![](https://i.imgur.com/6pwhsIu.png)

2. A aplicação apresentará uma lista de animais diferentes a cada acesso ou atualização.

3. Para ter acesso aos menus internos da aplicação, o parceiro efetua a autenticação:
![](https://i.imgur.com/qNhKhGb.png)

4. Para acessar uma das ações de gerenciamento, o parceiro seleciona a opção Gerenciar Pets
![](https://i.imgur.com/doI2JsF.png)

5. Ao acessar a opção Gerenciar Pets, a aplicação apresentará a relação dos animais cadastrados
![](https://i.imgur.com/1k64owF.png)

6. Para acessar a opção Gerenciar Parceiros, a aplicação não apresenta o acesso diferenciado do Administrador (ainda), mas a aplicação apresentará ao Admnistrador devidamente autenticado:
![](https://i.imgur.com/25ohtIa.png)


### Nota
	O protótipo pode ser acessado no link e as interfaces do protótipo serão atualizadas atendendo às mudanças realizadas ao longo do projeto.
  
  [Protótipo no MarvelApp](https://marvelapp.com/prototype/2a1iieb6)
  
### Considerações finais
	Algumas classes foram descritas como "experimentais" e representam as classes do projeto inicial que utilizavam o usuário autenticado realizando as ações.
	Para essas classes, o código apresentará uma informação para reafirmar que não está completa e que uma nova classe foi criada para efetivamente implementar os CRUDs 
	requisitados neste projeto.