/**
 * Created by Sabishinzou on 31.03.14.
 */
public class Program {

    public static void main(String[] args) throws Exception {
        Stack s = new Stack();
        System.out.println(s.peek());
        s.push("01");s.push("02");s.push("03");s.push("04");s.push("05");s.push("06");
        showStack(s);
        System.out.println(s.size());

        System.out.println(s.pop());
        showStack(s);

        Stack s1 = new Stack(s);
        showStack(s1);

        Stack s2 = new Stack("This is the first element of s2-stack");
        showStack(s2);
    }

    public static void showStack(Stack s) {
        LinkedList<String>.Refer<String> elem = s.getHead().getList();
        while (elem != null) {
            System.out.print(elem.getData() + " ");
            elem = elem.getNext();
        }
        System.out.println();
    }
}
