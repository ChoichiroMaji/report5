package jp.ac.uryukyu.ie.e175715;

public class Enemy extends LivingThing {
    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     *
     * @param name      モンスター名
     * @param maximumHP モンスターのHP
     * @param attack    モンスターの攻撃力
     */
    public Enemy(String name, int maximumHP, int attack) {
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
        if( getHitPoint() < 1 ) {
            setDead(true);
            System.out.printf("モンスター%sは倒れた。\n", getName());
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
                    damage = damage * 2;
                    if (!isDead()) {
                        System.out.printf("%sの攻撃！痛恨の一撃！！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
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



