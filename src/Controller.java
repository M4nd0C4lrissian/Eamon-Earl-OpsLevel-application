import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

//scripts intended behaviour
//handles assumptions of other ADTs
//future improvement - have the ADT contructors throw InputMismatchExceptions for invalid inputs - less to check for in the controller and is easier on the programmer
public class Controller{

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        while(true){
            
                View.display_tasks(TaskList.get_tasks());
                View.display_actions();

            try{
                String choice = s.next();

                if(choice.compareTo("ADD") == 0){
                    System.out.print("Please input the deadline of your task (format is yyyy/mm/dd): ");
                    String date = s.next();

                    if(!(DateServices.is_validDate(date))){ //checks validity 
                        throw new InputMismatchException();
                    }
                    System.out.println();
                    System.out.println("Please input the priority level of your task as a positive integer: ");
                    ArrayList<Integer> unused = TaskList.unused_p();
                    
                    if (unused.size() > 0){
                        System.out.print("Some suggested priority levels include: ");
                        for(int i = 0 ; i < unused.size() ; i++){
                            System.out.print(Integer.toString(unused.get(i)) + " ");
                        }
                    }
                    System.out.println();
                    Integer p = s.nextInt();
                    s.nextLine();
                    if(p <= 0){
                        throw new InputMismatchException();
                    }

                    System.out.println();
                    System.out.print("Please provide a description of your task: ");
                    String descrip = s.nextLine();

                    TaskList.add(new Task(descrip, date, p));

                }

                else if(choice.compareTo("DEL") == 0){

                    while(true){

                    if(TaskList.get_tasks().size() == 0){
                        System.out.println("No current tasks to be deleted. Congrats!");
                        System.out.println();
                        break;
                    }

                    View.display_tasks(TaskList.get_tasks());

                    System.out.println();
                    System.out.print("Please input the index of the task you'd like to delete (input a negative integer to return to the main menu): ");

                    int del = s.nextInt();
                    s.nextLine();
                    if(del < 0){
                        break;
                    }

                    if(del >= TaskList.get_tasks().size()){
                        throw new InputMismatchException();
                    }
                    TaskList.remove(del);
                    }
                }

                else if(choice.compareTo("ESC") == 0){
                    s.close();
                    break;
                }

                else{
                    throw new InputMismatchException();
                }

            }

            catch(InputMismatchException e){
                System.out.println("Invalid input - please try again");
                continue;
            }

        }
    }



}