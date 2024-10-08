import java.util.Scanner;
public class boj_6064_huiju {

    public static void main(String[] args) {
      //M과 N의 최소공배수 찾기 = 마지막 해
      //(M*N)/최대공약수 = 최소공배수
      //if 주어진 달력 날짜가 최소공배수를 초과할 경우 -1 출력
      //x가 돌아오는 주기를 카운트하면서 y가 N과 같은지 검사
      //y가 N과 같아지면 카운트*M+x 로 정답을 구한다

      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();

      for(int i=0; i<t; i++) {

        int m = sc.nextInt();
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        int lcm = (m*n)/getGCD(m,n);  //최소공배수 구하기

        for(int count=x;;count+=m) {	//count의 최소값, count에 더해지는 숫자만 설정하고 무한반복
          if(count > lcm) {	// 세어진 총 햇수가 최소공배수(마지막 해)보다 커질 때 -> 성립하지 않음
            System.out.println(-1);	//-1을 출력하고 탈출
            break;
          }
          int tmpY = count%n;	//y의 자리에 들어갈 수는 현재 세어진 햇수를 N으로 나눴을 때의 나머지 = tmpY
          if(tmpY==y)	{ 	//tmpY가 y와 같아질 때 현재까지 세어진 햇수가 정답이 된다
            System.out.println(count);	//count를 출력하고 탈출
            break;
          }
        }
      }
    }

    public static int getGCD(int num1, int num2) {//최대공약수 최소공배수 구하는 메서드
      if (num1 % num2 == 0) {
        return num2;
      }
      return getGCD(num2, num1%num2);
    }

  }