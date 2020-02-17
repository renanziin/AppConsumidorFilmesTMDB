# AppConsumidorFilmesTMDB
O aplicativo consome dados de uma API REST e os mostra em um dispositivo Android. Os dados dispostos pela API são dados dos melhores filmes avaliados pelos usuários do TMDB (The Movie Data Base).

# Features

- Tela inicial que lista todos os filmes recebidos da API
- Clicar em um filme da lista abre outra tela com mais informações daquele filme
- Dados já recebidos da API são guardados em cache para caso algum erro de conexão ou de resposta da API aconteça
- Telas maiores suportam mais colunas da lista para aproveitar melhor o espaço
- O usuário é informado quando a aplicação está baixando/carregando dados através de ProgressBars
- O usuário é informado sobre erros de conexão ou de resposta da API

# Tecnologias

- Desenvolvido em Kotlin (nativo da plataforma Android)
- Implementado usando o padrão de arquitetura de software MVP
- Biblioteca Retrofit utilizada para as chamadas HTTP

# Informações da API

- Para obter a listagem dos filmes, basta realizar uma requisição HTTP utilizando o método GET no seguinte endpoint: https://desafio-mobile.nyc3.digitaloceanspaces.com/movies
- Para obter informações detalhadas de um determinado filme, basta adicionar o ID do mesmo ao final do endpoint anterior. Então se quisermos, por exemplo, obter os detalhes do filme de ID 240, basta realizar um GET no seguinte endpoint: https://desafio-mobile.nyc3.digitaloceanspaces.com/movies/240

# Referências

Aplicativo proposto como desafio pela empresa [Tokenlab - Inovação e Soluções Digitais](https://www.tokenlab.com.br/pt/).
