public class Cat {
    private String name;
    private String color;
    public double height, weight;
    private void setWeight(double w){
        if (w > 0){
            weight = w;
        }
        else{
            System.out.println("Error");
        }
    }
    private void setHeight(double h){
        if (h > 0){
            height = h;
        }
        else{
            System.out.println("Error");
        }
    }
    private void setName(String n){
        name = n;

    }
    private void setColor(String c){
        color = c;

    }
    public void upWeight(double w){
        if (w > 0){
            double summary = weight + w;
            setWeight(summary);
        }
        else{
            System.out.println("Error");
        }
    }
    public void downWeight(double w){
        if (w > 0){
            double summary = weight - w;
            setWeight(summary);
        }
        else{
            System.out.println("Error");
        }
    }
    public void upHeight(double h){
        if (h > 0){
            double summary = height + h;
            setHeight(summary);
        }
        else{
            System.out.println("Error");
        }
    }
    public void defineCat(String n, String c){
        setName(n);
        setColor(c);
    }
    public void Speak(){
        System.out.println("Name : " + name);
        System.out.println("Color : " + color);
        System.out.printf("Weight : %.1f\n", weight);
        System.out.printf("Height : %.1f\n", height);
    }
}
