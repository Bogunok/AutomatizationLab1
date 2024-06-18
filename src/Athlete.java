import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
public class Athlete {
    private String name;
    private int age;
    private String sport;
    public Athlete(String name, int age, String sport){
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
        if (this == example) return true;
        if (example == null || getClass() != example.getClass()) return false;
        Athlete that = (Athlete) example;
        return name == that.name && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public static void main(String[] args) throws IOException {
        Athlete firstAthlete = new Athlete("Serhii Melnyk", 25, "Sambo");
        Athlete secondAthlete = new Athlete("Daria Bilodid", 23, "Judo");
        Athlete thirdAthlete = new Athlete("Daria Bilodid", 23, "Judo");
        HashMap<Athlete, String> correctMap = new HashMap<>();
        correctMap.put(firstAthlete, "correct athlete");
        correctMap.put(secondAthlete, "correct athlete");
        correctMap.put(thirdAthlete, "correct athlete");
        System.out.println("First athlete: " + firstAthlete.getInfo());
        System.out.println("Hash: " + firstAthlete.hashCode());
        System.out.println("Second athlete: " + secondAthlete.getInfo());
        System.out.println("Hash: " + secondAthlete.hashCode());
        System.out.println("Third athlete: " + thirdAthlete.getInfo());
        System.out.println("Hash: " + thirdAthlete.hashCode());
        try (FileWriter writer = new FileWriter("correctAthletes.txt")) {
            writer.write(firstAthlete.hashCode() +"\n");
            writer.write(secondAthlete.hashCode() +"\n");
            writer.write(thirdAthlete.hashCode() +"\n");
        }
        String falseAnswer = firstAthlete.equals(secondAthlete) ? "Yes" : "No";
        System.out.println(falseAnswer);
        String trueAnswer = secondAthlete.equals(thirdAthlete) ? "Yes" : "No";
        System.out.println(trueAnswer);
        System.out.println("Correct map:");
        correctMap.forEach((k, v) -> System.out.println(k + " => " + v));
    }
}