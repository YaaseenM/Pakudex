import java.util.Arrays;
// Gives out information on the Pakudex
public class Pakudex {
    // Private classes for what is inside the Pakudex and its size for both filled and total
    private Pakuri[] pakuriArray;
    private int capacity;
    private int size = 0;
    // Default constructer for the Pakudex capacity
    public Pakudex() {
        capacity = 20;
        pakuriArray = new Pakuri[capacity];
    }
    // The maximum amount the Pakudex can hold based on user's input
    public Pakudex(int capacity) {
        this.capacity = capacity;
        pakuriArray = new Pakuri[this.capacity];
    }
    // Current amount of Pakuries in the Pakudex
    public int getSize() {
        return size;
    }
    // Return total capacity the Pakudex can hold
    public int getCapacity() {
        return capacity;
    }
    //  Returns the current array of species in the Pakudex
    public String[] getSpeciesArray() {
        // Used to tell the program that there is no Pakuri in the Pakudex
        String[] stringPakuriArray = Arrays.copyOf(pakuriArray, pakuriArray.length, String[].class);
        return stringPakuriArray;
    }
    // Gives the stats of a specific pakuri
    public int[] getStats(String species) {
        int[] stats = new int[3];
        for (int i = 0; i < getSize(); i++) {
            if (pakuriArray[i].getSpecies().equals(species)) {
                stats[0] = pakuriArray[i].getAttack();
                stats[1] = pakuriArray[i].getDefense();
                stats[2] = pakuriArray[i].getSpeed();
                return stats;
            }
        }
        return null;
    }
    // Sort the pakuri array by name
    public void sortPakuri() {
        Arrays.sort(pakuriArray, 0, getSize());
    }
    // Adds a pakuri into the pakudex
    public boolean addPakuri(String species) {
        int currentNum = 0;
        Pakuri newPakuri = new Pakuri(species);
        for (int i = 0; i < pakuriArray.length; i++) {
            if (pakuriArray[i] == null) {
                pakuriArray[i] = newPakuri;
                break;
            } else if (pakuriArray[i].getSpecies().equals(species)) {
                System.out.println("Error: Pakudex already contains this species!\n");
                return false;
            }
            currentNum++;
        }
        size++;
        System.out.println("Pakuri species " + pakuriArray[currentNum].getSpecies() + " successfully added!\n");
        return true;
    }
    // Finds the pakuri in the array and evolves by using another method from Pakuri Class
    public boolean evolveSpecies(String species) {
        for (int i = 0; i < getSize(); i++) {
            if (pakuriArray[i].getSpecies().equals(species)) {
                pakuriArray[i].evolve();
                return true;
            }
        }
        return false;
    }
}