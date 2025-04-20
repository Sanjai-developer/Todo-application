package com.doto.dotoapp.repository;

import com.doto.dotoapp.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {




}
