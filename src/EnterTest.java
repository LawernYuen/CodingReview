import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class EnterTest {

    public static void main(String[] args) { //������
        CharTest();  //����System.in����
        ReadTest();  //����ReadTest����
        ScannerTest();//����ScannerTest����
    }
    /**
     * System.in��System.out����
     * ȱ��һ: �÷����ܻ�ȡ�Ӽ���������ַ�����ֻ�����һ���ַ��Ļ�ȡ
     * ȱ���: ��ȡ��ֻ��char���͵ġ��������int,float�����͵�����,�Ƚ��鷳��
     */
    public static void CharTest(){
        try{
            System.out.print("Enter a Char:");
            char i = (char)System.in.read();
            System.out.println("Yout Enter Char is:" + i);
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
    /**
     * InputStreamReader��BufferedReader����
     * �ŵ�: ���Ի�ȡ����������ַ���
     * ȱ��: ���Ҫ��ȡ����int,float�����͵���Ȼ��Ҫת��
     */
    public static void ReadTest(){
        System.out.println("ReadTest, Please Enter Data:");
        InputStreamReader is = new InputStreamReader(System.in); //new����InputStreamReader����
        BufferedReader br = new BufferedReader(is); //�ù���ķ�������BufferedReader��
        try{ //�÷������и�IOExcepiton��Ҫ����
            String name = br.readLine();
            System.out.println("ReadTest Output:" + name);
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
    /**
     * Scanner���еķ���
     * �ŵ�һ: ���Ի�ȡ����������ַ���
     * �ŵ��: ���ֳɵĻ�ȡint,float���������ݣ��ǳ�ǿ��Ҳ�ǳ����㣻
     */
    public static void ScannerTest(){
        Scanner sc = new Scanner(System.in);
        System.out.println("ScannerTest, Please Enter Name:");
        String name = sc.nextLine();  //��ȡ�ַ���������
        System.out.println("ScannerTest, Please Enter Age:");
        int age = sc.nextInt();    //��ȡ��������
        System.out.println("ScannerTest, Please Enter Salary:");
        float salary = sc.nextFloat(); //��ȡfloat������
        System.out.println("Your Information is as below:");
        System.out.println("Name:" + name +"\n" + "Age:"+age + "\n"+"Salary:"+salary);
    }
}