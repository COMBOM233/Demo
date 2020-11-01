package lv2;

import java.util.Scanner;

public class market {//铁匠铺
    String input;
    public void enter(Hero hero){
        System.out.println("你好啊！"+hero.name+"想做点啥？");
        System.out.println("1.我想升级我的武器---2.我想升级我的防具---3.我想给我的武器附魔---4.我想给我的防具附魔");
        Scanner s = new Scanner(System.in);
        input = s.nextLine();
    }
    public void weaponevo(Hero hero){
        if(hero.lv>=hero.weapon+1){
            hero.gold -= 50*(hero.weapon+1);
            hero.weapon += 1;
            System.out.println("你花费了"+50*(hero.weapon+1)+"G将武器升为Lv."+hero.weapon);
            hero.Str += hero.Str*0.4;
            hero.Ostr = hero.Str;
            hero.crt += 5;
            hero.spd += 5;
            hero.weapon += 1;}
    }
    public void armorevo(Hero hero){
        if(hero.lv>=hero.armor+1){
            hero.gold -= 50*(hero.armor+1);
            hero.armor += 1;
            System.out.println("你花费了"+50*(hero.weapon+1)+"G将防具升为Lv."+hero.armor);
            hero.Def += hero.Def*0.5;
            hero.Dex += 5;
            hero.hp +=10;
            hero.maxhp += 10;
            hero.spd +=3;}
        else{System.out.println("等级不足以升级防具");}
    }
}
