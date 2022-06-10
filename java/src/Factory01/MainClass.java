package Factory01;

import Factory01.animal.Animal;
import Factory01.animal.Cat;
import Factory01.animal.Cow;
import Factory01.animal.Dog;
import Factory01.factory.AnimalFactory;

import java.util.ArrayList;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
//        Animal ani = AnimalFactory.create("야옹이");
//
//        ani.printDescription();
//        Cat cat = (Cat) ani;
//        cat.method();


        List<Animal> list = new ArrayList<>();

        Animal ani = null;
        ani = AnimalFactory.create("야옹이");
        list.add(ani);

        ani = AnimalFactory.create("황소");
        list.add(ani);

        ani = AnimalFactory.create("멍멍이");
        list.add(ani);

        for (int i=0; i<list.size(); i++){
            Animal a = list.get(i);
            a.printDescription();

            if (a instanceof  Cat) {
                ((Cat) a).method();
            }
            else if (a instanceof Cow) {
                ((Cow) a).method();
            }
            else if (a instanceof Dog) {
                ((Dog) a).method();
            }
        }
    }
}
