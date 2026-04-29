package toDOList;

import java.util.UUID;

public class Task {
    UUID uuid = UUID.randomUUID();
    private String id = uuid.toString();
    private String title;
    private boolean completed = false;

    public Task(String title){
        this.title = title;
    }

    public String getID(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public boolean isCompleted(){
        return this.completed;
    }

    public void markCompletion(){
        this.completed = true;
    }

    @Override
    public String toString(){
        String check = this.completed ?  "Completed" : "Not completed yet.";

        return this.title + " : " + check;

    }

}

