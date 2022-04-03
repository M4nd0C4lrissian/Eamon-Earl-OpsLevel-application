import java.util.ArrayList;
//displays some useful info
public class View {
    
    public static void display_tasks(ArrayList<Task> todo){
        if (todo.size() == 0){
            System.out.println("No current tasks.");
            return;
        }
        System.out.println();
        System.out.println("------- TASKS -------");
        System.out.println();
        int i = 0;
        for (Task t : todo){
            System.out.println(Integer.toString(i) + " - " + t.date + " - Priority level: " + Integer.toString(t.p));
            System.out.println("     description: " + t.dcrpn);
            System.out.println();
            i++;
        }
    }

    public static void display_actions(){
        System.out.println("To add a task, type ADD. To remove one, type DEL. If you wish to close the program, type ESC. Press enter when you're done to activate the command.");
    }
}
