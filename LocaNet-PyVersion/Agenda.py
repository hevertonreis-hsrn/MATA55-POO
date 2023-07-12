#Classe Agenda
class Agenda:

  def __init__(self):
    self.datasDisponiveis = []
    self.datasAlugado = []
    self.datasBloqueado = []

  def setDataDisponivel(self, data):
    self.datasDisponiveis.append(data)

  def getDatasDisponiveis(self):
    return self.datasDisponiveis

  def compararDatasBloqueado(self, dataComparar):
    for data in self.datasBloqueado:
      if data == dataComparar:
        return True
    return False

  def compararDatasAlugado(self, dataComparar):
    for data in self.datasAlugado:
      if data == dataComparar:
        return True
    return False

  def compararDatasDisponivel(self, dataComparar):
    for data in self.datasDisponiveis:
      if data == dataComparar:
        return True
    return False

  def ordenarDatasDisponiveis(self):
    self.datasDisponiveis.sort(reverse=False)