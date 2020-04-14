import java.util.Arrays;
import java.util.Collection;
import java.util.PriorityQueue;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(Parameterized.class)
public class PriorityQueueTest {
    private PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
    private Object[] expected;
    private int first;
    private int second;
    private int third;
    private int fourth;
    private int fifth;

    public PriorityQueueTest(Object[] expected, int first, int second, int third, int fourth, int fifth){
//        this.f = f;
        this.expected = expected;
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
    }

    @Parameterized.Parameters
    public static Collection addedQueue() {
        Object[] obj1 = {2, 2, 3, 4, 5};
        Object[] obj2 = {1, 1, 1, 1, 1};
        Object[] obj3 = {0, 1, 2, 3, 1000000};
        Object[] obj4 = {-10, 0, 27, 100, 567890};
        Object[] obj5 = {-1000, -10, -5, -2, -1};

        return Arrays.asList(new Object[][]
                {
                        { obj1, 1, 3, 5, 4, 2},
                        { obj2, 1, 1, 1, 1, 1},
                        { obj3, 0, 3, 1, 1000000, 2},
                        { obj4, -10, 100, 0, 27, 567890},
                        { obj5, -5, -10, -1000, -1, -2},
                }
        );
    }

    @Test
    public void queue(){
        PriorityQueue <Integer> testQueue = new PriorityQueue<Integer>();

        //System.out.println(
        //    "PriorityQueue with parameters: " + first + " " + second + " " + third + " " + fourth + " " + fifth
        //);

        testQueue.add(first);
        testQueue.add(second);
        testQueue.add(third);
        testQueue.add(fourth);
        testQueue.add(fifth);

        for (int i = 0; i < 5; i++){
            Assertions.assertEquals(expected[i], testQueue.remove());
        }
    }

    @Test
    public void ExceptionAddThrownNull(){
        Exception exception = assertThrows(NullPointerException.class, ()->{
            queue.add(null);
        });
    }

    @Test
    public void ExceptionOfferThrownNull(){
        Exception exception = assertThrows(NullPointerException.class, ()->{
            queue.offer(null);
        });
    }

    @Test
    public void ExceptionThrownIllegal(){
        Exception exception = assertThrows(IllegalArgumentException.class, ()->{
            PriorityQueue<Integer> test = new PriorityQueue<Integer>(-1);
        });
    }
}