 package study_algo;
import java.util.*;

 

public class algo_11724 {

    static boolean[] c;

    static ArrayList<Integer>[] a;

     

    static void dfs(int x){

        if(c[x])

            return;

        c[x]=true;

        for(int y : a[x]){

            if(c[y]==false)

                dfs(y);

        }

    }

     

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        int n=sc.nextInt();

        int m=sc.nextInt();

        int count=0;

        a=(ArrayList<Integer>[]) new ArrayList[n+1];

        c=new boolean[n+1];

        for(int i=1;i<=n;i++){

            a[i]=new ArrayList<Integer>();

        }

        for(int i=0;i<m;i++){

            int u=sc.nextInt();

            int v=sc.nextInt();

            a[u].add(v);

            a[v].add(u);

        }

         

        for(int i=1;i<=n;i++){

            if(c[i]==false){

                count++;

                dfs(i);

            }

             

        }

        System.out.println(count);

    }

     

}

