#Classe Imóvel
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

  def toString(self):
    print("============ Dados do Imóvel ===========")
    print("IPTU: ", end='')
    print(self.numIPTU)
    print("Tipo: ", end='')
    print(self.tipo)
    print("Utilização: ", end='')
    print(self.utilizacao)
    self.endereco.toString()