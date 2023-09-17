package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.TaskDAO;
import com.luv2code.cruddemo.entity.Task;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(TaskDAO taskDAO) {

		return runner -> {
//			saveTask(taskDAO, "Do laundry", 30);
//			saveTask(taskDAO, "Wash dishes", 15);
//			saveTask(taskDAO, "Throw trash", 20);
//			saveTask(taskDAO, "Watch TV", 20);
//			findTaskByID(taskDAO, 2);
//			findTaskByID(taskDAO, 4);
//			updateTask(taskDAO, 4, "Play on PC", 120);
			deleteTask(taskDAO, 4);
		};

	}

	private void saveTask(TaskDAO taskDAO, String title, int duration) {
		Task theTask = new Task(title, duration);
		taskDAO.save(theTask);
		System.out.println("New task saved of id: " + theTask.getId());
	}

	private void findTaskByID(TaskDAO taskDAO, int taskID) {
		Task theTask = taskDAO.findByID(taskID);
		System.out.println("Student found: " + theTask);
	}

	private void updateTask(TaskDAO taskDAO, int taskID, String title, int duration) {

		Task theTask = taskDAO.findByID(taskID);

		if (theTask == null) {
			System.out.println("Task not found.");
			return;
		}

		theTask.setTitle(title);
		theTask.setDuration(duration);

		taskDAO.update(theTask);

		System.out.println("Task with id: " + taskID + " has been updated.");

	}

	private void deleteTask(TaskDAO taskDAO, int taskID) {
		taskDAO.delete(taskID);
		System.out.println("Task with id: " + taskID + " has been removed.");
	}

}
