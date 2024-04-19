
/**
 * The Horse class represents a horse in a racing simulator.
 * Each horse has a name, a symbol, distance travelled, a boolean indicating
 * whether it has fallen, and a confidence rating.
 * 
 * @author Mikhael
 * @version 3 april 24
 */
public class Horse {
    // Fields of class Horse
    private String name;
    private char symbol;
    private int distanceTravelled;

    private boolean hasFallen;
    private double confidence;
    
    // Constructor of class Horse
    /**
     * Constructor for objects of class Horse.
     * 
     * @param horseSymbol the symbol representing the horse
     * @param horseName the name of the horse
     * @param horseConfidence the confidence rating of the horse (between 0 and 1)
     */
    public Horse(char horseSymbol, String horseName, double horseConfidence) {
        this.symbol = horseSymbol;
        this.name = horseName;
        this.confidence = horseConfidence;
        this.distanceTravelled = 0;
        this.hasFallen = false;
    }
    
    // Other methods of class Horse
    /**
     * Makes the horse fall.
     */
    public void fall() {
        this.hasFallen = true;
    }
    
    /**
     * Retrieves the confidence rating of the horse.
     * 
     * @return the confidence rating of the horse
     */
    public double getConfidence() {
        return this.confidence;
    }
    
    /**
     * Retrieves the distance travelled by the horse.
     * 
     * @return the distance travelled by the horse
     */
    public int getDistanceTravelled() {
        return this.distanceTravelled;
    }
    
    /**
     * Retrieves the name of the horse.
     * 
     * @return the name of the horse
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Retrieves the symbol representing the horse.
     * 
     * @return the symbol representing the horse
     */
    public char getSymbol() {
        return this.symbol;
    }
    
    /**
     * Moves the horse back to the starting position.
     */
    public void goBackToStart() {
        this.distanceTravelled = 0;
    }
    
    /**
     * Checks if the horse has fallen.
     * 
     * @return true if the horse has fallen, false otherwise
     */
    public boolean hasFallen() {
        return this.hasFallen;
    }

    /**
     * Moves the horse forward by one unit.
     */
    public void moveForward() {
        this.distanceTravelled++;
    }

    /**
     * Sets the confidence rating of the horse.
     * 
     * @param newConfidence the new confidence rating of the horse
     */
    public void setConfidence(double newConfidence) {
        if (newConfidence >= 0 && newConfidence <= 1) {
            this.confidence = newConfidence;
        } else {
            System.out.println("Confidence rating must be between 0 and 1.");
        }
    }
    
    /**
     * Sets the symbol representing the horse.
     * 
     * @param newSymbol the new symbol representing the horse
     */
    public void setSymbol(char newSymbol) {
        this.symbol = newSymbol;
    }
    public void increaseConfidence() {
        this.confidence += 0.1;
    }

    public void decreaseConfidence() {
        this.confidence -= 0.1;
    }
}
