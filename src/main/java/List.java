/**
 * Created by Sabishinzou on 30.03.14.
 */
public interface List<T> {

    void add(T elem);
    T peek() throws Exception;
    T remove() throws Exception;
}
