import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        MyArrayList<Integer> arrayList = new MyArrayList<>(5);
        for (int i = 0; i < 10; i++) {
            arrayList.add(i, 100 + i);
        }
        for (int i = 0; i < arrayList.length(); i++) {
            System.out.print(arrayList.getElemOfIndex(i)+" ");

        }
        System.out.println();
        arrayList.add(5,555);
//        arrayList.removeByIndex(6);
        arrayList.removeByValue(104);

        for (int i = 0; i < arrayList.length(); i++) {
            System.out.print(arrayList.getElemOfIndex(i)+ " ");

        }


    }
}