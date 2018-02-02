public class HelloNumbers{
	public static void main(String[] args){
		int sum = 0;
		for(int i = 0; i < 10; i++){
			sum += i;
			if(i != 9)
				System.out.print(sum + " ");
			else System.out.println(sum);
		}
	}
}