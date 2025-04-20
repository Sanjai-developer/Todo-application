package com.doto.dotoapp.services;

import com.doto.dotoapp.models.Task;
import com.doto.dotoapp.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskService {

    private final TaskRepository taskrepository;

    public TaskService(TaskRepository taskrepository) {
        this.taskrepository = taskrepository;
    }

    public List<Task> getAllTasks() {
    return taskrepository.findAll();
    }

    public void createTask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setComplete(false);
        taskrepository.save(task);

    }

    public void deleteTask(Long id) {
        taskrepository.deleteById(id);
    }

    public void toggleTask(Long id) {
        Task task = taskrepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid task id"));
        task.setComplete(!task.isComplete());
        taskrepository.save(task);
    }
}
