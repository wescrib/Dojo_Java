public class Project { 
    private String name;
    private String description;
    private double cost;

    public Project(){
        name = "PROJET NAME HERE";
        description = "DESCRIPTION HERE";
        cost = 0.0;
    }

    public Project(String name){
        this.name = name;
    }

    public Project(String name, String description){
        this.name = name;
        this.description = description;
    }


    public Project(String name, String description, double cost) {
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    public void setName(String name){
        this.name = name;
        // return "The project name has been set to " + this.name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description){
        this.description = description;
        // return "Description: " + description;
    }

    public String getDescription() {
        return description;
    }

    public void setCost(double cost) {
        this.cost = cost;
        // return "The has been estimated at $" + cost;
    }

    public double getCost() {
        return cost;
    }

    public String toString() {
        return this.name + " ($" +this.cost + ") : " + this.description;
    }

}