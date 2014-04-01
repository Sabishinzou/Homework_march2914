/**
 * Created by Sabishinzou on 30.03.14.
 */
public class LinkedList<T> implements List<T> {

    //пришлось сделать этот класс public, иначе невозможно(с моими знаниями) перечислять элементы в классе Stack для подсчета и копирования
    //т.к. возникает необходимость заводить переменные типа Refer.
    //возможно я что-то не так понял и/или допускаю ошибки
    public class Refer<T> {
        private T data;
        private Refer<T> next;

        public Refer(){
        }
        public Refer(T data){
            this.setData(data);
            this.setNext(null);
        }

        public T getData() {
            return data;
        }
        public void setData(T data) {
            this.data = data;
        }

        public Refer<T> getNext() {
            return next;
        }
        public void setNext(Refer<T> next) {
            this.next = next;
        }
    }

    private Refer<T> list;

    public LinkedList() {
        this.setList(null);
        //null ведь не относится к магическим числам? Хотя по умолчанию и так null наверное.
    }

    public Refer<T> getList() {
        return list;
    }
    public void setList(Refer<T> list) {
        this.list = list;
    }

    /*
    //эта функция необходима, если класс Refer private, (инче это функция не нужна),
    //т.к. в классе Stack при использовании head.getList().getNext()
    //возникает ошибка доступа
    public Refer<T> getNextFromList() {
        return this.getList().getNext();
    }
    */

    @Override
    public void add(T data) {
        Refer<T> new_elem = new Refer(data);
        new_elem.setNext(getList());
        this.setList(new_elem);
    }

    @Override
    public T peek() throws Exception {
        //тут обработка исключений но не знаю правильно ли в целом,
        //сделал как вы предлагали по прошлой домашке
        //хотя возможно лучше делать return null вместо throw new Exception("List is empty.");
        if (this.getList() != null)
            return getList().getData();
        else
            throw new Exception("List is empty.");
    }

    @Override
    public T remove() throws Exception {
        if (this.getList() != null) {
            Refer<T> returning_elem = this.getList();
            this.setList(returning_elem.getNext());
            return returning_elem.getData();
            //здесь еще наверное следовало бы использовать(а для начала описать) деструктор,
            // а не просто все оставить на автоматический сборщик мусора
        }
        else throw new Exception("List is empty."); //нечего удалять
    }

}
