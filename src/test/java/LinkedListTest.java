import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.*;
import org.omg.CORBA.Object;

/**
 * Created by Sabishinzou on 01.04.14.
 */
public class LinkedListTest {

    private LinkedList<String> list;

    @Before
    public void setUp() throws Exception {
        this.list = new LinkedList();
    }


    @Test
    //просто проверяет добавился ли и тот ли это элемент
    public void testAdd() throws Exception {
        list.add("AAA");
        if (list.getList() != null)
            Assert.assertEquals(list.getList().getData(), "AAA");
        else Assert.fail("Список пуст а не должен бы");

        list.add("BBB");
        if (list.getList() != null)
            Assert.assertEquals(list.getList().getData(), "BBB");
        else Assert.fail("Список пуст а не должен бы");
    }

    @Test
    public void testPeek() throws Exception {
        list.add("CCC");//наверное нехорошо использовать в тесте функцию которая тестируется в другом месте, но так проще
        if (list.getList() != null)
            Assert.assertEquals(list.peek(), list.getList().getData());

        list.add("CCC2");
        if (list.getList() != null)
            Assert.assertEquals(list.peek(), "CCC2");
    }

    @Test
    public void testRemove() throws Exception {
        LinkedList.Refer l;
        String s;

        list.add("DDD");
        l = list.getList();
        s = list.remove();
        if (l != list.getList()) //проверка на удаление
            Assert.assertEquals(s, "DDD"); //то ли значение вернул
        else Assert.fail("Не удалился!");

        list.add("EEE");
        l = list.getList();
        s = list.remove();
        if (l != list.getList()) //проверка на удаление
            Assert.assertEquals(s, "EEE"); //то ли значение вернул
        else Assert.fail("Не удалился!");
    }
}
