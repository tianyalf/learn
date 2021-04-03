package entity;

/**
 * @createTime:2021/03/23 22:12
 * @author:luofeng30850
 */
public class Test01 {
    public static void main(String[] args) {
        String str = "您的验证码为3471，有效期为60秒。";
        String s = changeCode(str);
        System.out.println(s);
    }

    private static String changeCode(String str) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (temp >= '0' && temp <= '9') {
                count++;
            } else {
                count = 0;
            }
            if (count == 4) {
                index = i;
                break;
            }
        }
        for (int i = 0; i < index - 2; i++) {
            sb.append(str.charAt(i));
        }
        sb.append("*").append("*");
        for (int i = index; i < str.length(); i++) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
