from datetime import datetime
from Agenda import Agenda
from Endereco import Endereco


class Imovel:

  def __init__(self, numIPTU, rua, numero, cep, estado, cidade, tipo, utilizacao):
    self.numIPTU = numIPTU
    if estado == "":
      estado = "BA"
    if cidade == "":
      cidade = "Salvador"
    self.endereco = Endereco(rua, numero, estado, cidade, cep)
    self.tipo = tipo
    self.utilizacao = utilizacao
    self.agenda = Agenda()

  def getNumIPTU(self):
    return self.numIPTU

  def getTipo(self):
    return self.tipo

  def parseStringData(self, data):

    date = datetime.strptime(data, '%d/%m/%Y')

    return date

  def adicionarDataDisponivel(self, data):

    d = self.parseStringData(data)
    if not self.agenda.compararDatasBloqueado(d):
      if not self.agenda.compararDatasAlugado(d):
        if not self.agenda.compararDatasDisponivel(d):
          self.agenda.setDataDisponivel(d)
          self.agenda.ordenarDatasDisponiveis()
          return True
        print("Data [" + d + "] já cadastrada!")
        return False
      print("O imóvel se encontra [alugado] na data inserida!")
      return False
    print("O imóvel se encontra [bloqueado] na data inserida!")
    return False

  def toString(self):
    print("============ Dados do Imóvel ===========")
    print("IPTU: ", end='')
    print(self.numIPTU)
    print("Tipo: ", end='')
    print(self.tipo)
    print("Utilização: ", end='')
    print(self.utilizacao)
    self.endereco.toString()