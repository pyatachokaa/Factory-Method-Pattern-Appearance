import java.util.ArrayList;
import java.util.List;

class Appearance {
    private String appearanceType;

    public Appearance(String appearanceType) {
        this.appearanceType = appearanceType;
    }

    public String getAppearanceType() {
        return appearanceType;
    }

    public void setAppearanceType(String appearanceType) {
        this.appearanceType = appearanceType;
    }
}

class Ability {
    private String abilityName;

    public Ability(String abilityName) {
        this.abilityName = abilityName;
    }

    public String getAbilityName() {
        return abilityName;
    }

    public void setAbilityName(String abilityName) {
        this.abilityName = abilityName;
    }
}

class Equipment {
    private String equipmentType;

    public Equipment(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }
}

class Attributes {
    private int strength;
    private int agility;
    private int intelligence;

    public Attributes(int strength, int agility, int intelligence) {
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
}

class Character {
    private String name;
    private Appearance appearance;
    private List<Ability> abilities;
    private List<Equipment> equipment;
    private Attributes attributes;

    public Character(String name, Appearance appearance, List<Ability> abilities, List<Equipment> equipment, Attributes attributes) {
        this.name = name;
        this.appearance = appearance;
        this.abilities = abilities;
        this.equipment = equipment;
        this.attributes = attributes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Appearance getAppearance() {
        return appearance;
    }

    public void setAppearance(Appearance appearance) {
        this.appearance = appearance;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public List<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }
}

abstract class CharacterFactory {
    public abstract Character createCharacter(String name);
}

class WarriorFactory extends CharacterFactory {
    @Override
    public Character createCharacter(String name) {
        Appearance appearance = new Appearance("Warrior");
        List<Ability> abilities = new ArrayList<>();
        abilities.add(new Ability("Slash"));
        abilities.add(new Ability("Block"));
        List<Equipment> equipment = new ArrayList<>();
        equipment.add(new Equipment("Sword"));
        Attributes attributes = new Attributes(10, 5, 3);
        return new Character(name, appearance, abilities, equipment, attributes);
    }
}

class MageFactory extends CharacterFactory {
    @Override
    public Character createCharacter(String name) {
        Appearance appearance = new Appearance("Mage");
        List<Ability> abilities = new ArrayList<>();
        abilities.add(new Ability("Fireball"));
        abilities.add(new Ability("Teleport"));
        List<Equipment> equipment = new ArrayList<>();
        equipment.add(new Equipment("Staff"));
        Attributes attributes = new Attributes(3, 5, 10);
        return new Character(name, appearance, abilities, equipment, attributes);
    }
}

class ArcherFactory extends CharacterFactory {
    @Override
    public Character createCharacter(String name) {
        Appearance appearance = new Appearance("Archer");
        List<Ability> abilities = new ArrayList<>();
        abilities.add(new Ability("Shoot"));
        abilities.add(new Ability("Dodge"));
        List<Equipment> equipment = new ArrayList<>();
        equipment.add(new Equipment("Bow"));
        Attributes attributes = new Attributes(5, 10, 3);
        return new Character(name, appearance, abilities, equipment, attributes);
    }
}

class CharacterCreator {
    private CharacterFactory factory;

    public void setFactory(CharacterFactory factory) {
        this.factory = factory;
    }

