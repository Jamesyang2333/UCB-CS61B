import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDeque1B {
    @Test
    public void test1(){
        ArrayDeque<Integer> students = new ArrayDeque<>();
        ArrayDequeSolution<Integer> answer = new ArrayDequeSolution<>();
        StringBuilder message = new StringBuilder();
        for(int i = 0; i < 100; i++){
            double numberBetweenZeroAndOne = StdRandom.uniform();
            if(numberBetweenZeroAndOne < 0.5){
                students.addFirst(i);
                answer.addFirst(i);
                message.append(String.format("addFirst(%d)\n", i));
            }
            else {
                students.addLast(i);
                answer.addLast(i);
                message.append(String.format("addLast(%d)\n", i));
            }
        }
        for(int i = 0; i < 10; i++){
            double numberBetweenZeroAndOne = StdRandom.uniform();
            int count = 1;
            if(numberBetweenZeroAndOne < 0.5){
                if(count > 0){
                    Integer studentanswer = students.removeFirst();
                    Integer expected = answer.removeFirst();
                    message.append("removeFirst\n");
                    assertEquals(message.toString(), expected, studentanswer);
                }
            }
            else{
                if(count > 0){
                    Integer studentanswer = students.removeLast();
                    Integer expected = answer.removeLast();
                    message.append("removeLast\n");
                    assertEquals(message.toString(), expected, studentanswer);
                }
            }
        }
    }
}
