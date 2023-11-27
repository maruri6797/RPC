package bases;

import utils.Dice;

public abstract class Human extends Living {
	public Human(String name, String weapon) {
		super(name, weapon);
	}
	
	@Override
	public void attack(Living target) {
		int damage = Dice.get(1, 10) * super.offensive;
		target.hp -= damage;
		super.offensive -= 1;
		System.out.println("「" + super.name + "」が「" + super.weapon + "」で攻撃！「" + target.name + "」に" + damage + "のダメージを与えた。");
		System.out.println("しかし自分の攻撃力も1減少した。");
	}
}
