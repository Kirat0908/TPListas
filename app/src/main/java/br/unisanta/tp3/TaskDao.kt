package br.unisanta.tp3.model

interface TaskDao {
    fun addTask(task: Task)
    fun getTasks(): List<Task>
}