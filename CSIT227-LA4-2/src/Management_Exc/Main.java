package Management_Exc;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Main {

    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param manager the manager to give the salary
     * @param employee the employee to receive the raise
     * @param salary the salary increase to be given
     * @throws ClassCastException when manager or employee is not a manager or employee
     * @throws IllegalArgumentException when salary is invalid
     * @throws NoSuchElementException when given manager or employee does not exist in the list of persons
     */
    public static void giveRaise(List<Person> persons, String manager, String employee, double salary)  {
        Manager man = null;
        Employee emp = null;
        for(Person e : persons){
            if(Objects.equals(e.getName(), manager)){
                if(!(e instanceof Manager)){
                    throw new ClassCastException("name is not a/n type");
                }
                man = (Manager)e;
            }
        }
        for(Person e:persons){
            if(Objects.equals(e.getName(), employee)){
                emp = (Employee)e;
            }
        }
        if(man == null || emp == null){
            throw new NoSuchElementException();
        }
        man.giveRaise(emp,salary);
    }

    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param developer the developer to be assigned
     * @param manager the manager assigned to the dev
     * @throws ClassCastException when manager or developer is not a manager or employee
     * @throws NoSuchElementException when given manager or developer does not exist in the list of persons
     * @throws IllegalStateException when developer already has a manager
     */
    public static void assignPM(List<Person> persons, String developer, String manager) {
        Developer dev = null;
        Manager man = null;
        for(Person e : persons){
            if(Objects.equals(e.getName(), developer)){
                dev = (Developer)e;
            }
        }
        for(Person e:persons){
            if(Objects.equals(e.getName(), manager)){
                man = (Manager)e;
            }
        }
        if(man == null || dev == null){
            throw new NoSuchElementException();
        }
        dev.setProjectManager(man);
    }

    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param customer the customer to speak to the employee
     * @param employee the employee to be spoken to
     * @return the dialogue of the customer to the employee
     * @throws IllegalArgumentException when given customer or employee is not what they are
     * @throws NoSuchElementException when given customer or employee is not in the list of persons
     */
    public static String customerSpeak(List<Person> persons, String customer, String employee) {
        Customer cus = null;
        Employee emp = null;
        for(Person e : persons){
            if(Objects.equals(e.getName(), customer)){
                cus = (Customer) e;
            }
        }
        for(Person e:persons){
            if(Objects.equals(e.getName(), employee)){
                emp = (Employee) e;
            }
        }
        if(emp == null || cus == null){
            throw new NoSuchElementException();
        }
        return cus.speak(emp);
    }
}
