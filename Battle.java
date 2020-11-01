package lv4;
import java.util.ArrayList;
import java.util.List;
public class Battle{
    public void fight(Hero hero,enemy target,enemy target2,enemy target3,enemy target4){
        target.creat();//生成一个敌人
        target2.creat();
        target3.creat();
        target4.creat();
                System.out.println("你遇到了"+target.name);
                while (hero.hp >0 && target.hp>0 ){ 
                    //速度值判定先手系统
                    int hspd = hero.spd;
                    int espd = target.spd;
                    //hero.spd += ((Math.random())*8);
                    //target.spd += ((Math.random())*8);
                    //target2.spd += ((Math.random())*8);
                    //target3.spd += ((Math.random())*8);
                    //target4.spd += ((Math.random())*8);
                    //ArrayList spdcpr = new ArrayList();//创建数组用于速度比较
                    //spdcpr.add(target.spd);
                    //spdcpr.add(target2.spd);
                    //spdcpr.add(target3.spd);
                    //spdcpr.add(target4.spd);
                    //int m = Collections.max(spdcpr);
                    if(hero.spd>=target.spd){//玩家先手
                    //战斗系统
                    hero.attack(target);
                    if(target.hp<=0){
                        hero.gainexp(target);
                        hero.loot(target);
                        break;}
                    target.attack(hero);
                    if(hero.hp<=0)break;
                    hero.spd = hspd;
                    target.spd = espd;}
                    else{//敌人先手
                    target.attack(hero);
                    if(hero.hp<=0)break;
                    hero.attack(target);
                    if(target.hp<=0){
                        hero.gainexp(target);
                        hero.loot(target);
                        break;}
                    hero.spd = hspd;
                    target.spd = espd;}
                }
                System.out.println("finish");
            }
    }


