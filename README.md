# Gestão de Informação e Navegação Indoor numa Universidade

Neste projeto pretende-se que os alunos modelizem, implementem, testem e documentem
uma aplicação Java para manipular e gerir informação relativa a uma Universidade (e.g.
pessoas e respetivos horários), bem como utilizar a informação para navegação indoor na
Universidade (e.g. rede de pontos representando o mapa indoor de um edifício da
Universidade). Mais concretamente, pretende-se que combinem a utilização de estruturas de
dados orientadas a objetos (e.g. tabelas de símbolos e grafos) para armazenar e gerir a
informação necessária.
As estruturas do tipo Symbol Table (e.g. Hashmaps, Binary Search Trees, Redblack Trees,
etc.) deverão permitir armazenar e gerir a informação relativa às entidades que se pretendem
manipular (e.g. alunos, professores, turmas, salas, unidades curriculares). Por exemplo, para
cada aluno e professores, deve registar-se as suas UCs (Unidade Curriculares) e respetivo
horário, professores de uma determinada UC e horários de atendimento. As salas devem ter
um horário de ocupação. Os alunos devem conseguir saber o horário de atendimento de um
professor e o caminho mais curto até ao seu gabinete. Para isso deve ser carregada toda a
informação da infraestrutura, como salas e pisos.
Deverão utilizar diferentes estruturas do tipo grafo para armazenar a informação relativa à
infraestrutura do mapa. Nesse mapa deve ser possível representar os diferentes pisos,
salas/gabinetes e respetivas ligações. No grafo de localização/caminhos, os vértices
correspondem, por exemplo, a entradas de uma sala, meio do hall, entrada do edifício,
topo/fundo de uma escada e Pontos de Passagem (PdP – pontos simples para ligação entre
outros vértices), estes terão diferentes categorias como, por exemplo, topo/fundo de uma
escada, pisos de um elevador, meio do hall e servirão para conectar pontos do grafo, (e.g.
conectar o fundo das escadas do piso 1 ao topo das escadas do piso 1 de forma a ser possível
descer para o piso 0). Esses vértices poderão ter um conjunto de ligações (arestas) a outros
vértices. As ligações poderão caracterizar-se por vários pesos (e.g., distância, tempo, etc.).
Cada piso será um subgrafo do grande grafo correspondente a todo o edifício. A navegação
será efetuada através dos pontos descritos anteriormente.
Embora a solução pudesse utilizar uma arquitetura cliente-servidor, para facilitar a
implementação, irá utilizar-se uma arquitetura standalone, ou seja, uma implementação que
deverá funcionar num único PC. Os alunos deverão utilizar pacotes de software pré-existentes
que oferecem estruturas de dados genéricas (cf. grafos, árvores, tabelas de símbolos etc.),
que possam ser reutilizadas na implementação do problema proposto. Desta forma não terão
que implementar as estruturas de dados básicas, podendo concentrar-se na lógica e
requisitos funcionais da aplicação proposta.

## Requisitos Funcionais

Pretende-se que os alunos sigam uma abordagem orientada aos objetos na modelização e
implementação do problema proposto. Em concreto deverão desenhar os diagramas de
classes necessários que permitam modelizar o problema, reutilizando pacotes/classes pré-existentes (cf. grafo, árvores, hashmap, etc.) através de herança, composição ou agregação.
Pretende-se que desenvolvam um package de classes com várias funcionalidades úteis à
implementação do problema proposto e que satisfaçam os requisitos listados a seguir.
Pretende-se, também, que se implementem casos de teste desse package para cada um dos
requisitos. As funções de teste devem ser responsáveis por chamar todos os métodos
necessários que demonstrem a correta funcionalidade de cada um dos requisitos. Cada caso
de teste deverá ser devidamente documentado numa função static que deverá ser
caracterizada pelo conjunto de funções a testar, pelos valores de input a utilizar no teste
(preferencialmente de ficheiro ou, em alternativa, editando diretamente o código, mas nunca
provenientes de valores interactivamente inseridos pelo utilizador), e por valores de
output/resultado do teste enviados para a consola e/ou escritos em ficheiro.