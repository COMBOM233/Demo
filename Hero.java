package lv2;
import java.util.Scanner;
import java.util.*;
public class Hero {
    public int weapon=0;
    public int armor=0;
    public int maxhp=20;
    public int lv=0;//等级
    public int exp=0;//经验值
    public int gold=50;//钱
    public String name;//名字
    public int hp=20;//血条
    public int Str=8;//伤害
    public int Def=3;//防御
    public int Dex=2;//闪避
    public int spd=5;//速度
    public int hrate=95;//命中
    public int crt=5;//暴击
    public int sp=100;//蓝条
    public int np=0;//大招充能
    public int Perk1;
    public int Perk2;
    public int Perk3;
    public int Ostr = Str;//记录原始伤害数值
    public void showName(){
        System.out.println(name);
    }
    public void attack(enemy t){//攻击行为
        System.out.println("---------你的回合---------");
        System.out.println("---------敌人血量:"+t.hp+"------");
        System.out.println("1.放血("+(this.Str*1.2)+")2.劈砍("+(this.Str*0.8+t.Def)+")3.战场医疗");
        Scanner s = new Scanner(System.in);
        int input = s.nextInt();
        if(input == 1){
            System.out.println("使用技能：放血");
            this.Str = (int)(this.Str*1.2);
        }
        else if(input == 2){
            System.out.println("使用技能：劈砍");
            this.Str = this.Str+t.Def;
        }
        else if(input == 3){
            System.out.println("使用技能：战场医疗");
            this.hp += Str;
            Str = (int)(Str*0.1);
            System.out.println("你牺牲部分伤害回复了"+Str+"hp");
            if(hp>maxhp){hp = maxhp;}
        }
        /*
        *接下来是攻击补正系统
        */
        int con = (int)((Math.random())*2);
        if (con==0){//负补正
            this.Str = this.Str-(int)((Math.random())*5);
        }
        else{//正补正
            this.Str = this.Str+(int)((Math.random())*4);
        }
        int dmg = this.Str-t.Def;
        if(dmg<0){
            dmg=0;//防止负伤害
        }
        //闪避系统
        if(Math.random()*100>(100 - this.hrate + t.Dex)){
        //暴击系统
        if(Math.random()*100<=this.crt){dmg = dmg*2;
        System.out.println("暴击！");}
        t.hp = t.hp - dmg;//造成伤害
        this.Str = Ostr;//将攻击力重置
        System.out.println("你攻击了"+t.name+",造成"+dmg+"点伤害");
        System.out.println(t.name+"剩余血量为"+t.hp);}
        else{
            System.out.println("Miss!敌人躲过了你的攻击");
            System.out.println(t.name+"剩余血量为"+t.hp);}
        if(t.hp<=0){
            System.out.println("U won");
            //if(p[0]==2){//实现资源回收的效果
            //    System.out.println("perk1");
            //}
        }
    }
    public void loot(enemy t){//战利品搜刮
        this.gold += (int)Math.random()*t.worth+t.baseloot;
        System.out.println("在敌人尸体上搜刮得到了"+(int)Math.random()*t.worth+t.baseloot+"G");
    }
    public void gainexp(enemy t){//等级系统
        this.exp += t.gexp;
        System.out.println("获得了"+t.gexp+"点经验值");
        if(exp >= 10&& this.lv == 0){
            this.lv += 1;
            exp = 0;
        }
        else if(exp >= 28&&this.lv == 1){
            this.lv += 1;
            exp = 0;
        }
        else if(exp >= 50&&this.lv == 2){
            this.lv += 1;
            exp = 0;
        }
        else if(exp >= 72&&this.lv == 3){
            this.lv += 1;
            exp = 0;
        }
        else if(exp >= 100&&this.lv == 4){
            this.lv += 1;
            exp = 0;
        }
    }
    public void tolv(){
        if(lv == 0){
            System.out.println("--下次升级还需"+(10-exp)+"点exp--");
        }
        else if (lv == 1){
            System.out.println("下次升级还需--"+(28-exp)+"点exp--");
        }
        else if (lv == 2){
            System.out.println("下次升级还需--"+(50-exp)+"点exp--");
        }
        else if (lv == 3){
            System.out.println("下次升级还需--"+(72-exp)+"点exp--");
        }
        else if (lv == 4){
            System.out.println("下次升级还需--"+(100-exp)+"点exp--");
        }
        else if (lv == 5){
            System.out.println("爷满级了");
        }
    }
}



