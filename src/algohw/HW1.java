//22212022 이시영
package algohw;
import java.util.Arrays;

public class HW1 {

	public static void main(String[] args) {
		Solution1 S = new Solution1();
		int[] numbers = {5, 0, 100, 1, 2, 99, 7};
		System.out.println("입력 = " + Arrays.toString(numbers));
		System.out.println("출력 = " + Arrays.toString(S.solution(numbers)));
	}

}
class Solution1 {
	public int[] solution(int[] numbers) {
		int len = numbers.length;
		int maxsize = len*(len-1);
		int size = 0;
		int[] temp = new int[maxsize];
		for(int i=0; i < len-1; i++) {
			for(int j=i+1;j < len; j++) {
				int sum = numbers[i] + numbers[j];
				
				boolean dup = false; // 이하 중복판별 후 배열에 삽입
				for(int k = 0; k < size; k++) {
					if(sum == temp[k]) {
						dup = true;
						break;
					}
				}
				if(dup == false) temp[size++] = sum;
			}
		}
		
		int[] countingarr = new int[200]; // 더한 수의 최대는 199
		int[] answer = new int[size];
		for(int i = 0; i < size; i++) countingarr[temp[i]]++;
		for(int i = 1; i < 200; i++) countingarr[i] += countingarr[i-1];
		for(int i = size-1; i >= 0; i--) 
			answer[--countingarr[temp[i]]] = temp[i];
		
		return answer;
	}
}