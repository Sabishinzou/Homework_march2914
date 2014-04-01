import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Sabishinzou on 01.04.14.
 */
public class StackTest {
    //все примерно то же самое что и в LinkedListTest
    private Stack<String> stack;

    @Before
    public void setUp() throws Exception {
        this.stack = new Stack();
    }

    @Test
    public void testPush() throws Exception {
        stack.push("AAA");
        if (stack.getHead().getList() != null)
            Assert.assertEquals(stack.getHead().getList().getData(), "AAA");
        else Assert.fail("Стек пуст а не должен бы");

        stack.push("BBB");
        if (stack.getHead().getList() != null)
            Assert.assertEquals(stack.getHead().getList().getData(), "BBB");
        else Assert.fail("Стек пуст а не должен бы");

   }

    @Test
    public void testPeek() throws Exception {
        stack.push("CCC");//наверное нехорошо использовать в тесте функцию которая тестируется в другом месте, но так проще
        if (stack.getHead().getList() != null)
            Assert.assertEquals(stack.peek(), stack.getHead().getList().getData());

        stack.push("CCC2");
        if (stack.getHead().getList() != null)
            Assert.assertEquals(stack.peek(), "CCC2");
    }

    @Test
    public void testPop() throws Exception {
        LinkedList.Refer l;
        String s;

        stack.push("DDD");
        l = stack.getHead().getList();
        s = stack.pop();
        if (l != stack.getHead().getList()) //проверка на удаление
            Assert.assertEquals(s, "DDD"); //то ли значение вернул
        else Assert.fail("Не удалился!");

        stack.push("DDD");
        l = stack.getHead().getList();
        s = stack.pop();
        if (l != stack.getHead().getList()) //проверка на удаление
            Assert.assertEquals(s, "DDD"); //то ли значение вернул
        else Assert.fail("Не удалился!");

    }

    @Test
    public void testSize() throws Exception {
        stack.push("AAA");
        Assert.assertEquals(stack.size(), 1);
        stack.push("AAA");
        Assert.assertEquals(stack.size(), 2);
    }
}
