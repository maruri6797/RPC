package demo;

import java.util.ArrayList;
import java.util.List;

import bases.Human;
import bases.Monster;
import humans.Brave;
import humans.Fighter;
import humans.Wizard;
import monsters.Dragon;
import monsters.Oak;
import monsters.Slime;
import utils.Dice;

public class Main {
	public static void main(String[] args) {
		System.out.println("★★ ==== 戦いの開始だ！！ ==== ★★");
		Brave brave = new Brave("沖田総司", "剣");
		Fighter fighter = new Fighter("金太郎", "斧");
		Wizard wizard = new Wizard("安倍晴明", "魔法");
		List<Human> humans = new ArrayList<>();
		humans.add(brave);
		humans.add(fighter);
		humans.add(wizard);
		
		Slime slime = new Slime("キングスライム", "体当たり");
		Oak oak = new Oak("オークキング", "槍");
		Dragon dragon = new Dragon("紅龍", "炎");
		List<Monster> monsters = new ArrayList<>();
		monsters.add(slime);
		monsters.add(oak);
		monsters.add(dragon);
		
		showGroupInfos(humans, monsters);
		
		int count = 1;
		while (true) {
			System.out.printf("\n★ 第%d回線 ==========\n", count);
			System.out.println("\n[人間のターン！]\n");
			Human human = choiceHuman(humans);
			Monster monster = choiceMonster(monsters);
			human.attack(monster);
			if (monster.getHp() == 0) {
				monsters.remove(monster);
				System.out.println("★　「" + monster.getName() + "」は倒れた。");
			}
			if (monsters.size() == 0) {
				System.out.println("★★ ==== 決着がついた！！ ==== ★★");
				System.out.println("#### 人間たちは勝利した！！ ####");
			}
			
			System.out.println("\n[モンスターのターン！]\n");
			Human human2 = choiceHuman(humans);
			Monster monster2 = choiceMonster(monsters);
			monster2.attack(human2);
			if (human2.getHp() == 0) {
				humans.remove(human2);
				System.out.println("★　「" + human2.getName() + "」は倒れた。");
			}
			if (humans.size() == 0) {
				System.out.println("★★ ==== 決着がついた！！ ==== ★★");
				System.out.println("#### モンスターたちは勝利した！！ ####");
			}
			showGroupInfos(humans, monsters);
			count++;
		}
	}		
		
	public static Human choiceHuman(List<Human> humans) {
		Human human = humans.get(Dice.get(0, humans.size() -1));
		System.out.printf("人間グループから 「%s」 のお出ましだ！\n", human.getName());
		return human;
	}
	
	public static Monster choiceMonster(List<Monster> monsters) {
		Monster monster = monsters.get(Dice.get(0, monsters.size() -1));
		System.out.printf("モンスターグループから 「%s」 のお出ましだ！\n", monster.getName());
		return monster;
	}
	
	public static void showGroupInfos(List<Human> humans, List<Monster> monsters) {
		System.out.println("\n## === グループ情報 === ##");
		System.out.printf("#[人間グループ]: %d人\n", humans.size());
		for (Human human : humans) {
			System.out.println(human);
		}
		
		System.out.printf("\n#[モンスターグループ]: %d人\n", monsters.size());
		for (Monster monster : monsters) {
			System.out.println(monster);
		}
	}
}
