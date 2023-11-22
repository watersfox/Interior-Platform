package testpackage;

//연동테스트1
public class connectTest {
	public static void main(String[] args){
		
		for(int i=0; i<50; i++) {
			if(i%2==0)
			System.out.println(i+1+"% 연동");
		}
		
		System.out.println("100% 연동완료");
	}
}