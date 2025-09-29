import java.util.*;
public class PartA {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int num;
        for(int i=0;i<3;i++){
            System.out.println("Please enter the value of index: "+ i +" ");
            num = sc.nextInt();
            list.add(num); // int=>Integer(autoboxing)
        }
        int sum=0;
        for(int el : list){
            sum+=el; //Integer=>int unboxing
        }
        System.out.println("sum: "+ sum);
        sc.close();
    }
}
