package advanced;
import static java.util.stream.Collectors.toList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.TooManyListenersException;
import java.util.stream.Stream;

public class StreamApi {
	public static void main(String[] args) {
		 List<Employee> employeeList=
			      Arrays.asList(new Employee("Tom Jones", 45), 
			                    new Employee("Harry Major", 25),
			                    new Employee("Ethan Hardy", 65),
			                    new Employee("Nancy Smith", 15),
			                    new Employee("Deborah Sprightly", 29));
		 
		 // get stream
		 Stream<Employee> stream = employeeList.stream();
		 
		 stream.filter(e -> e.getAge() > 50).forEach(System.out::println);
		 
		 // reducing
		 int sum = employeeList.stream()
		 		.mapToInt(Employee::getAge)
		 		.sum();
		 System.out.println(sum);
		 
		 OptionalDouble avgAge = employeeList.stream()
				 	.mapToInt(Employee::getAge)
				 	.average();
		 if(avgAge.isPresent()) {
			 System.out.println(avgAge.getAsDouble());
		 }
		 
		 // matching
		 boolean a = employeeList.stream()
				 	.allMatch(e -> e.getAge() < 66);
		 
		 System.out.println(a);
		 boolean b = employeeList.stream()
				 			.anyMatch(p -> p.getAge() >= 65);
		 
		 System.out.println(b);
		 
		 boolean c = employeeList.stream()
				 		.noneMatch(p -> p.getAge() > 70);
		 System.out.println(c);
		 
		 // mapping
		 List<String> employeeName = employeeList.stream()
				 					.map(Employee::getName)
				 					.collect(toList());
		 
		 employeeName.forEach(System.out::println);
	}
}

class Employee {
  private String name;
  private Integer age;
  public Employee(String name, Integer age){
    this.name=name;
    this.age=age;
  } 
  public String getName(){
    return name;
  }
  public void setName(String name){
    this.name=name;
  } 
  public Integer getAge(){
    return this.age;
  } 
  public void setAge(Integer age){
    this.age=age;
  }  
  public String toString(){
    return "Employee Name: "+this.name
      +"  Age:"+this.age;
  } 
}