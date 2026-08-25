export interface Atividade {
  id?: number
  titulo?: string
  status: boolean
}

export interface Projeto {
  id?: number
  nome?: string
  descricao: string
  dataCriacao: string
  dataUltimaModificacao: string
}

export interface Risco {
  id?: number
  descricao?: string
  severidade?: string
}
