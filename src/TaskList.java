import java.util.ArrayList;

/*ADT representing a list of tasks - responsible for managing and ordering said list
Assumptions: 
    - integer passed to remove will be within bounds of todo
    - unused_p() will not be called when todo is empty
Invariants:
    - todo will always be ordered in ascending order of non-unique priority values 
*/
public class TaskList {
    private static ArrayList<Task> todo = new ArrayList<Task>();

    public static ArrayList<Task> get_tasks(){
        return todo;
    }

    //finds unused priority levels between the current smallest and greatest priority levels
    public static ArrayList<Integer> unused_p(){
        ArrayList<Integer> unused = new ArrayList<Integer>();
        int current = 1;
        int i = 0;
        while(i < todo.size()){
            int p = todo.get(i).p;
            if (p > current){
                for(int j = current ; j < p ; j++){
                    unused.add(current);
                    current++;
                }
            } 
            i++;
        }
        return unused;
    }

    public static void add(Task t){

        if(todo.size() == 0 || t.p >= todo.get(todo.size() - 1).p){
            todo.add(t);
        }
        else if(t.p <= todo.get(0).p){
            todo.add(0, t);
        }
        else{
            todo.add(binsert(t.p, 0, todo.size() -1), t);
        }
    }

    protected static void remove(int i){
        todo.remove(i);
    }

    //basic recursive binary search for insertions
    private static int binsert(int p, int low, int high){
        if(low > high){
            return low;
        }
        int mid = (low + high) / 2;
        int m_val = todo.get(mid).p;
        int diff = p - m_val;

        if(diff == 0){
            return mid;
        }

        else if(diff > 0){
            return binsert(p, mid + 1, high);
        }
        else{
            return binsert(p, low, mid - 1);
        } 
    }






}
