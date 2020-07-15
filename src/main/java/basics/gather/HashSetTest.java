package basics.gather;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * 散列表 HashSet
 * Created by sulong on 2019/1/18.
 */
public class HashSetTest {
    public static void main(String[] args) {
        // 构建一个散列表
        Set<String> words = new HashSet<>();
        long toatlTime = 0;

        // 接收外部输入
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String word = in.next();
            long callTime = System.currentTimeMillis();
            words.add(word);
            callTime = System.currentTimeMillis() - callTime;
            toatlTime += callTime;

        }
        Iterator<String> iter = words.iterator();
        for (int i = 1; i <= 20 && iter.hasNext();i++){
            System.out.println(iter.next());
            System.out.println("...");
            System.out.println(words.size() + "distint words" + toatlTime + "millseconds.");
        }
    }
}
