class CadastroProprietario:

  def __init__(self):
    self.cadastro = []

  def adicionarProprietario(self, proprietario):
    self.cadastro.append(proprietario)

  def buscarProprietario(self, cpf):
    for proprietario in self.cadastro:
      if proprietario.getCpf() == cpf:
        return proprietario
      return None