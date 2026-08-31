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
  atividades?: Atividade[]
  riscos?: Risco[]
}

export interface Risco {
  id?: number
  descricao?: string
  severidade?: string
}
