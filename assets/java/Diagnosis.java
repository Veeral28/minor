package app;

public class Diagnosis {

    private String name; // Name of the diagnosis (or disease)
    private String description; // Description of the diagnosis
    private String advice; // Any advice or treatment

    // Constructor to initialize the diagnosis details
    public Diagnosis(String name, String description, String advice) {
        this.name = name;
        this.description = description;
        this.advice = advice;
    }

    // Getter for the name of the diagnosis
    public String getName() {
        return name;
    }

    // Getter for the description of the diagnosis
    public String getDescription() {
        return description;
    }

    // Getter for the advice or treatment
    public String getAdvice() {
        return advice;
    }

    // Setter for the name of the diagnosis
    public void setName(String name) {
        this.name = name;
    }

    // Setter for the description of the diagnosis
    public void setDescription(String description) {
        this.description = description;
    }

    // Setter for the advice or treatment
    public void setAdvice(String advice) {
        this.advice = advice;
    }

    // Method to display the diagnosis information (optional)
    @Override
    public String toString() {
        return "Diagnosis: " + name + "\nDescription: " + description + "\nAdvice: " + advice;
    }
}
