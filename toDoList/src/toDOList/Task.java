package toDOList;

import java.util.UUID;

public class Task {
    private String id;
    private String title;
    private boolean completed;

    public Task(String id, String title, boolean status){
        this.id = id;
        this.title = title;
        this.completed = status;
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

    public String getStatus(){
        return Boolean.toString(this.completed);
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

