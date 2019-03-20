import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<T> {
    public MyArrayList(int capacity) {
        this.capacity = capacity;
        this.arr = (T[]) new Object[capacity];
    }

    public MyArrayList() {
        capacity = 16;
        this.arr = (T[]) new Object[capacity];
    }

    private int capacity;
    private int newCapacity;
    private int size = 0;
    private T[] arr;


    public void add(T el) {
        if (capacity > size) {
            arr[size] = el;
            size++;
        } else {
            try {
                capacityLow(el);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void add(int index, T el) {
        if (capacity > size) {    // проверяем есть ли место
            try {
                System.arraycopy(arr, index, arr, index + 1, size - index);
                arr[index]=el;  // вставляем элемент по индексу
                size++;  // увеличиваем значение колл элементов

            } catch (Exception e) {
                e.printStackTrace();
            }
        }  else {
            capacityLowToIndex(el,index);
        }
    }

    public void removeByIndex(int index) {
        System.arraycopy(arr, index+1, arr, index, size - index-1);
        arr[size--] = null;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyArrayList<?> that = (MyArrayList<?>) o;
        return capacity == that.capacity &&
                newCapacity == that.newCapacity &&
                size == that.size &&
                Arrays.equals(arr, that.arr);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(capacity, newCapacity, size);
        result = 31 * result + Arrays.hashCode(arr);
        return result;
    }

    public void removeByValue(T value) {
        if (value.getClass().equals(arr[0].getClass())) {
            for (int i = 0; i < size; i++) {
                if (arr[i].equals(value)) {
                    removeByIndex(i);
                    break; // без break если все вхождения удалить надо
                }
            }
        }

    }
    public T getElemOfIndex(int index) {
        if (index <= size) {
            return  arr[index];
        }
        else {
            return null;
        }
    }

    public int length() {
        return size;
    }
    private void capacityLow(T el) {
        CopyForNewBiggerArray();
        add(el);
    }

    private void capacityLowToIndex(T el,int index) {
        CopyForNewBiggerArray();
        add(index,el);
    }

    private void CopyForNewBiggerArray() {
        newCapacity = (capacity * 3) / 2 + 1;
        T[] oldDate = (T[]) new Object[capacity];
        System.arraycopy(arr, 0, oldDate, 0, arr.length);
        arr = (T[]) new Object[newCapacity];
        System.arraycopy(oldDate, 0, arr, 0, size);
        capacity = newCapacity;
    }

}
