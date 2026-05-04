package toDOList;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Process {

    ArrayList<Task> tasks = new ArrayList<>();


    public void addTask(String title){
        tasks.add(new Task(title));
    }

    public List<Task> getAllTasks(){
        return this.tasks.stream().toList();
    }

    public void markTaskDone(String id) throws TaskNotFoundException{
        Task task = getTaskById(id);
        if(task == null){
            throw new TaskNotFoundException("Task Not found by this ID! Please enter a correct one.");
        }else{
            task.markCompletion();
        }

    }

    public void deleteTask(String id) throws TaskNotFoundException{
        Task task = getTaskById(id);
        if(task == null){
            throw new TaskNotFoundException("Task Not found by this ID! Please enter a correct one.");
        }else{
            this.tasks.remove(task);
        }
    }

    public Task getTaskById(String id) {
        return tasks.stream().filter(i -> i.getID().equals(id)).findFirst().orElse(null);

    }

    public void saveToFile(){


    }


}
