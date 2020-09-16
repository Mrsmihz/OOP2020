public abstract class Bird implements Flyable{
    private double wingSize;
    private double weight;
    private double height;

    public Bird(){
        this(0,0,0);
    }

    public Bird(double wingSize, double weight, double height){
        this.wingSize = wingSize;
        this.weight = weight;
        this.height = height;
    }

    public void eat(double food){
        if (food > 0){
            this.weight += food;
        }
        else{
            System.out.println("input cannot be negative number.");
        }
    }
    public void setwingSize(double w){
        this.wingSize = w;
    }
    public void setWeight(double w){
        this.weight = w;
    }
    public void setHeight(double h){
        this.height = h;
    }
    public double getwingSize(){
        return this.wingSize;
    }
    public double getWeight(){
        return this.weight;
    }
    public double getHeight(){
        return this.height;
    }
}
