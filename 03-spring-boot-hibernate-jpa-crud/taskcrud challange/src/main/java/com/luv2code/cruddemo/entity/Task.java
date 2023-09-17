package com.luv2code.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="task")
public class Task {

    // define fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="duration")
    private int duration;

    // define constructors

    public Task() {

    };

    public Task(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    // define setters/getters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    // define toString()


    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }

}
