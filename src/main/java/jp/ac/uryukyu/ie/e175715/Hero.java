package jp.ac.uryukyu.ie.e175715;

public class Hero extends LivingThing {

    public Hero(String name, int maximumHP, int attack) {
        super(name, maximumHP, attack);
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     *
     * @param damage 受けたダメージ
     */
    @Override
    public void wounded(int damage) {
        setHitPoint(getHitPoint() - damage);
        if (getHitPoint() < 1) {
            setDead(true);
            System.out.printf("勇者%sは道半ばで力尽きてしまった。\n", getName());
        }
    }

    @Override
    public void attack(LivingThing opponent) {
        int damage = (int) (Math.random() * getAttack());
        int probability = (int) (Math.random() * 10);
        if (damage == 0) {
            if (!isDead()) {
                System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した！\n", getName(), opponent.getName());
                opponent.wounded(damage);
            }
        } else {
            switch (probability) {
                case 1:
                case 2:
                case 3:
                case 4:
                    damage = damage * 2;
                    if (!isDead()) {
                        System.out.printf("%sの攻撃！会心の一撃！！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
                        opponent.wounded(damage);
                        break;
                    }
                default:
                    if (!isDead()) {
                        System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
                        opponent.wounded(damage);
                    }
            }
        }
    }
}