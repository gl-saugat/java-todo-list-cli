package toDOList;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Process {

    ArrayList<Task> tasks = new ArrayList<>();
    private Path filePath;

    public Process(){
        this.filePath = Paths.get("tasks.txt");
        createNewFile();
        saveFromFile();
    }

    private void createNewFile(){
        try{
            if(Files.notExists(filePath)){
                Files.createFile(filePath);
                System.out.println("Files created successfully");
            }else{
                System.out.println("Files already existed.");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public void addTask(String title){
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        boolean status = false;
        tasks.add(new Task(id, title, status));
    }

    public List<Task> getAllTasks(){
        return this.tasks.stream().toList();
    }

    public void markTaskDone(String id) throws TaskNotFoundException{
        Task task = getTaskById(id);
        if(task == null){
            throw new TaskNotFoundException("Task Not found.");
        }else{
            task.markCompletion();
        }

    }

    public void deleteTask(String id) throws TaskNotFoundException{
        Task task = getTaskById(id);
        if(task == null){
            throw new TaskNotFoundException("Task Not found.");
        }else{
            this.tasks.remove(task);
        }
    }

    public Task getTaskById(String id) {
        return tasks.stream().filter(i -> i.getID().equals(id)).findFirst().orElse(null);

    }

    public void saveToFile(){
        try(BufferedWriter writer = Files.newBufferedWriter(filePath)){
            for(Task task: tasks){
                String toWrite = toFileString(task);
                writer.write(toWrite);
                writer.newLine();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    private String toFileString(Task task){
        return task.getID() + "|" + task.getTitle() + "|" + task.getStatus();
    }

    public void saveFromFile(){
        try(BufferedReader reader = Files.newBufferedReader(filePath)){
            String line;
            while((line = reader.readLine()) != null){
                Task tmptask = fileStringToTask(line);
                tasks.add(tmptask);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Task fileStringToTask(String line){
        String[] parts = line.split("\\|", -1);

        if(parts.length != 3){
            throw new IllegalArgumentException("Not a valid task");
        }

        String id = parts[0];
        String title = parts[1];
        boolean status = Boolean.parseBoolean(parts[2]);

        return new Task(id, title, status);


    }

    public void clearAllTasks(){
        try(BufferedWriter writer = Files.newBufferedWriter(filePath)){

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


}
