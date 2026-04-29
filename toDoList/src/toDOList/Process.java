package toDOList;

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
            throw new TaskNotFoundException("Task Not found!");
        }else{
            task.markCompletion();
        }

    }

    public void deleteTask(String id) throws TaskNotFoundException{
        Task task = getTaskById(id);
        if(task == null){
            throw new TaskNotFoundException("Task Not found!");
        }else{
            this.tasks.remove(task);
        }
    }

    public Task getTaskById(String id) {
        return tasks.stream().filter(i -> i.getID().equals(id)).findFirst().orElse(null);

    }


}
