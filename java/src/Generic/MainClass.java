package Generic;

public class MainClass {
    public static void main(String[] args) {
        /*
        * Generic: "자료형의 변수"
                   같은 클래스에서 다양한 자료(Integer)형을 사용하고 싶을 때 정의하는 요소
        *
        * */
        Box<Integer> box = new Box<Integer>(123);
        System.out.println(box.getTemp() + 1);

        Box<String> sbox = new Box<String>("hello");
        System.out.println(sbox.getTemp() + 1);

        BoxMap<String, Integer> bmap = new BoxMap<>("홍길동", 245);
        System.out.println(bmap.getName());
        System.out.println(bmap.getValue());
    }
}

class Box<T> {
    T temp;

    public Box(T temp) {
        this.temp = temp;
    }

    public T getTemp() {
        return temp;
    }
}

class BoxMap<K, V> {
    K name;
    V value;

    public BoxMap(K name, V value) {
        this.name = name;
        this.value = value;
    }

    public K getName() {
        return name;
    }

    public V getValue() {
        return value;
    }
}
