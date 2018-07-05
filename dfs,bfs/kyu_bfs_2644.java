package study_algo;
import java.util.*;
public class algo_2644 {
		static int num;
		static int [][] arr;
		static int [] km;
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int count=0;
			 
			num = sc.nextInt();
			arr = new int[num+1][num+1];
			km = new int[num+1];
			int relate_a = sc.nextInt();
			int relate_b = sc.nextInt();
			int num_relate = sc.nextInt();
			for(int i=1; i<= num_relate; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
					arr[a][b] =1;
					arr[b][a]=1;
			}
			Queue <Integer> qe = new LinkedList<Integer>();
			qe.add(relate_a);
			while(!qe.isEmpty()) {
				int now = qe.remove();
				for(int i=1; i<=num; i++) {
					if(arr[now][i] ==0  || km[i] !=0 ) continue;
					else {
						km[i] = km[now]+1;
						qe.add(i);
					}
				}
				if(km[relate_b]==0)
				System.out.println("-1");
				else
				System.out.println(km[relate_b]);
		
			}
					
		}
	
}
