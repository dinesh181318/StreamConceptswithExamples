package learningStreamConcept.StreamForEach;

import java.util.ArrayList;

class Employee {
    public int id;
    public String name;
    public float salary;

    public Employee(int id, String name, float salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
    public float salaryincrement(float increment) {
      return   salary * increment ;
    }


}

public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> employeeArrayList = new ArrayList<Employee>();
        employeeArrayList.add(new Employee(1,"Dinesh",15000.0f));
        employeeArrayList.add(new Employee(2,"Vijay",10000.0f));
        employeeArrayList.add(new Employee(3,"Praveen",25000.0f));
        employeeArrayList.add(new Employee(4,"Anish",55000.0f));

        employeeArrayList.stream().forEach(employee -> System.out.println(employee.name));
         employeeArrayList.stream().forEach(employee -> System.out.println(employee.salaryincrement(2.0f)) );
         employeeArrayList.stream().filter(employee -> employee.name.equals("Dinesh")).forEach(System.out::println);
         employeeArrayList.stream().forEach(System.out::println);


    }
}
