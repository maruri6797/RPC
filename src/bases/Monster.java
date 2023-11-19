package bases;

import utils.Dice;

public abstract class Monster extends Living {
	public Monster(String name, String weapon) {
		super(name, weapon);
	}
	
	@Override
	public void attack(Living target) {
		int damage = Dice.get(1, 10) * this.offensive;
		target.hp -= damage;
		System.out.println("「" + this.name + "」が「" + this.weapon + "」で攻撃！「" + target.name + "」に" + damage + "のダメージを与えた。");
	}
}
