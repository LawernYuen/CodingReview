public class NumToStr{
    public int numToStr(int num){
        if (num < 0)
            return 0;
        String str = String.valueOf(num);
        int len = str.length();
        int[] count = new int[len];
        for (int i = len-1; i >= 0; i--){
            if (i == len-1)
                count[i] = 1;
            else {
                count[i] = count[i+1];
                // �����Ч�Ͳ������ӷ�ʽ����Ϊ��λ�����ǹ��е�
                if (isValid(str, i)){
                    if (i == len - 2)
                        count[i] += 1;
                    // �����Ч���൱�������������λ�ķ�ʽ��Ŀ���Ѹ�λ��
                    // �����һλ����һ������
                    else
                        count[i] += count[i+2];
                }
            }
        }
    }

    private boolean isValid(String str, int i){
        int a = str.charAt(i) - '0';
        int b = str.charAt(i+1) - '0';
        int convert = a * 10 + b;
        if (convert >= 10 && convert <= 25)
            return true;
        return false;
    }
}