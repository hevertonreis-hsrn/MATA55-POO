#Classe Endereço
class Endereco:
  def __init__(self, rua, numero, estado, cidade, cep):
    self.rua = rua
    self.numero = numero
    self.cidade = cidade
    self.estado = estado
    self.cep = cep

  def toString(self):
    print("============ Endereço ===========")
    print("Logradouro: ", end='')
    print(self.rua)
    print("Número: ", end='')
    print(self.numero)
    print("CEP: ", end='')
    print(self.cep)
    print("Estado: ", end='')
    print(self.estado)
    print("Cidade: ", end='')
    print(self.cidade)