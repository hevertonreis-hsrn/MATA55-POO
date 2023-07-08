#Classe Aplicação
from CadastroImoveis import CadastroImoveis
from CadastroProprietario import CadastroProprietario
from Estados import Estados
from Imovel import Imovel
from Proprietario import Proprietario


def entradaEndereco():
    global rua
    rua = str(input("Informe a Rua:"))
    global numero
    numero = str(input("Informe o Número:"))
    global cep
    cep = str(input("Informe o CEP:"))

    estadoValido = False

    while not estadoValido:
        uf = str(input("Informe o Estado:"))
        # uf = uf.toUpperCase();

        for estados in (Estados):
            if uf == estados.value:
                estadoValido = True
                global estado
                estado = estados.value
                break

        if not estadoValido:
            print("Estado Inválido!")

    global cidade
    cidade = str(input("Informe a Cidade:"))

def cadastrarImovel(cdImoveis):
    print("Você entrou no método de Cadastro de Imóveis.")
    numIPTU = int(input("Informe o IPTU (Apenas números):"))

    i = cdImoveis.buscarImovel(numIPTU);

    if i == None:
        entradaEndereco()
        tipo = str(input("Informe o Tipo do Imóvel"))
        utilizacao = str(input("Informe a Utilização:"))

        imovel = Imovel(numIPTU, rua, numero, cep, estado, cidade, tipo, utilizacao)

        cdImoveis.adicionarImovel(imovel)

        print("Imóvel Cadastrado!")
    else:
        print("Já existe um Imóvel cadastrado com este IPTU!")

def cadastrarProprietario(cdProprietarios, cdImoveis):
    print("Você entrou no método de Cadastro de Proprietário.")
    nome = str(input("Informe o Nome:"))
    cpf = str(input("Informe o CPF:"))

    p = cdProprietarios.buscarProprietario(cpf)

    if p == None:
        entradaEndereco()
        identidade = str(input("Informe a Identidade:"))

        p = Proprietario(nome, cpf, identidade, rua, numero, cep, estado, cidade);

        print('''Deseja adicionar um Imóvel?");
            [0] NÃO"
            [1] SIM''');

        opcao = int(input("Opção: "))

        if opcao == 0:
            print("Tudo bem, é possível adicionar depois através do menu.")
        elif opcao == 1:
            print("Primeiro vamos verificar se o Imóvel já existe em nossos registros.")
            numIPTU = int(input("Informe o IPTU (Apenas números):"))

            imovel = cdImoveis.buscarImovel(numIPTU)

            if imovel == None:
                print("Imóvel não encontrado.")
                print("Cadastre o Imóvel e adicione aos registros do Proprietário posteriormente.")
            else:
                p.adicionarImovel(imovel)
                print("Imóvel Adicionado!")

        cdProprietarios.adicionarProprietario(p)
        print("Proprietário Cadastrado!")
    else:
        print("Já existe um Proprietário cadastrado com este CPF!")


class Aplicacao:

  cdImoveis = CadastroImoveis()
  cdProprietarios = CadastroProprietario()

  opcao = -1
  while opcao != 0:
    print('''\tBem Vindo ao LocaNet! Selecione uma opção abaixo.
        0. Sair
        1. Cadastrar Imóvel
        2. Cadastrar Proprietário
        3. Associar Imóvel à Proprietário
        4. Pesquisar Valor de Referência do Aluguel
        5. Pesquisar Valor de Referência do Aluguel com Sazonalidade
        6. Adicionar Data Disponível para Aluguel
        7. Verificar Disponibilidade para Aluguel
        8. Verificar Valor do Aluguel
        Opcao:''')
    opcao = int(input())
    if opcao == 1:
      cadastrarImovel(cdImoveis)
    if opcao == 2:
        cadastrarProprietario(cdProprietarios, cdImoveis)