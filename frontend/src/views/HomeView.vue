<script setup lang="ts">
import { ref, onMounted } from 'vue'
import api from '../services/api'
import { Projeto } from '../types'

//variável responsável por guardar os projetos
const projetos = ref<Projeto[]>([])

const buscarProjetos = async () => {
  try {
    //Aqui tenta fazer o get em http://localhost:8080/api/projetos
    const resposta = await api.get('/api/projetos')
    projetos.value = resposta.data
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
      </li>
    </ul>
  </div>
</template>
