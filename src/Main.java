import java.util.Random;

public class Main {

    private static final Employee[] EMPLOYEES = new Employee[10];

    private static final String[] NAMES ={"Александр", "Евгений", "Артем", "Андрей", "Михаил"};
    private static final String[] SURNAMES ={"Алексеев", "Иванов", "Попов", "Пупкин", "Горбачев"};
    private static final String[] PATRONYMIC_NAMES ={"Александрович", "Евгеньевич", "Петрович", "Андреевич", "Михайлович"};

    private static final Random RANDOM = new Random(14);

    private static Employee generateEmployee() {
        String fullName = SURNAMES[RANDOM.nextInt(SURNAMES.length)] +
                " " + NAMES[RANDOM.nextInt(NAMES.length)] +
                " " + PATRONYMIC_NAMES[RANDOM.nextInt(PATRONYMIC_NAMES.length)];
        int minDepartment = 1;
        int maxDepartment = 5;
        int department = minDepartment + RANDOM.nextInt(maxDepartment - minDepartment +1);
        int minSalary = 30_000;
        int maxSalary = 80_000;
        int salary = minSalary + RANDOM.nextInt(maxSalary - minSalary +1);
        return new Employee(
                fullName,
                department,
                salary
        );
    }

    public static void main(String[] args) {
        for (int i = 0; i < EMPLOYEES.length; i++) {
            EMPLOYEES[i] = generateEmployee();
        }

        printInfoAboutEmployees();
        System.out.println("Сумма ЗП: " + calculateTotalSalaries());
        System.out.println("Сотрудник с мин ЗП: " + findEmployeeWitMinSalary());
        System.out.println("Сотрудник с макс ЗП: " + findEmployeeWitMaxSalary());
        System.out.println("Средняя ЗП: " + findAverageSalary());
        printFullNameOfEmployees();
    }

    private static void printInfoAboutEmployees() {
        for (Employee employee: EMPLOYEES) {
            System.out.println(employee);
        }
    }

    private static int calculateTotalSalaries() {
        int sum = 0;
        for (Employee employee: EMPLOYEES) {
            sum += employee.getSelary();
        }
        return sum;
    }

    private static Employee findEmployeeWitMinSalary() {
        Employee employee = null;
        int minSalary = Integer.MAX_VALUE;
        for (Employee emp: EMPLOYEES) {
            if (emp.getSelary() < minSalary) {
                minSalary = emp.getSelary();
                employee = emp;
            }
        }
        return employee;
    }

    private static Employee findEmployeeWitMaxSalary() {
        Employee employee = null;
        int maxSalary = Integer.MIN_VALUE;
        for (Employee emp: EMPLOYEES) {
            if (emp.getSelary() > maxSalary) {
                maxSalary = emp.getSelary();
                employee = emp;
            }
        }
        return employee;
    }

    private static double findAverageSalary() {
        return  calculateTotalSalaries() / (double) EMPLOYEES.length;
    }

    private static void printFullNameOfEmployees() {
        for (Employee employee: EMPLOYEES) {
            System.out.println(employee.getFullName());
        }
    }
}