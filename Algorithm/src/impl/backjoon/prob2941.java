package impl.backjoon;

import java.util.Scanner;

public class prob2941 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        str = str.replaceAll("c=","1")
                .replaceAll("c-","1")
                .replaceAll("dz=","1")
                .replaceAll("d-","1")
                .replaceAll("lj","1")
                .replaceAll("nj","1")
                .replaceAll("s=","1")
                .replaceAll("z=","1");
        System.out.println(str.length());
    }
}
