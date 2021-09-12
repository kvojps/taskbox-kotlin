package com.example.taskbox.data

import androidx.lifecycle.LiveData

class TaskRepository(private val taskDao: TaskDao) {

    val readAllTasks: LiveData<List<Task>> = taskDao.readAllTasks()

    suspend fun addTask(task: Task){
        taskDao.addTask(task)
    }

    suspend fun deleteTask(task: Task) {
        taskDao.deleteTask(task)
    }

}