# language: pt

  Funcionalidade: retorno get da Api
    Cenario: devo consumir uma api rest rest
      Dado passa o paramentro ola
      Quando execultado recebe o valor ok
      Entao retorna o valor Ola Mundo!

    Cenario: retornando Usuario-01
      Dado o valor users1
      Quando execultado recebe sucesso
      Entao retorna nome e idade do usuario

    Cenario: retornando Usuario-02
      Dado o valor users2
      Quando execultado com sucesso recebe usuario2
      Entao retorna nome, idade, endereco e salary

    Cenario: retorna Usuario-03
      Dado o valor users3
      Quando execultado com sucesso recebe usuario3
      Entao retorna nome, idade e seus filhos

    Cenario: usuario inexistente
      Dado o valor inixistente
      Quando execultado recebe o valor Not Found
      Entao retorna Usuário inexistente

    Cenario: retorna todos os usuarios
      Dado o valor users
      Quando execultado recebe o valor de todos usuarios
      Entao retorna todos os usuarios com suas reséctivas informação