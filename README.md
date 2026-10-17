# Sistema de Gestão de EPIs: organização dos dados de equipamentos de proteção individual

Aplicação web desenvolvida como projeto de conclusão do curso Técnico em Desenvolvimento de Sistemas do SENAI, com o objetivo de apoiar a organização e o gerenciamento de informações relacionadas a Equipamentos de Proteção Individual (EPIs).

## 🎯 Problema de negócio

O gerenciamento de EPIs envolve informações que precisam ser organizadas e acessíveis para facilitar as rotinas operacionais. Quando esses registros não estão centralizados, o acompanhamento dos equipamentos pode se tornar mais trabalhoso.

O **Controle de EPIs** propõe uma solução de software para apoiar esse processo por meio de uma aplicação web conectada a um banco de dados relacional.

## 🏢 Contexto de uso

O sistema foi desenvolvido pensando em um cenário de uso empresarial no qual é necessário organizar informações sobre equipamentos de proteção individual.

O projeto demonstra a aplicação de conceitos de desenvolvimento web, integração com banco de dados e persistência de informações.

> Projeto acadêmico desenvolvido para fins de aprendizado e demonstração de conhecimentos técnicos.

## 🛠️ Stack tecnológica

- **Java** — linguagem de programação.
- **Spring Boot** — framework para desenvolvimento da aplicação.
- **Spring Data JPA / JPA** — persistência e acesso a dados.
- **MariaDB** — banco de dados relacional.
- **HTML5 e CSS3** — estrutura e estilos da interface.
- **Bootstrap** — componentes e layout da interface web.
- **Git e GitHub** — versionamento e hospedagem do código.

### Versões

As versões exatas de Java, Spring Boot, MariaDB e das dependências devem ser consultadas na configuração do projeto antes da publicação desta documentação.

## 📊 Resultados

O projeto resultou no desenvolvimento de uma aplicação web voltada ao gerenciamento de EPIs.

Não foram disponibilizadas métricas quantitativas verificáveis de redução de custos, tempo economizado ou aumento de produtividade. Por isso, esses resultados não são atribuídos ao projeto.

## 🚀 Como executar

### Pré-requisitos

- JDK compatível com a versão configurada no projeto.
- MariaDB instalado e em execução.
- Git instalado.

### Execução em 3 passos

**1. Clone o repositório**

```bash
git clone https://github.com/Eduardo-Silva-Mateus/Controle-de-Epis.git
cd Controle-de-Epis
```

**2. Configure o banco de dados**

Crie o banco de dados no MariaDB e configure as credenciais e a conexão nos arquivos de configuração da aplicação. Consulte o código para identificar o nome esperado do banco e os parâmetros necessários.

Não publique senhas ou credenciais reais no repositório.

**3. Execute a aplicação**

Na pasta que contém o arquivo `pom.xml`, execute:

```bash
./mvnw spring-boot:run
```

No Windows, se o projeto incluir o Maven Wrapper, utilize:

```powershell
.\mvnw.cmd spring-boot:run
```

Se o Maven Wrapper não estiver disponível, será necessário utilizar uma instalação local do Maven. Após iniciar, consulte os logs da aplicação para confirmar a inicialização e identificar o endereço de acesso.

## 📚 Objetivo de aprendizado

Este projeto faz parte da minha formação em Desenvolvimento de Sistemas e demonstra a aplicação prática de tecnologias Java, desenvolvimento web e persistência de dados.

## 👨‍💻 Autor

**Eduardo Mateus da Silva**

- GitHub: [Eduardo-Silva-Mateus](https://github.com/Eduardo-Silva-Mateus)
- LinkedIn: [eduardo-mateus-silva](https://linkedin.com/in/eduardo-mateus-silva)
