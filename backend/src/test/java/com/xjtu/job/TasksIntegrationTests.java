package com.xjtu.job;
<<<<<<< HEAD:backend/src/test/java/com/xjtu/job/TasksIntegrationTests.java
=======

>>>>>>> 060dd0afd1b2abb3f38f07627f384fce0ab4cbd2:backend/src/test/java/com/xjtu/job/TasksIntegrationTests.java
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TasksIntegrationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(2)
    public void shouldSaveTask() throws Exception {
        this.mockMvc.perform(post("/api/tasks")
                .content("{ \"id\" : 2, \"content\" : \"check if it works\" }")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(5)
    public void shouldDeleteByTaskId() throws Exception {
        this.mockMvc.perform(delete("/api/tasks/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isNoContent());
    }

}