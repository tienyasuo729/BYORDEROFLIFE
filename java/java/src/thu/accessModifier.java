package thu;

public class accessModifier {
    private double radius;
    private String color;
    public accessModifier(){

    }
    accessModifier(double radius){
        this.radius = radius;
    }
    double getRadius(){
        return radius;
    }
    String getColor(){
        return color;
    }

}
