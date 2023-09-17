package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Task;

public interface TaskDAO {
    void save(Task theTask);
    Task findByID(Integer taskID);
    void update(Task theTask);
    void delete(Integer taskID);
}
