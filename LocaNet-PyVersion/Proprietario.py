#Classe Proprietário
from Endereco import Endereco


class Proprietario:

  def __init__(self, nome, cpf, identidade, rua, numero, cep, estado, cidade):
    self.nome = nome
    self.cpf = cpf
    self.identidade = identidade
    self.endereco = Endereco(rua, numero, estado, cidade, cep)
    self.imoveis = []

  def getCpf(self):
    return self.cpf

  def atualizaEndereco(self, rua, numero, cep, estado, cidade):
    self.endereco.rua = rua
    self.endereco.numero = numero
    self.endereco.cep = cep
    if estado != "":
      self.endereco.estado = estado
    if cidade != "":
      self.endereco.cidade = cidade

  def adicionarImovel(self, imovel):
    self.imoveis.append(imovel)

  def listarImovelPorTipo(self, tipo):
    for imovel in self.imoveis:
      if imovel.getTipo() == tipo:
        imovel.toString()

  def toString(self):
    print("============ Dados do Proprietário ===========")
    print("Nome: ", end='')
    print(self.nome)
    print("CPF: ", end='')
    print(self.cpf)
    print("Identidade: ", end='')
    print(self.identidade)
    self.endereco.toString()
    print("============== Lista de Imóveis ==============")
    print()
    for imovel in self.imoveis:
      imovel.toString()
      print()