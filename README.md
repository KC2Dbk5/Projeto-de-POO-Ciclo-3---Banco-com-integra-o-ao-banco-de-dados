Como Executar o Projeto com Banco de Dados PostgreSQL

Este documento explica como configurar e executar o projeto em Java, integrando-o ao banco de dados PostgreSQL.

Requisitos

Java Development Kit (JDK)

Baixe e instale o JDK (versão 8 ou superior).

Link de download: https://www.oracle.com/java/technologies/javase-jdk-downloads.html

IDE para Desenvolvimento

Use uma IDE como IntelliJ IDEA, Eclipse, ou VS Code.

IntelliJ IDEA: https://www.jetbrains.com/idea/download/

Eclipse: https://www.eclipse.org/downloads/

VS Code: https://code.visualstudio.com/

PostgreSQL

Instale o PostgreSQL no sistema.

Link de download: https://www.postgresql.org/download/

Driver JDBC para PostgreSQL

Baixe o driver JDBC (arquivo .jar) para o PostgreSQL.

Link de download: https://jdbc.postgresql.org/download.html

Configuração do Banco de Dados

Configure o banco conforme descrito na seção Configuração do Banco de Dados.

Configuração do Banco de Dados

Criar o Banco de Dados

Acesse o terminal ou a ferramenta de gerenciamento do PostgreSQL (como o pgAdmin).

Execute o seguinte comando para criar o banco de dados:

CREATE DATABASE seu_banco;

Criar as Tabelas

Conecte-se ao banco criado e execute o seguinte script SQL:

CREATE TABLE contas (
    numero VARCHAR(20) PRIMARY KEY,
    saldo FLOAT NOT NULL
);

CREATE TABLE conta_normal (
    numero VARCHAR(20) PRIMARY KEY,
    FOREIGN KEY (numero) REFERENCES contas (numero)
);

Configurar as Credenciais

Atualize as informações de conexão ao banco de dados na classe AcessoADado:

private static final String URL = "jdbc:postgresql://localhost:5432/seu_banco";
private static final String USUARIO = "seu_usuario";
private static final String SENHA = "sua_senha";

Configuração do Ambiente Java

Importar o Projeto na IDE

Abra sua IDE e importe o projeto Java.

Certifique-se de que todas as classes (Banco, Conta, AcessoADado, etc.) estão organizadas no pacote apresentacao.

Adicionar o Driver JDBC

Adicione o arquivo .jar do driver PostgreSQL ao classpath do projeto:

Em IntelliJ IDEA:

Clique com o botão direito no projeto > Open Module Settings.

Adicione o arquivo .jar em Libraries.

Em Eclipse:

Clique com o botão direito no projeto > Build Path > Add External Archives.

Como Executar o Projeto

Verifique as Configurações

Certifique-se de que o PostgreSQL está em execução.

Verifique as credenciais configuradas na classe AcessoADado.

Executar o Código

Execute a classe Banco que contém o método main.

Exemplos de operações que serão realizadas:

Cadastro de contas.

Atualização de saldos.

Listagem de contas no console.

Exemplo de Saída no Console

Conta cadastrada com sucesso.
Conta normal cadastrada com sucesso.
Número: 1234-5, Saldo: 1000.0

Links Importantes

JDK: https://www.oracle.com/java/technologies/javase-jdk-downloads.html

IntelliJ IDEA: https://www.jetbrains.com/idea/download/

Eclipse: https://www.eclipse.org/downloads/

PostgreSQL: https://www.postgresql.org/download/

Driver JDBC PostgreSQL: https://jdbc.postgresql.org/download.html

Observações

Caso encontre erros de conexão, verifique se o PostgreSQL está configurado para aceitar conexões externas e se a porta padrão (5432) está liberada.

Certifique-se de que as dependências do projeto estão configuradas corretamente na IDE.
