/**
 * Created by Sabishinzou on 31.03.14.
 */

public class Stack<T> {

    //я думаю более правильным будет именно такое название для переменной
    //если бы пришлось реализовать очередь, то там было бы head и tale
    private LinkedList<T> head;

    public LinkedList<T> getHead() {
        return this.head;
    }
    public void setHead(LinkedList<T> head) {
        this.head = head;
    }

    public Stack() {
        LinkedList<T> l = new LinkedList<T>();
        this.setHead(l);
    }
    public Stack(T elem) {
        LinkedList<T> l = new LinkedList<T>();
        this.setHead(l);
        this.push(elem);
    }
    public Stack(Stack stack) {
        LinkedList<T> l = new LinkedList<T>();
        this.setHead(l);

        LinkedList<T>.Refer<T> elem_of_stack = stack.getHead().getList();
        stackCopy(this, elem_of_stack);
    }

    //процедура которая копирует в стек l элементы из списка с началом в e_of_s в обратном порядке
    //т.е в итоге в cкопированном стеке сохранится тот же порядок элементов что и в исходном
    private void stackCopy(Stack l, LinkedList<T>.Refer<T> e_of_s) {
        if (e_of_s != null)
            if (e_of_s.getNext() == null) {
                l.push(e_of_s.getData());
            }
            else
            {
                stackCopy(l, e_of_s.getNext());
                l.push(e_of_s.getData());
            }
    }

    public void push(T elem) {
        this.getHead().add(elem);
    }
    public T peek() throws Exception {
        if (this.getHead().getList() != null)
            return this.getHead().peek();
        else
            throw new Exception("Stack is empty.");
    }
    public T pop() throws Exception {
        if (this.getHead().getList() != null)
            return this.getHead().remove();
        else
            throw new Exception("Stack is empty.");
    }
    public int size() {
        LinkedList<T>.Refer<T> elem_of_stack = this.getHead().getList();
        int i = 0;
        while (elem_of_stack != null) {
            i++;
            elem_of_stack = elem_of_stack.getNext();
        }
        return i;
    }

}
