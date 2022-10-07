// Gives information on a specific Pakuri
public class Pakuri implements Comparable<Pakuri> {
    // Private classes to list out stats of the species and its name
    private String species;
    private int attack;
    private int defense;
    private int speed;
    // Give stats to species
    public Pakuri(String species) {
        this.species = species;
        attack = (species.length() * 7) + 9;
        defense = (species.length() * 5) + 17;
        speed = (species.length() * 6) + 13;
    }
    // Return methods to get data on the species
    public String getSpecies() {
        return species;
    }

    public int getAttack() {
        return attack;
    }
    // Not sure what this method was for but  here it is
    public void setAttack(int newAttack) {
        attack = newAttack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }
    // Change attributes on the species when the evolve method is called
    public void evolve() {
        attack = attack * 2;
        defense = defense * 4;
        speed = speed * 3;
    }
    // This method is used to sort species by name.
    @Override
    public int compareTo(Pakuri target) {
        return this.species.compareTo(target.species);
    }
}