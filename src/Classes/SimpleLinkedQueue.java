package Classes;

import java.util.ArrayList;
import java.util.List;

public class SimpleLinkedQueue<T> extends SimpleLinkedList<T> implements SimpleQueue<T> {
    @Override
    public void add(T value) {
        this.addLast(value);
    }

    @Override
    public T remove() throws Exception {
        T result = this.element();
        this.removeFirst();
        return result;
    }

    @Override
    public T element() throws Exception {
        if (this.empty()) {
            throw new Exception("Queue is empty");
        }
        return this.getFirst();
    }
    public void getAnswer() throws Exception {
        int n = size();
        List<T> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(remove());
        }
        for (int i = 0; i < n; i++) {
            add(list.get(i));
            add(list.get(i));
        }
    }

    @Override
    public int count() {
        return this.size();
    }
}

