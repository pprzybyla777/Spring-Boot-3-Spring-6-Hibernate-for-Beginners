package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Task;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TaskDAOImpl implements TaskDAO {

    private EntityManager entityManager;

    @Autowired
    public TaskDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Task theTask) {
        entityManager.persist(theTask);
    }

    @Override
    public Task findByID(Integer taskID) {
        return entityManager.find(Task.class, taskID);
    }

    @Override
    @Transactional
    public void update(Task theTask) {
        entityManager.merge(theTask);
    }

    @Override
    @Transactional
    public void delete(Integer taskID) {
        Task theTask = entityManager.find(Task.class, taskID);
        if (theTask == null) {
            return;
        }
        entityManager.remove(theTask);
    }


}
