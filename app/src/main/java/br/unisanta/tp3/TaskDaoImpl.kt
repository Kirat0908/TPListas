package br.unisanta.tp3.model

class TaskDaoImpl : TaskDao {
    companion object {
        private val tasks = mutableListOf<Task>()
    }

    override fun addTask(task: Task) {
        tasks.add(task)
    }

    override fun getTasks(): List<Task> {
        return tasks
    }
}