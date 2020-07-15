package basics.objectDemo.day07_structures.ITree.bstAVL;

import java.util.Iterator;
import java.util.Random;

/**
 * test
 * Created by sulong on 2019/7/31.
 */
public class TestBST {
    private Random random = new Random();
    private final int MAX1= 16;

    public void testPutAndItr(){
        AVLMap<Integer,String> map = new AVLMap<>();
        for (int i =0;i<MAX1;i++){
            map.put(random.nextInt(MAX1),random.nextInt(MAX1)+"");
        }
        Iterator<AVLEntry<Integer,String>> iterator = map.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().key+ " ");
        }
    }

    public static void main(String[] args) {
        TestBST testBST = new TestBST();

        testBST.testPutAndItr();
    }
}
