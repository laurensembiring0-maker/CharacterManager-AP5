
package com.unpri.charactermanager.model;

public class Character {
    private int id;
    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int attackPower;
    private int mana;

    // Constructor utama
    public Character(String name, CharacterType type, int level) {
        this.name = name;
        this.type = type;
        setLevel(level);
        this.mana = 0;
    }

    // Constructor alternatif
    public Character(int id, String name,
                     CharacterType type, int level) {
        this(name, type, level);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CharacterType getType() {
        return type;
    }

    public void setType(CharacterType type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException(
                "Level minimal adalah 1");
        }

        this.level = level;
        this.hitPoints = calculateBaseHP();
        this.attackPower = calculateBaseAttack();
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException(
                "Mana tidak boleh negatif");
        }
        this.mana = mana;
    }

    public boolean isAlive() {
        return hitPoints > 0;
    }

    private int calculateBaseHP() {
        return 100 + (level * 20);
    }

    private int calculateBaseAttack() {
        return 10 + (level * 5);
    }

    @Override
    public String toString() {
        return "Character{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", type=" + type +
            ", level=" + level +
            ", hitPoints=" + hitPoints +
            ", attackPower=" + attackPower +
            ", mana=" + mana +
            '}';
    }
    public boolean equals(Object obj) {
        if (this == obj) return true;                    
        if (!(obj instanceof Character)) return false;  
        Character other = (Character) obj;                
        return this.name.equals(other.name);               
    }
    
}
