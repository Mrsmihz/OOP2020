public class Student {
    public String name = new String();
    public double MidtermScore;
    public double FinalScore;
    public void showGrade(){
        if ((MidtermScore > 100 || MidtermScore < 0) || (FinalScore > 100 || FinalScore < 0)){
            System.out.println("Invalid Midterm Score or Invalid Final Score");
        }
        else{
            double score = MidtermScore*0.4 + FinalScore*0.4 + 20;
            char grade = calc(score);
            System.out.println("Your Grade is "+ grade);

        }
    }
    private char calc(double score){
        char result;
        if (score <= 100 && score >= 80){
            result = 'A';
        }
        else if (score < 80 && score >= 70){
            result = 'B';
        }
        else if (score < 70 && score >= 60){
            result = 'C';
        }
        else if (score < 60 && score >= 50){
            result = 'D';
        }
        else{
            result = 'F';
        }
        return result;
    }
}
