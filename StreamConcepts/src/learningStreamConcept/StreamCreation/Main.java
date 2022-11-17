package learningStreamConcept.StreamCreation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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


}

public class Main {
    public static void main(String[] args) {
        //obtain a stream from an existing array
        Employee[] arrayOfEmps = {
                new Employee(1,"Dinesh",10000.0f),
                new Employee(2,"Praveen",20000.0f),
                new Employee(3,"Vijay",30000.0f)
        };
        Stream.of(arrayOfEmps);
        //obtain a stream from an existing List
        List<Employee> empList = Arrays.asList(arrayOfEmps);
        empList.stream();
        //we can create stream from individual object using StreamOf() or Stream.builder()
        Stream.of(arrayOfEmps[0],arrayOfEmps[1],arrayOfEmps[2]);

        Stream.Builder<Employee> empStreamBuilder = Stream.builder();
        empStreamBuilder.accept(arrayOfEmps[0]);
        empStreamBuilder.accept(arrayOfEmps[1]);
        empStreamBuilder.accept(arrayOfEmps[2]);

        Stream<Employee> employeeStream = empStreamBuilder.build();




    }
}
