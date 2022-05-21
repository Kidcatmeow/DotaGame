import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class Hero {
    String name;
    String attack_msg;
    float HP;
    float currentHP;
    float MP;
    float currentMP;
    float damage;
    float armor;
    float ultimate_cost;
    float ultimate_damage;


    final static char escCode = 0x1B;

    final char topLeft = 9484;
    final char topRight = 9488;
    final char bottomLeft = 9492;
    final char bottomRight = 9496;
    final char dash = 9472;
    final char midLeft = 9500;
    final char midRight = 9508;
    final char bar = 9474;


    //Default constructor
//    this.HP =
//    this.currentHP =
//    this.Mana =
//    this.currentMana =
//    this.Damage =
//    this.armor =
//    this.ultimate_cost =
//    this.ultimate_damage =

    //Constructor
    public Hero (int Hero_no){
        switch(Hero_no){
            case 1:
                name="Axe";
                attack_msg="Axe hits...";
                HP=1000;
                MP=600;
                currentHP = HP;
                currentMP = MP;
                damage=55;
                armor=2;
                ultimate_cost=200;
                ultimate_damage=300;
                break;
            case 2:
                name="Slark";
                attack_msg="zeeeeeee Slarked!";
                HP=800;
                MP=650;
                currentHP = HP;
                currentMP = MP;
                damage=68;
                armor=-1;
                ultimate_cost=300;
                ultimate_damage=400;
                break;
            case 3:
                name="Lion";
                attack_msg="Lion Roaring...";
                HP=1200;
                MP=400;
                currentHP = HP;
                currentMP = MP;
                damage=70;
                armor=-2;
                ultimate_cost=300;
                ultimate_damage=500;
                break;
            case 4:
                name="Lifestealer";
                attack_msg="LS Tagh tagh!";
                HP=1100;
                MP=300;
                currentHP = HP;
                currentMP = MP;
                damage=50;
                armor=3;
                ultimate_cost=100;
                ultimate_damage=300;
                break;
            case 5:
                name="Beastmaster";
                attack_msg="Beastmaster shoooweah";
                HP=800;
                MP=600;
                currentHP = HP;
                currentMP = MP;
                damage=60;
                armor=0;
                ultimate_cost=200;
                ultimate_damage=300;
                break;
            case 6:
                name="Bristleback";
                attack_msg="BB is coming...";
                HP=1300;
                MP=200;
                currentHP = HP;
                currentMP = MP;
                damage=48;
                armor=4;
                ultimate_cost=150;
                ultimate_damage=800;
                break;
            case 7:
                name="Tiny";
                attack_msg="Tiny punch!";
                HP=1100;
                MP=400;
                currentHP = HP;
                currentMP = MP;
                damage=55;
                armor=4;
                ultimate_cost=130;
                ultimate_damage=300;
                break;
            case 8:
                name="Phoenix";
                attack_msg="Hoooooooooowa Phoenix";
                HP=800;
                MP=800;
                currentHP = HP;
                currentMP = MP;
                damage=75;
                armor=0;
                ultimate_cost=250;
                ultimate_damage=350;
                break;
            case 9:
                name="Medusa";
                attack_msg="Die by Medusa!";
                HP=1000;
                MP=700;
                currentHP = HP;
                currentMP = MP;
                damage=50;
                armor=1;
                ultimate_cost=350;
                ultimate_damage=400;
                break;
            case 10:
                name="Mirana";
                attack_msg="Mirana!Get my mighty arrow.";
                HP=900;
                MP=800;
                currentHP = HP;
                currentMP = MP;
                damage=55;
                armor=1;
                ultimate_cost=270;
                ultimate_damage=320;
                break;
        }
    }

    //Accessors
    public void setName(String new_name) {
        name = new_name;
    }

    public void setAttack_msg(String new_attack_msg) {
        attack_msg = new_attack_msg;
    }

    public void setHP(float new_HP) {
        HP = new_HP;
    }

    public void setMP(float new_MP) {
        MP = new_MP;
    }

    public void setDamage(float new_Damage) {
        damage = new_Damage;
    }

    public void setArmor(float new_Armor) {
        armor = new_Armor;
    }

    public void setUltimate_cost(float new_Ultimate_cost) {
        ultimate_cost = new_Ultimate_cost;
    }

    public void setUltimate_damage(float new_Ultimate_damage) {
        ultimate_damage = new_Ultimate_damage;
    }

    public void setCurrentHP(float new_CurrentHP){
        currentHP = new_CurrentHP;
    }

    public void setCurrentMP(float new_CurrentMP){
        currentMP = new_CurrentMP;
    }

    //Mutators
    public String getName(){
        return this.name;
    }

    public String getAttack_msg(){
        return this.attack_msg;
    }

    public Float getHP(){
        return this.HP;
    }

    public Float getMP(){
        return this.MP;
    }

    public Float getDamage(){
        return this.damage;
    }

    public Float getArmor(){
        return this.armor;
    }

    public Float getUltimate_cost(){
        return this.ultimate_cost;
    }

    public Float getUltimate_damage(){
        return this.ultimate_damage;
    }

    public Float getCurrentHP(){
        return this.currentHP;
    }

    public Float getCurrentMP(){
        return this.currentMP;
    }


    //Actions

    public void attack(){
        System.out.println(attack_msg);
    }

    public boolean ultimate(){
        if (currentMP >= ultimate_cost){
            System.out.println("Ulti!"+attack_msg);
            currentMP -= ultimate_cost;
            return true;
        }
        else {
            System.out.println("Not enough MP");
            return false;
        }
    }

    public boolean isAlive(){
        if(currentHP > 0){
            return true;
        }
        else {
            return false;
        }
    }

    public void ultimatedBy(Hero hero){
        if(this.isAlive()){
            currentHP = currentHP  - ((hero.ultimate_damage * 5) / (armor + 3));
            if(! this.isAlive())
            hero.currentMP += 200;
        }
        else {
            System.out.println("Sorry " + name + "is dead. You cannot cast ultimate on the dead");
        }

    }

    public void getAttackedBy(Hero hero){
        if(this.isAlive()){
            currentHP = currentHP  - ((hero.damage * 5) / (armor + 3));
            if(! this.isAlive())
            hero.addMana(200);
        }
        else {
            System.out.println("Sorry" + name + "is dead. You cannot cast attack on the dead");
        }
    }


    public void addMana(float Mana){
        this.currentMP += Mana;
    }
}
