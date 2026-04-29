package toDOList;

import java.util.List;
import java.util.Scanner;

public class Main {



    public static void main(String[] args){
        Process process = new Process();
        Scanner scanner = new Scanner(System.in);
        process.addTask("Let's start Java!");
        process.addTask("Let's start Networking");

        List<Task> printTask = process.getAllTasks();
        for(int i = 0; i<printTask.size();i++){
            System.out.println(i+1 + ": " + printTask.get(i));
        }

        System.out.println("Any you want to delete?");
        int input = Integer.parseInt(scanner.nextLine());
        String id = printTask.get(input-1).getID();

        try{
            process.markTaskDone(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        printTask = process.getAllTasks();
        for(int i = 0; i<printTask.size();i++){
            System.out.println(i+1 + ": " + printTask.get(i));
        }

    }

}
