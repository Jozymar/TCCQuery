# TCCQuery
## Sistema para Armazenar TCCs na WEB com Persistência Poliglota 

### Projeto da Disciplina de Banco de Dados não Convencionais.

Usuários logados e autenticados dispõe da possibilidade de salvar seu TCC (
Trabalho de Conclusão de Curso) na WEB. O sistema usa vários bancos de dados __(DBs)__: 
__Relacional - PostgreSQL__, __Documento - MongoDB - NoSQL__, __Grafo - Neo4j__ e 
__Chave-Valor - Redis__. O sistema dispõe de um mecanismo de busca de TCCs por ano, 
título, resumo, palavras-chave, autor e conteúdo; e de um sistema de sugestões de TCCs 
com referência a similaridade da pesquisa.