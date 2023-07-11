from enum import Enum

#Enum de Estados
class Estados(Enum):
  AC = "AC"
  AL = "AL"
  AP = "AP"
  AM = "AM"
  BA = "BA"
  CE = "CE"
  DF = "DF"
  ES = "ES"
  GO = "GO"
  MA = "MA"
  MT = "MT"
  MS = "MS"
  MG = "MG"
  PA = "PA"
  PB = "PB"
  PR = "PR"
  PE = "PE"
  PI = "PI"
  RJ = "RJ"
  RN = "RN"
  RS = "RS"
  RO = "RO"
  RR = "RR"
  SC = "SC"
  SP = "SP"
  SE = "SE"
  TO = "TO"

#Enum de Tipos
class TipoImovel(Enum):

  CASA= "casa"
  APTO = "apto"
  STUDIO = "studio"

#Enum de Utilizações
class UtilizacaoImovel(Enum):

  CAMPO = "campo"
  PRAIA = "praia"
  COMERCIAL = "comercial"