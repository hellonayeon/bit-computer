package Factory01.factory;

import Factory01.animal.Animal;
import Factory01.animal.Cat;
import Factory01.animal.Cow;
import Factory01.animal.Dog;

public class AnimalFactory {

    public static Animal create(String animalName) {

        if (animalName.equals("")) {
            System.out.println("생성할 클래스가 없습니다.");
        }

        else if (animalName.equals("야옹이")) {
            return new Cat();
        }
        else if (animalName.equals("멍멍이")) {
            return new Dog();
        }
        else if (animalName.equals("황소")) {
            return new Cow();
        }

        return null;
    }
}
