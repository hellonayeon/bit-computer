package Factory02.person;

import Factory02.bomb.Bomb;
import Factory02.types.AbstractItem;
import Factory02.wapon.Weapon;

public class Person {

    public Weapon m_weapon;
    public Bomb m_bomb;

    public void create(AbstractItem ai) {
        m_weapon = ai.createWeapon();
        m_bomb = ai.createBomb();
    }
}
