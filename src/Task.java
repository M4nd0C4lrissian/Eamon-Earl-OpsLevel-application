
/*Task ADT
Assumptions: 
   - Date is a valid date and is of the format yyyy/MM/dd
   - p is > 0 
*/
public class Task{
    String dcrpn; //description of task
    String date;
    int p; //priority of task

    //above assumptions apply to the input values 
    public Task(String descrip, String date, int p){
        this.dcrpn = descrip;
        this.date = date;
        this.p = p;
    }


}