package Factory02;

import Factory02.person.Person;
import Factory02.types.AType;
import Factory02.types.AbstractItem;
import Factory02.types.BType;
import Factory02.types.CType;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

    public static void main(String[] args) {

//        Person  person = new Person();
//
//        person.create(new BType());
//
//        person.m_weapon.drawWeapon();
//        person.m_bomb.drawBomb();

        List<Person> list = new ArrayList<>();

        Person person = null;
        AbstractItem item = null;

        person = new Person();
        item = new AType();
        person.create(item);
        list.add(person);

        person = new Person();
        item = new BType();
        person.create(item);
        list.add(person);

        person = new Person();
        item = new CType();
        person.create(item);
        list.add(person);

        for (Person p : list) {
            p.m_weapon.drawWeapon();
            p.m_bomb.drawBomb();
        }
    }

}
