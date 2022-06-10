package Factory02.types;

import Factory02.bomb.Bomb;
import Factory02.wapon.Weapon;

public interface AbstractItem {

    public Weapon createWeapon();

    public Bomb createBomb();

}
