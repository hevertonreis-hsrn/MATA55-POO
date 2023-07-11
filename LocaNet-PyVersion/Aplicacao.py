from CadastroImoveis import CadastroImoveis
from CadastroProprietario import CadastroProprietario
from Enums import Estados, TipoImovel, UtilizacaoImovel
from Imovel import Imovel
from Proprietario import Proprietario
from datetime import datetime, timedelta


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
        uf = uf.upper()

        for estados in (Estados):
            if uf == estados.value:
                estadoValido = True
                global estado
                estado = estados.value
                break

        if not estadoValido:
            print("Estado Inválido!")
            print()

    global cidade
    cidade = str(input("Informe a Cidade:"))

def cadastrarImovel(cdImoveis):
    print("Você entrou no método de Cadastro de Imóveis.")
    numIPTU = int(input("Informe o IPTU (Apenas números):"))

    i = cdImoveis.buscarImovel(numIPTU)

    if i == None:
        entradaEndereco()

        tipoValido = False
        while not tipoValido:
          pos = 0
          tipos = []
          print("Informe o Tipo do Imóvel")
          for tipo in (TipoImovel):
              print("[ "+ str(pos) + " ] " + tipo.value)
              tipos.append(tipo.value)
              pos += 1

          opt = int(input("Opção: "))

          if (opt < 0 or opt >= len(TipoImovel)):
            print("Tipo Inválido!")
          else:
            tipo = tipos[opt]
            tipoValido = True

        utilValido = False
        while not utilValido:
          pos = 0
          utils = []
          print("Informe a Utilização do Imóvel")
          for utilizacao in (UtilizacaoImovel):
              print("[ "+ str(pos) + " ] " + utilizacao.value)
              utils.append(utilizacao.value)
              pos += 1

          opt = int(input("Opção: "))

          if (opt < 0 or opt >= len(UtilizacaoImovel)):
            print("Utilização Inválida!")
            print()
          else:
            utilizacao = utils[opt]
            utilValido = True

        imovel = Imovel(numIPTU, rua, numero, cep, estado, cidade, tipo, utilizacao)

        cdImoveis.adicionarImovel(imovel)

        print("Imóvel Cadastrado!")
        print()
    else:
        print("Já existe um Imóvel cadastrado com este IPTU!")
        print()

def cadastrarProprietario(cdProprietarios, cdImoveis):

    print("Você entrou no método de Cadastro de Proprietário.")
    nome = str(input("Informe o Nome:"))
    cpf = str(input("Informe o CPF:"))

    p = cdProprietarios.buscarProprietario(cpf)

    if p == None:
        identidade = str(input("Informe a Identidade:"))

        entradaEndereco()

        p = Proprietario(nome, cpf, identidade, rua, numero, cep, estado, cidade)

        print('''Deseja adicionar um Imóvel?")
            [0] NÃO"
            [1] SIM''')

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
        print()
    else:
        print("Já existe um Proprietário cadastrado com este CPF!")
        print()

def associarImovelProprietario(cdImoveis, cdProprietarios):

  print("Você entrou no método de Associar Imóvel à Proprietário.")
  cpf = str(input("Informe o CPF do Proprietário (Ex: 012.345.678-90):"))

  proprietario = cdProprietarios.buscarProprietario(cpf);

  if proprietario == None:
    print("Proprietário Não Encontrado.")
  else:
    numIPTU = int(input("Informe o IPTU do Imóvel (Apenas números):"))

    imovel = cdImoveis.buscarImovel(numIPTU)

    if imovel == None:
      print("Imóvel não encontrado.")
      print("Cadastre o Imóvel e adicione aos registros do Proprietário posteriormente.")
      print()
    else:
      proprietario.adicionarImovel(imovel)
      print("Imóvel Associado!")
      print()

def adicionarDataDisponivel(cdImoveis):

  print("Você entrou no método de Adicionar Data Disponível para Aluguel")
  numIPTU = int(input("Informe o IPTU do Imóvel (Apenas números):"))

  imovel = cdImoveis.buscarImovel(numIPTU)

  print('''Deseja adicionar 1 (uma) ou mais Datas? Selecione uma opção:")
    [0] uma Data
    [1] um intervalo de Datas''')

  opcao = int(input("Opção: "))

  if opcao == 0:
    print('''Informe um valor para a Data
      Ex: 15/04/1998''')

    data = str(input("Data: "))

    cadastrado = imovel.adicionarDataDisponivel(data)

    if cadastrado:
      print("Data cadastrada!")
  elif opcao == 1:
    print('''Informe um valor para a Data Inicial
      Ex: 15/04/1998''')

    data = str(input("Data: "))

    dataInicial = parseStringData(data)

    print('''Informe um valor para a Data Final
      Ex: 15/04/1998''')

    data = str(input("Data: "))

    dataFinal = parseStringData(data)

    delta = dataFinal - dataInicial

    intervalo = delta.days

    for i in range(intervalo):
      maisUmDia = timedelta(days = i)
      data = dataInicial + maisUmDia
      data = data.strftime("%d/%m/%Y")
      imovel.adicionarDataDisponivel(data)
  else:
    print("Opção inválida!")

def parseStringData(data):

    date = datetime.strptime(data, '%d/%m/%Y')

    return date

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
        4. Adicionar Data Disponível para Aluguel
        5. Verificar Disponibilidade para Aluguel
        6. Verificar Valor do Aluguel
        Opcao:''')
    opcao = int(input())
    if opcao == 1:
      cadastrarImovel(cdImoveis)
    elif opcao == 2:
      cadastrarProprietario(cdProprietarios, cdImoveis)
    elif opcao == 3:
      associarImovelProprietario(cdImoveis, cdProprietarios)
    elif opcao == 4:
      adicionarDataDisponivel(cdImoveis)
    else:
      print("Opção Inválida!")
      print()