    public Character createCharacter(String name) {
        return factory.createCharacter(name);
    }
}

class CharacterCustomizationSystem {
    public static void customizeCharacter(Character character, Appearance appearance, List<Ability> abilities, List<Equipment> equipment) {
        character.setAppearance(appearance);
        character.setAbilities(abilities);
        character.setEquipment(equipment);
    }
}

// Step 8: Expand the game by adding new character classes in the future
class ThiefFactory extends CharacterFactory {
    @Override
    public Character createCharacter(String name) {
        Appearance appearance = new Appearance("Thief");
        List<Ability> abilities = new ArrayList<>();
        abilities.add(new Ability("Stealth"));
        abilities.add(new Ability("Backstab"));
        List<Equipment> equipment = new ArrayList<>();
        equipment.add(new Equipment("Dagger"));
        Attributes attributes = new Attributes(6, 8, 5);
        return new Character(name, appearance, abilities, equipment, attributes);
    }
}

class main {
    public static void main(String[] args) {
        CharacterCreator creator = new CharacterCreator();

        creator.setFactory(new WarriorFactory());
        Character warrior = creator.createCharacter("Warrior Bob");

        creator.setFactory(new MageFactory());
        Character mage = creator.createCharacter("Mage Alice");

        creator.setFactory(new ArcherFactory());
        Character archer = creator.createCharacter("Archer Charlie");

        Appearance newAppearance = new Appearance("Warrior with Armor");
        List<Ability> newAbilities = new ArrayList<>();
        newAbilities.add(new Ability("Charge"));
        newAbilities.add(new Ability("Parry"));
        List<Equipment> newEquipment = new ArrayList<>();
        newEquipment.add(new Equipment("Greatsword"));

        CharacterCustomizationSystem.customizeCharacter(warrior, newAppearance, newAbilities, newEquipment);

        // Adding a new character class - Thief
        creator.setFactory(new ThiefFactory());
        Character thief = creator.createCharacter("Thief David");

        // Output the characteristics of each character
        System.out.println("Character: " + warrior.getName());
        System.out.println("Appearance: " + warrior.getAppearance().getAppearanceType());
        System.out.println("Abilities: ");
        for (Ability ability : warrior.getAbilities()) {
            System.out.println("- " + ability.getAbilityName());
        }
        System.out.println("Equipment: ");
        for (Equipment equipment : warrior.getEquipment()) {
            System.out.println("- " + equipment.getEquipmentType());
        }
        System.out.println("Attributes: ");
        Attributes warriorAttributes = warrior.getAttributes();
        System.out.println("- Strength: " + warriorAttributes.getStrength());
        System.out.println("- Agility: " + warriorAttributes.getAgility());
        System.out.println("- Intelligence: " + warriorAttributes.getIntelligence());

        System.out.println();

        System.out.println("Character: " + mage.getName());
        System.out.println("Appearance: " + mage.getAppearance().getAppearanceType());
        System.out.println("Abilities: ");
        for (Ability ability : mage.getAbilities()) {
            System.out.println("- " + ability.getAbilityName());
        }
        System.out.println("Equipment: ");
        for (Equipment equipment : mage.getEquipment()) {
            System.out.println("- " + equipment.getEquipmentType());
        }
        System.out.println("Attributes: ");
        Attributes mageAttributes = mage.getAttributes();
        System.out.println("- Strength: " + mageAttributes.getStrength());
        System.out.println("- Agility: " + mageAttributes.getAgility());
        System.out.println("- Intelligence: " + mageAttributes.getIntelligence());

        System.out.println();

        System.out.println("Character: " + archer.getName());
        System.out.println("Appearance: " + archer.getAppearance().getAppearanceType());
        System.out.println("Abilities: ");
        for (Ability ability : archer.getAbilities()) {
            System.out.println("- " + ability.getAbilityName());
        }
        System.out.println("Equipment: ");
        for (Equipment equipment : archer.getEquipment()) {
            System.out.println("- " + equipment.getEquipmentType());
        }
        System.out.println("Attributes: ");
        Attributes archerAttributes = archer.getAttributes();
        System.out.println("- Strength: " + archerAttributes.getStrength());
        System.out.println("- Agility: " + archerAttributes.getAgility());
        System.out.println("- Intelligence: " + archerAttributes.getIntelligence());

        System.out.println();

        System.out.println("Character: " + thief.getName());
        System.out.println("Appearance: " + thief.getAppearance().getAppearanceType());
        System.out.println("Abilities: ");
        for (Ability ability : thief.getAbilities()) {
            System.out.println("- " + ability.getAbilityName());
        }
        System.out.println("Equipment: ");
        for (Equipment equipment : thief.getEquipment()) {
            System.out.println("- " + equipment.getEquipmentType());
        }
        System.out.println("Attributes: ");
        Attributes thiefAttributes = thief.getAttributes();
        System.out.println("- Strength: " + thiefAttributes.getStrength());
        System.out.println("- Agility: " + thiefAttributes.getAgility());
        System.out.println("- Intelligence: " + thiefAttributes.getIntelligence());
    }
}

