public class Employee {

    private static int idGenerator = 1;

    private final int id;
    private final String fullName;
    private int department;
    private int selary;

    public Employee(String fullName, int department, int selary) {
        this.id = idGenerator++;
        this.fullName = fullName;
        this.department = department;
        this.selary = selary;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSelary() {
        return selary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSelary(int selary) {
        this.selary = selary;
    }

    @Override
    public String toString() {
        return String.format("id: %d, ФИО: %s, ЗП: %d, № отдела: %d", id, fullName, selary, department);
    }

}
