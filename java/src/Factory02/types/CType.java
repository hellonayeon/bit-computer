package Factory02.types;

import Factory02.bomb.Bomb;
import Factory02.bomb.C4;
import Factory02.wapon.Sword;
import Factory02.wapon.Weapon;

public class CType implements AbstractItem {
    @Override
    public Weapon createWeapon() {
        return new Sword();
    }

    @Override
    public Bomb createBomb() {
        return new C4();
    }
}
