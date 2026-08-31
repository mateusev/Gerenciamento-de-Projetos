<script setup lang="ts">
import { ref, onMounted } from 'vue'
import api from '../services/api'
import type { Projeto } from '../types'

//variável responsável por guardar os projetos
const projetos = ref<Projeto[]>([])

const buscarProjetos = async () => {
  try {
    //Aqui tenta fazer o get em http://localhost:8080/api/projetos
    const resposta = await api.get('/api/projetos')
    const dados = resposta.data
    projetos.value = Array.isArray(dados) ? dados : (dados.value ?? [])
  } catch (erro) {
    console.error('Erro ao buscar projetos:', erro)
  }
}

onMounted(() => {
  buscarProjetos()
})
</script>

<template>
  <div class="home">
    <h2>Lista de Projetos</h2>

    <div v-if="projetos.length === 0" class="aviso">
      <p>Nenhum projeto encontrado.</p>
    </div>

    <ul class="lista-projetos">
      <li v-for="projeto in projetos" :key="projeto.id" class="cartao">
        <h3>{{ projeto.nome }}</h3>
        <p>
          <small>Criado em: {{ projeto.dataCriacao }}</small>
        </p>

        <p>{{ projeto.descricao }}</p>

        <p>
          <strong>Atividades:</strong> {{ projeto.atividades?.length || 0 }} |
          <strong>Riscos:</strong>
          {{ projeto.riscos?.length || 0 }}
        </p>
      </li>
    </ul>
  </div>
</template>

<style scoped>
.aviso {
  color: #666;
  font-style: italic;
}
.lista-projetos {
  list-style: none;
  padding: 0;
}
.cartao {
  border: 1px solid #ccc;
  border-radius: 8px;
  padding: 15px;
  margin-bottom: 15px;
  background-color: #f9f9f9;
}
.cartao h3 {
  margin-top: 0;
  color: #2c3e50;
}
</style>
