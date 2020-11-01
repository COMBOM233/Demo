package lv4;
import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Demo {
    public static void main(String[] args){
        System.out.println("============================");
        System.out.println("                            ");
        System.out.println("         输入Start开始       ");
        System.out.println("                            ");
        System.out.println("============================");
        Hero hero = new Hero();//建立玩家角色
        Perk perk = new Perk();//声明技能类
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        if (input.equals("Start")){
            System.out.println("Succeed!");
        }
        else{
            System.out.println("搁这里整活呢");
        }
        System.out.println("你的名字是?");
        Scanner s1 = new Scanner(System.in);
        String name = s1.nextLine();
        hero.name = name;
        System.out.println("你好！"+hero.name);
        Zhuye z = new Zhuye();
        z.zhuye(hero);
    }
}
     class Zhuye {
        public void zhuye(Hero hero){ 
            System.out.print("你的等级为"+hero.lv+"--");
            System.out.print("--你现在拥有"+hero.gold+"G--");
            System.out.println("--剩余HP"+hero.hp+"--");
            hero.tolv();
            System.out.println("---------------干点啥呢---------------");
            System.out.println("1.战斗    2.铁匠铺      3.教堂");
            Scanner s = new Scanner(System.in);
            String input = s.nextLine();
            enemy target = new enemy();//设置一个靶子
            enemy target2 = new enemy();
            enemy target3 = new enemy();
            enemy target4 = new enemy();
            ArrayList many = new ArrayList();
            many.add(target);
            many.add(target2);
            many.add(target3);
            many.add(target4);
            if(input.equals("check")){
                System.out.println(hero.Str);
                System.out.println(hero.crt);
                System.out.println(hero.spd);
                System.out.println(hero.weapon);
            }
            else if(input.equals("1")&&hero.hp>0){
                Battle battle = new Battle();
                int amount = ((int)Math.random()*4)+1;//随机敌人数量
                switch(amount){
                    case 4:
                    target4.num = (int)((Math.random())*5);//随机生成敌人种类
                    case 3:
                    target3.num = (int)((Math.random())*5);
                    case 2:
                    target2.num = (int)((Math.random())*5);
                    case 1:
                    target.num = (int)((Math.random())*5);break;
                }
                battle.fight(hero,target,target2,target3,target4);
            }
            else if(input.equals("1")&&hero.hp<=0){System.out.println("您的状态不足");}
            else if(input.equals("2")){market m = new market();
                m.enter(hero);
                if(m.input.equals("1")){
                    m.weaponevo(hero);
                }
                else if(m.input.equals("2")){
                    m.armorevo(hero);
                }
            }
            else if(input.equals("5")){
                target.num = 4;
                target.creat();
                System.out.println("你遇到了"+target.name);
                while (hero.hp >0 && target.hp>0 ){ 
                    //速度值判定先手系统
                    int hspd = hero.spd;
                    int espd = target.spd;
                    hero.spd += ((Math.random())*8);
                    target.spd += ((Math.random())*8);
                    if(hero.spd>=target.spd){//玩家先手
                    //战斗系统
                    hero.attack(target);
                    if(target.hp<=0)break;
                    target.attack(hero);
                    if(hero.hp<=0)break;
                    hero.spd = hspd;
                    target.spd = espd;}
                    else{//敌人先手
                    target.attack(hero);
                    if(hero.hp<=0)break;
                    hero.attack(target);
                    if(target.hp<=0)break;
                    hero.spd = hspd;
                    target.spd = espd;}
                }
            }
            else if(input.equals("3")){
                System.out.println("你进入了教堂");
                if(hero.lv <= 1){
                    System.out.println("因为教堂对新手有特殊照顾，你得到了免费的治疗");
                    hero.hp = hero.maxhp;
                }
                else{
                    hero.gold -= hero.maxhp-hero.hp;
                    System.out.println("治疗花费了你"+(hero.maxhp-hero.hp)+"G");
                    hero.hp = hero.maxhp;
                }
            }
            this.zhuye(hero);
        }
    }
