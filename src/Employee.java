//CLASSE UTILITZADA PEL DOM XML D'ESCRIPTURA

public class Employee {
    
    //Atributs
    String name;
	String surname;
    int age;
    float height;
    String job;
    
    
    //Constructor
    public Employee(){
        
    }
    
    public Employee(String name){
        this.name = name;
    }
    
    public Employee (String name, String surname, int age, float height, String job){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.height = height;
        this.job = job;
    }

    //getters y setters
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", surname=" + surname + ", age=" + age + ", height=" + height + ", job="
				+ job + "]";
	}
}
