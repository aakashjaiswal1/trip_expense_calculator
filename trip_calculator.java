import java.util.HashMap;
import java.util.Scanner;

public class trip_calculator {
    public static void main(String[] args) {
        Scanner scrn=new Scanner(System.in);
        System.out.println("Enter total no of people");
        int n=scrn.nextInt();
        System.out.println("Enter names of people");
        HashMap<String,Integer> hm=new HashMap<>();
        int c=0;
        HashMap<Integer,String> map=new HashMap<>();
        for (int i=0;i<n;i++){
            String str=scrn.next();
            System.out.println(str+" registered");
            hm.put(str,c);
            map.put(c,str);
            c++;
        }
        double[][] matrix=new double [c][c];

        while (true){
            System.out.println("To continue press any key");
            System.out.println("To terminate press T");
            String trigger=scrn.next();
            if (trigger.equals("T"))break;
            System.out.println("Paid by");
            String str=scrn.next();
            int parent_key=hm.get(str);
            System.out.println("Enter no of people paid for (include self) if paid for all enter 0");
            int k=scrn.nextInt();
            System.out.println("Enter total amount paid");
            double amount=scrn.nextDouble();
            if (k==0){
                double contri = amount / (double) n;
                for (int i=0;i<n;i++) {
                    matrix[parent_key][i] += contri;
                    matrix[i][parent_key] -= contri;
                }
            }
            else {
                double contri = amount / (double) k;
                System.out.println("Now enter names of each person");
                while (k-- > 0) {
                    String pp = scrn.next();
                    int kk = hm.get(pp);
                    matrix[parent_key][kk] += contri;
                    matrix[kk][parent_key] -= contri;
                }
            }
        }

        for (int i=0;i<n;i++){
            String parent=map.get(i);
            System.out.println("detail of"+" "+parent);
            System.out.println();
            for (int j=0;j<n;j++){
                if (i==j)continue;
                String child=map.get(j);
                System.out.print("with "+child+" ");
                System.out.println("Value is "+matrix[i][j]);
            }
            System.out.println("///////////////////////////////");
        }

    }
}
