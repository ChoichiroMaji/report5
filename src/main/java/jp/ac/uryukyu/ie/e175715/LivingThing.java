package jp.ac.uryukyu.ie.e175715;

public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    public LivingThing (String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    /**
     * getterメソッドと同等。生死をboolean表現しているためメソッド名をisDead()とした。
     * @return boolean
     */
    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getHitPoint(){
        return hitPoint;
    }
    public void setHitPoint(int hitPoint){
        this.hitPoint = hitPoint;
    }
    public int getAttack(){
        return attack;
    }
    public void setAttack(int attack){
        this.attack = attack;
    }
    public boolean isDead() {
        return dead;
    }
    public void setDead(boolean dead){
        this.dead = dead;
    }
    /**
     * LivingThingへ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、opponent.wounded()によりダメージ処理を実行。
     * @param opponent 攻撃対象
     */
    public void attack(LivingThing opponent){
        int damage = (int)(Math.random() * attack);
        if(!isDead()) {
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }

    /**
     * 攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */

    public void wounded(int damage) {
        hitPoint -= damage;
        if( hitPoint < 1 ) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }

}
