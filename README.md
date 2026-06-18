# 2026-prog2-trabalho-PainelAdocao

## 1. Descrição do Projeto
Este projeto consiste num **Painel de Adoção de Animais**, desenvolvido como requisito avaliativo para a disciplina de Programação 2. A aplicação foi criada utilizando exclusivamente a biblioteca gráfica **Java Swing** e segue os padrões de Programação Orientada a Objetos (POO), organização em pacotes e separação de responsabilidades.

O sistema permite que uma ONG de proteção animal faça a gestão de forma prática do cadastro de animais disponíveis, visualize perfis por meio de uma galeria interativa de fotos e registe os adotantes interessados, realizando o vínculo direto de adoção e atualizando os status em tempo real.

---

## 2. Integrantes do Grupo
Desenvolvido exclusivamente para fins acadêmicos por [Erick Tiepo](https://github.com/ErickTiepo) e [Victor Hugo de Souza Mendes](https://github.com/victorhugosilva371-netizen).

---

## 3. Arquitetura e Organização do Código
O projeto está estruturado de forma limpa em pacotes, garantindo fácil manutenção e legibilidade:
* `br.edu.bsi.prog2.paineladocao` : Contém a classe principal de inicialização do sistema.
* `br.edu.bsi.prog2.paineladocao.model` : Classes de entidade que representam o domínio do problema (`Animal` e `Adotante`).
* `br.edu.bsi.prog2.paineladocao.service` : Classes de serviço e integração com APIs externas (`ViaCepService`).
* `br.edu.bsi.prog2.paineladocao.view` : Interfaces gráficas do utilizador (`TelaLogin`, `TelaPrincipal`, `CardAnimal`, `DialogFichaAnimal`).

---

## 4. Funcionalidades Implementadas

### 🔓 Tela de Login
* Interface inicial para autenticação do utilizador antes do acesso ao painel principal do sistema.

### 🐾 Aba 1: Cadastro e Gestão de Animais
* **Formulário Completo:** Entrada de dados utilizando componentes específicos como `JTextField` (Nome), `JSpinner` (Idade), `JRadioButton` (Porte Pequeno, Médio e Grande) e `JCheckBox` agrupados para o Temperamento (Dócil, Brincalhão, Independente, Sociável com Crianças/Animais).
* **ComboBox Encadeado Dinâmico:** Seleção de Espécie (Cachorro/Gato) que atualiza automaticamente a lista de Raças correspondente num segundo `JComboBox`.
* **Upload de Fotos:** Integração com `JFileChooser` permitindo carregar imagens locais, que são redimensionadas dinamicamente para exibição num `JLabel`.
* **Operações CRUD e Validações:** Botões para **Salvar** e **Excluir** registos com tratamento de campos vazios via `JOptionPane`.
* **Tabela de Gestão:** `JTable` sincronizada exibindo Nome, Espécie, Status e o Adotante vinculado.

### 🖼️ Aba 2: Galeria Interativa
* **Grade de Fotos (GridLayout):** Painel dinâmico embutido num `JScrollPane` que gera automaticamente "cards" visuais para cada animal cadastrado na memória.
* **Ficha de Detalhes (JDialog):** Ao clicar em qualquer card da galeria, o sistema abre uma janela de diálogo (`DialogFichaAnimal`) exibindo o perfil completo do animal, a sua foto e o nome do seu adotante atual.

### 👥 Aba 3: Cadastro de Adotantes e Vínculo de Adoção
* **Formulário de Cadastro:** Captura de dados pessoais com máscaras de validação em campos `JFormattedTextField` (CPF e Telefone).
* **Integração com API Externa (Bónus):** Consumo da API pública ViaCEP. Ao digitar o CEP e clicar em "Buscar CEP", o sistema autocompleta os campos de Cidade, Bairro e Rua de forma automática.
* **Lógica de Adoção:** Um `JComboBox` dinâmico lista todos os animais cadastrados. Ao associar um animal a um adotante e salvar, o sistema altera automaticamente o status do bicho para "Adotado" e grava o nome do tutor na tabela de gestão de animais.
* **Exclusão com Reversão:** Ao excluir um adotante da lista, o animal que estava vinculado a ele volta automaticamente a ficar com o status "Disponível".

### 📋 Menu e Navegação
* `JMenuBar` fixo no topo da aplicação com a opção "Arquivo -> Sair", contendo caixa de confirmação de saída (`JOptionPane.showConfirmDialog`).

---

## 5. Instruções para Compilar e Executar

### Pré-requisitos
* Java JDK 17 ou superior instalado.
* Apache Maven instalado e configurado nas variáveis de ambiente.

### Passos para Execução via Terminal
Execute os comandos abaixo sequencialmente no terminal para clonar, compilar e rodar a aplicação:

```bash
git clone https://github.com/ErickTiepo/2026-prog2-trabalho-PainelAdocao.git
cd 2026-prog2-trabalho-PainelAdocao
mvn clean package
java -jar target/PainelAdocao-1.0-SNAPSHOT.jar
