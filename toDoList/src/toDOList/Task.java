package toDOList;

import java.util.UUID;

public class Task {
    UUID uuid = UUID.randomUUID();
    private String id = uuid.toString();
    private String title;
    private boolean completed = false;

    public String getID(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public boolean isCompleted(){
        return this.completed;
    }

    @Override
    public String toString(){
        String check = this.completed ?  "Completed" : "Not completed yet.";

        return this.title + " : " + check;

    }

}

