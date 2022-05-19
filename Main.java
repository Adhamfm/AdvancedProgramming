import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Organizer organizer = new Organizer();
        organizer.startOperation();
        for (int i = 0; i < BigObject.bigObjectList.size(); i++) {
            System.out.println("Object "+i+ " name is: " + BigObject.bigObjectList.get(i).getName());
            System.out.println("Fields in this object are: " + BigObject.bigObjectList.get(i).getFieldChildren());
        }
    }
}