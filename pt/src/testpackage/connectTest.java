package testpackage;

//연동테스트1
public class connectTest {
	public static void main(String[] args){
		
		int n1;
		int n2;
		int n3;
		int n4;
		//int n5;
		
		for(int i=0; i<50; i++) {
			if(i%2==0)
			System.out.println(i+1+"% 연동");
		}
		
		System.out.println("100% 연동완료");
		
		String ssn = "22222-22";
		String s = ssn.substring(0,2);
		System.out.println(s);
	}
}