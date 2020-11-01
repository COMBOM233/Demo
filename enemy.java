package lv2;
public class enemy {
    public int num;//敌人种类
    public String name;//名字
    public int hp;//血条
    public int Str;//伤害
    public int Def;//防御
    public int Dex;//闪避
    public int spd;//速度
    public int hrate;//命中
    public int crt;//暴击
    public int worth;//价值
    public int baseloot;//保底掉落
    public int gexp;//给予的exp
    public void creat(){
        if(this.num == 0){//lv1
            name = "僵尸";
            hp = 25;
            Str = 10;
            Def = 0;
            Dex = 2;
            spd = 2;
            hrate = 90;
            crt = 2;
            worth = 30;
            baseloot = 20;
            gexp = 3;
        }
        else if(this.num == 1){//lv1
            name = "骷髅";
            hp = 14;
            Str = 10;
            Def = 0;
            Dex = 2;
            spd = 3;
            hrate = 90;
            crt = 2;
            baseloot = 20;
            worth = 20;
            gexp = 3;
        }
        else if(this.num == 2){//lv2
            name = "盗贼";
            hp = 18;
            Str = 14;
            Def = 2;
            hrate = 95;
            crt = 10;
            spd = 5;
            Dex = 10;
            gexp = 6;
            worth = 50;
            baseloot = 50;
        }
        else if(this.num == 3){//lv2
            name = "疯子";
            hp = 20;
            Str = 8;
            Def = 10;
            hrate = 90;
            spd = 8;
            Dex = 0;
            gexp = 6;
            worth = 250;
            crt = 5;
            baseloot = 0;
        }
        else if(this.num == 4){//lv2 Boss
            name = "屠夫";
            hp = 48;
            Str = 14;
            Def = 15;
            hrate = 75;
            spd = 1;
            Dex = 0;
            gexp = 8;
            worth = 90;
            baseloot = 40;
            crt = 25;
        }
    }
    public void attack(Hero h){//怪物的攻击行为
        System.out.println("---------敌人回合---------");
        //闪避
        if(Math.random()*100>(100 - this.hrate + h.Dex)){
        int dmg = this.Str-h.Def;
            if(Math.random()*100<=this.crt){dmg = dmg*2;
            System.out.println("暴击！");}//暴击系统
            if(dmg<= 0)dmg = 0;//防止负伤害
        h.hp = h.hp-dmg;
        System.out.println("敌人攻击了你，造成了"+dmg+"点伤害");
        System.out.println("你剩余血量"+h.hp);}
        else{
            System.out.println("Miss!你躲过了敌人的攻击");
            System.out.println("你剩余血量"+h.hp);
        }
        if(h.hp<=0){
            System.out.println("U died");
            }
        }
    }
