package chapter8;

import java.util.ArrayList;

public class Banner {
    public static void main(String[] args) {
        ArrayList<Person> personsList = new ArrayList<>();
        Person persons[] = new Person [15_000];
        persons[0] = new Student ("John Smith", "900000000", "123, Street, city, state, zip, usa","jsmith@samford.edu");
        persons[1] = new Student ("Jane Smith", "900000001", "123, Street, city, state, zip, usa","jsmith2@samford.edu");
        persons[2] = new Staff ("Mr clean", "700000001","123,clean street, state, city, usa","mclean@samford.edu");
        persons[3] = new Faculty ("Dr Fortnite", "800000001", "battle pass", "jfortnite@samford.edu");




    for (Person person : persons){
        System.out.println("Name "+ person.name);
        System.out.println("Name: "+ person.getName());
        System.out.println("Type: " + person.getType());
        


    }
}
    
}
