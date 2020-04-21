package com.xjtu.job.service;


import com.xjtu.job.model.Task;
import com.xjtu.job.store.TaskStore;
<<<<<<< HEAD

=======
>>>>>>> 060dd0afd1b2abb3f38f07627f384fce0ab4cbd2
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.verification.Times;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TaskServiceTest {
    @Mock
    private TaskStore taskStore;

    @InjectMocks
    private TaskService taskService = new TaskService();

    private ArrayList<Task> tasks;

    @BeforeEach
    void setUp() {
        tasks = new ArrayList<>();
    }

    @Test
<<<<<<< HEAD
    public void shouldSaveTask() {
        when(taskStore.readTasks()).thenReturn(tasks);

        Task savedTask = taskService.saveTask(new Task(1L, "newTask"));

        assertNotNull(savedTask.getUpdatedAt());
        verify(taskStore).writeTasks(any());
    }

=======
    public void shouldDeleteTask() {
        tasks.add(new Task(1L, "task"));
        when(taskStore.readTasks()).thenReturn(tasks);

        Optional<Task> optionalTask = taskService.delete(1L);

        Task task = optionalTask.get();
        assertEquals(1L, task.getId());
        verify(taskStore).writeTasks(any());
    }

    @Test
    public void shouldNotDeleteTaskWhenNotExist() {
        when(taskStore.readTasks()).thenReturn(tasks);

        Optional<Task> optionalTask = taskService.delete(1L);
>>>>>>> 060dd0afd1b2abb3f38f07627f384fce0ab4cbd2

        assertFalse(optionalTask.isPresent());
        verify(taskStore, new Times(0)).writeTasks(any());
    }
}