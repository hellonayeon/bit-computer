package Factory02.types;

import Factory02.bomb.Bomb;
import Factory02.bomb.C4;
import Factory02.wapon.Gun;
import Factory02.wapon.Weapon;

public class AType implements AbstractItem {
    @Override
    public Weapon createWeapon() {
        return new Gun();
    }

    @Override
    public Bomb createBomb() {
        return new C4();
    }
}
