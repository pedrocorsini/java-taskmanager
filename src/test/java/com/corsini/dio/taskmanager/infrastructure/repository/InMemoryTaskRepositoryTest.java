package com.corsini.dio.taskmanager.infrastructure.repository;


import com.corsini.dio.taskmanager.domain.TaskRepository;
import com.corsini.dio.taskmanager.domain.TaskRepositoryTest;

class InMemoryTaskRepositoryTest extends TaskRepositoryTest{
    
    @Override
    protected TaskRepository createRepository() {
        return new InMemoryTaskRepository();
    }
     
}
