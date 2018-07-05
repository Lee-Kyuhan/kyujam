package study_algo;
import java.util.*;
public class kyu_dfs_10265 {
	static int [] count;
	static int max_num;
	static int pos_num;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		max_num = sc.nextInt();
		int sol =0;
		pos_num = sc.nextInt();
		int [][] prefer = new int[max_num+1][max_num+1];
		int [] visit = new int[max_num+1]; 
		int [] arr = new int[max_num+1];
		count = new int[max_num+1];
		for(int i=1; i<= max_num; i++) {
			arr[i] = sc.nextInt();
		}
		for(int i=1; i<=max_num; i++) {
			for(int j=1; j<=max_num; j++) {
				prefer[i][arr[j]] =1;
			}
		}
		for(int i =1; i<= max_num; i++) {
			dfs(i,visit, prefer);
		}
	
		for(int i=1; i<=max_num; i++) {
			for(int k=1; k< max_num; k++)
			if(count[i] > count[i+1]) {
					int temp = count[i];
					count[i] = count[i+1];
					count[i+1] = temp;
			}
		}
		while(true) {
			for( int i=1; i<= max_num;i++)
			if(max_num - count[i] <= pos_num) {
				sol= max_num -count[i];
			}
			break;
		}
		System.out.println(sol);
		
	}
	static void dfs(int i, int[] visit , int[][]prefer) {
		for(int k=1; k<visit.length+1; k++) {
			if(prefer[i][k]==1 && visit[i]==0) {
				visit[i] = 1;
				count[i]++;
				dfs(k,visit,prefer);	
			}
		}		
	}
}
