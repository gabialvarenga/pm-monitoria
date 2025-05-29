Sistema de Monitoramento de Eventos
Recentemente a Defesa Civil da cidade de Shulambs Town resolveu desenvolver um sistema de notificação de eventos chamado Defesa Civil Alerta. Há três tipos de alertas conforme sua severidade ou finalidade:  extremo, severo e aviso. O primeiro, é o nível máximo de alerta, caracterizado por ameaças extremas à vida ou à propriedade. Já o segundo, indica a necessidade de medidas de proteção. Finalmente, o aviso é apenas uma informação para que o cidadão esteja ciente de situações anormais. No caso do alerta extremo a mensagem acionará um sinal sonoro no celular, semelhante a uma sirene, ainda que o aparelho esteja no modo silencioso, o que vai permitir maior eficiência do alerta nas situações de risco. No caso do alerta severo, o sinal sonoro será um “beep” similar ao do SMS e não irá soar no modo silencioso. No caso do aviso, a mensagem será exibida em modo silencioso.

Requisitos funcionais:
O Sistema de Monitoramento de Eventos Defesa Civil Alerta precisa implementar os seguintes requisitos:

Um módulo deverá representar o cidadão e deverá ser capaz de notificar a defesa civil de alguma ocorrência em sua localidade. 
A notificação deve incluir as seguintes informações: tipo do alerta (EXTREMO, SEVERO, AVISO) e os detalhes do alerta (em modo texto).
Um modulo de publicação de alertas irá então produzir um alerta baseado no tipo de notificação recebida do cidadão.
O alerta será então exibido no console.
O sistema deverá ter um módulo central de alertas que deverá armazenar uma coleção de todos os alertas produzidos com a data e hora da notificação, o tipo do alerta e o conteúdo (detalhes).
A central de alertas deve ser capaz de gerar um relatório com a lista dos alertas produzidos em um determinado intervalo de tempo (data inicial e data final).
A central de alertas deve ser capaz de gerar o número médio de alertas por dia.
O sistema de publicação de alertas deve utilizar o padrão factory para produzir os alertas a partir das notificações.
Tarefas:
Criação do projeto:

Utilize a ferramenta Maven para construir o projeto: group ID br.lpm e Artifact ID: prova_02
Modelagem UML:

Elabore diagrama de classes UML utilizando o UMLet chamado uml-class-diagram.uxf que represente os elementos e as relações descritas acima.
Use corretamente os conceitos de associação, agregação e composição.
Adicione a navegabilidade e multiplicidade das associações.
Adicione os estereótipos quando necessário.
Identifique atributos static e final corretamente.
Não é necessário colocar getters ou setters se eles forem apenas métodos de acesso a atributos. 
Desenvolvimento do Sistema:

Implemente os requisitos projetados em Java.
Implemente um construtor com parâmetros para cada classe.
Implemente os getters e setters para validarem os dados.
Adicione os atributos adicionais que sejam porventura necessários.
Parametrize o código para evitar repetição e aumentar a legibilidade.
Certifique-se de que seu código seja eficiente e modular.
Utilize boas práticas de programação e comente seu código conforme necessário para facilitar a compreensão.
Testes Unitários:

Implemente testes unitários para garantir que os métodos e funcionalidades das classes estejam funcionando corretamente.
Escreva testes que verifiquem a correta criação dos objetos da classe e da associação entre eles.
Entrega
Entregue o trabalho no Canvas na forma de um arquivo zip contendo toda a pasta do projeto Maven. Altere o nome do arquivo para "seu nome.zip"

Observações
* Os alunos devem ser capazes de explicar os códigos submetidos. Caso o aluno utilize algum código gerado externamente e não souber explicar o código receberá 0 (zero).
Rubrica
LPM-Prova 2
Critérios	Avaliações
UML - 5 pts
Factor - 5 pts
Collections - 5 pts
Relatórios - 5 pts
POO, SOLID e qualidade de código 5 pts
Total de pontos: 25
