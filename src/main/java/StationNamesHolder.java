import java.util.ArrayList;

abstract class StationNamesHolder {
    void displayNames() {
        // Create an array list
        ArrayList<String> listOfNames = new ArrayList<String>();

        // Add the elements to the array list
        listOfNames.add("Alpha");
        listOfNames.add("Beta");
        listOfNames.add("Gama");
        listOfNames.add("Delta");
        listOfNames.add("Epsilon");

        // Use iterator to display contents of the listOfNames
        System.out.print("\n[NAMES OF STATIONS]\n");

        //This "while" statement is equal to the "for" loop used below
        /*
        Iterator itr = listOfNames.iterator();
        while(itr.hasNext()) {
            Object element = itr.next();
            System.out.print(element + "\n");
        }
        System.out.println();
        */

        for (Object element : listOfNames) {
            System.out.print(element + "\n");
        }
        System.out.println();
    }
    abstract boolean checkInput();
}
