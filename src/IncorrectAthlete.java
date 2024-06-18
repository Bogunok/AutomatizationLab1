import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class IncorrectAthlete {
    private String name;
    private int age;
    private String sport;
    public IncorrectAthlete(String name, int age, String sport){
        this.name = name;
        this.age = age;
        this.sport= sport;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSport() {
        return sport;
    }

    public String getInfo(){
        return "Name: " + getName() + ", " + " Age: " + getAge() + ", " + " Sport: "+getSport();
    }

    @Override
    public boolean equals(Object example) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public static void main(String[] args) throws IOException {
        IncorrectAthlete firstAthlete = new IncorrectAthlete("Serhii Melnyk", 25, "Sambo");
        IncorrectAthlete secondAthlete = new IncorrectAthlete("Daria Bilodid", 23, "Judo");
        IncorrectAthlete thirdAthlete = new IncorrectAthlete("Daria Bilodid", 23, "Judo");
        HashMap<IncorrectAthlete, String> incorrectMap = new HashMap<>();
        incorrectMap.put(firstAthlete, "incorrect athlete");
        incorrectMap.put(secondAthlete, "incorrect athlete");
        incorrectMap.put(thirdAthlete, "incorrect athlete");
        System.out.println("First athlete: " + firstAthlete.getInfo());
        System.out.println("Hash: " + firstAthlete.hashCode());
        System.out.println("Second athlete: " + secondAthlete.getInfo());
        System.out.println("Hash: " + secondAthlete.hashCode());
        System.out.println("Third athlete: " + thirdAthlete.getInfo());
        System.out.println("Hash: " + thirdAthlete.hashCode());
        try (FileWriter writer = new FileWriter("incorrectAthletes.txt")) {
            writer.write(firstAthlete.hashCode() +"\n");
            writer.write(secondAthlete.hashCode() +"\n");
            writer.write(thirdAthlete.hashCode() +"\n");
        }
        String falseAnswer = firstAthlete.equals(secondAthlete) ? "Yes" : "No";
        System.out.println(falseAnswer);
        String trueAnswer = secondAthlete.equals(thirdAthlete) ? "Yes" : "No";
        System.out.println(trueAnswer);
        System.out.println("Incorrect map:");
        incorrectMap.forEach((k, v) -> System.out.println(k + " => " + v));
    }
}
