package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Goorm_앵무새꼬꼬 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (char a : br.readLine().toCharArray())
                if (isVowels(a)) sb.append(a);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static boolean isVowels(char a) {
        a = Character.toLowerCase(a);
        if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a =='u') return true;
        return false;
    }
}
