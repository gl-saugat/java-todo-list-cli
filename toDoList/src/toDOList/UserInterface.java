package toDOList;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    Process process = new Process();
    Scanner scanner;

    public UserInterface(Scanner scanner){
        this.scanner = scanner;

        Path path = Paths.get("tasks.txt");

        try{
            if(Files.notExists(path)){
                Files.createFile(path);
                System.out.println("File created successfully!");
            }else {
                System.out.println("File already exists!");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void start(){

        System.out.println("Welcome to the Tasks App!!");
        while(true){
            printMenu();
            int input = getMenuOption();

            switch (input){
                case 1:
                    System.out.println("Enter the task you want to do.");
                    String taskTitle = getInput();
                    process.addTask(taskTitle);
                    break;

                case 2:
                    System.out.println("Enter the valid ID number of the task you'd like to delete.");
                    List<Task> deletingTasks = printTasks();
                    int toDeleteNumber = getTaskNumber(deletingTasks);
                    try{
                        String toDeleteID = deletingTasks.get(toDeleteNumber -1).getID();
                        process.deleteTask(toDeleteID);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Which task have you completed? Enter it's valid ID.");
                    List<Task> completingTasks = printTasks();
                    int toCompleteNumber = getTaskNumber(completingTasks);
                    try{
                        String toCompleteID = completingTasks.get(toCompleteNumber -1).getID();
                        process.markTaskDone(toCompleteID);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    printTasks();
                    break;

                case 5:
                    System.out.println("Thanks for using the app.");
                    return;
            }
        }


    }

    public void printMenu(){
        System.out.println("""
                What would you like to do? Please enter the valid adjacent number to the task.
                1. Add Task
                2. Delete Task
                3. Complete a Task
                4. Show Tasks
                5. Exit
                """);
    }

    public String getInput(){
        String checkedInput = "";
        try{
            checkedInput = scanner.nextLine();
        }catch (Exception e){
            System.out.println("Error is: " + e.getMessage());
        }
        return checkedInput;
    }

    public int getMenuOption(){
        int input = 0;
        try {
            do{
                input = Integer.parseInt(scanner.nextLine());
            }
            while (!(input >= 1 && input <=5));

        }catch (Exception e){
            System.out.println("Invalid Input. error is " + e.getMessage());
        }
        return input;
    }

    public int getTaskNumber(List<Task> list){
        int input = 0;
        try {
            do{
                input = Integer.parseInt(scanner.nextLine());
            }
            while (!(input >= 1 && input <=list.size()));

        }catch (Exception e){
            System.out.println("Invalid Input. error is " + e.getMessage());
        }
        return input;
    }

    public List<Task> printTasks(){
        System.out.println("ID "+ "Title " + "Status");
        List<Task> tasks = process.getAllTasks();
        for(int i = 0; i < tasks.size(); i++){
            System.out.println(i+1+ ": " + tasks.get(i));
        }
        return tasks;
    }
}
