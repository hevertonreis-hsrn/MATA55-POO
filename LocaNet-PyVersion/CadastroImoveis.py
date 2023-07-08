#Classe CadastroImóveis
class CadastroImoveis:

  def __init__(self):
    self.cadastro = []

  def adicionarImovel(self, imovel):
    self.cadastro.append(imovel)

  def buscarImovel(self, numIPTU):
    for imovel in self.cadastro:
      if imovel.getNumIPTU() == numIPTU:
        return imovel
      return None