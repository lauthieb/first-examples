<template>
  <section class="todoapp">
    <header class="header">
      <h1>Todos</h1>
      <input type="text" class="new-todo" placeholder="Ajouter une tache" v-model="newTodo" @keyup.enter="addTodo">
    </header>
    <div class="main">
      <input type="checkbox" class="toggle-all" v-model="allDone">
      <ul class="todo-list">
        <li class="todo"
            :class="{completed: todo.completed, editing: todo === editing}"
            v-for="todo in filteredTodos">
          <div class="view">
            <input type="checkbox" v-model="todo.completed" class="toggle">
            <label @dblclick="editTodo(todo)">{{todo.name}}</label>
            <button class="destroy" @click.prevent="deleteTodo(todo)"></button>
          </div>
          <input type="text" class="edit" v-model="todo.name" @keyup.enter="doneEdit" @blur="doneEdit" @keyup.esc="cancelEdit" v-focus="todo === editing">
        </li>
      </ul>
    </div>
    <footer class="footer" v-show="todos.length > 0">
      <span class="todo-count">
        <strong>{{ remaining }}</strong> tâches à faire
      </span>
      <ul class="filters">
        <li><a href="#" :class="{selected: filter === 'all'}" @click.prevent="filter = 'all'">Toutes</a></li>
        <li><a href="#" :class="{selected: filter === 'todo'}" @click.prevent="filter = 'todo'">A faire</a></li>
        <li><a href="#" :class="{selected: filter === 'done'}" @click.prevent="filter = 'done'">Faites</a></li>
      </ul>
      <button class="clear-completed" v-show="completed" @click.prevent="deleteCompleted">Supprimer les tâches finies</button>
    </footer>
  </section>
</template>

<script>
import Vue from 'vue'

export default {
  props: {
    value: { type: Array, default () { return [] } }
  },
  data () {
    return {
      todos: this.value,
      newTodo: '',
      filter: 'all',
      editing: null,
      oldTodo: null
    }
  },
  directives: {
    focus (el, value) {
      if (value) {
        Vue.nextTick(_ => {
          el.focus()
        })
      }
    }
  },
  methods: {
    addTodo () {
      // Le push affecte bien l'élément passé en ref donc le parent se met à jour
      this.todos.push({
        completed: false,
        name: this.newTodo
      })
      this.newTodo = ''
    },
    editTodo (todo) {
      this.editing = todo
      this.oldTodo = todo.name
    },
    doneEdit () {
      this.editing = null
    },
    cancelEdit () {
      this.editing.name = this.oldTodo
      this.doneEdit()
    },
    deleteTodo (todo) {
      // Le filter n'affecte pas l'élément parent et une nouvelle référence est enregistrée... on répare ça avec emit
      this.todos = this.todos.filter(i => i !== todo)
      this.$emit('input', this.todos)
    },
    deleteCompleted () {
      // Le filter n'affecte pas l'élément parent et une nouvelle référence est enregistrée... on répare ça avec emit
      this.todos = this.todos.filter(i => !i.completed)
      this.$emit('input', this.todos)
    }
  },
  computed: {
    allDone: {
      get () {
        return this.remaining === 0
      },
      set (value) {
        this.todos.forEach(todo => {
          todo.completed = value
        })
      }
    },
    remaining () {
      return this.todos.filter(todo => !todo.completed).length
    },
    completed () {
      return this.todos.filter(todo => todo.completed).length
    },
    filteredTodos () {
      if (this.filter === 'todo') {
        return this.todos.filter(todo => !todo.completed)
      } else if (this.filter === 'done') {
        return this.todos.filter(todo => todo.completed)
      }
      return this.todos
    }
  },
  // A nous d'observer les changements sur cette propriété si elle change
  watch: {
    value (value) {
      this.todos = value
    }
  }
}
</script>

<style src="./todos.css"></style>
