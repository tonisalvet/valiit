package ee.bcs.valiit.controller;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController //peab ette panema, muidu ei lähe veebi see
public class TestController {
    private static final List<Employee> employees = new ArrayList();

    @GetMapping("/fibo")
    public int getHelloWorld(@RequestParam("n") int n) {

        return fibo(n);

        // Fibonacci jada on fib(n) = fib(n-1) + fib(n-2);
        // 0, 1, 1, 2, 3, 5, 8, 13, 21
        // Tagasta fibonacci jada n element
    }

    @GetMapping("/abs")
    public int abs(@RequestParam("n") int n) {
        return Lesson1MathUtil.abs(n);

    }

    @GetMapping("/min")
    public int min(@RequestParam("a") int a, @RequestParam("b") int b) {
        return Lesson1MathUtil.min(a, b);

    }

    @GetMapping("/max")
    public int max(@RequestParam("a") int a, @RequestParam("b") int b) {
        return Lesson1MathUtil.max(a, b);

    }

    @GetMapping("/isEven")
    public boolean isEven(@RequestParam("a") int a) {
        return Lesson1MathUtil.isEven(a);
    }

    @GetMapping("/min1")
    public int min(@RequestParam("a") int a, @RequestParam("b") int b, @RequestParam("c") int c) {
        return Lesson1MathUtil.min(a, b, c);
    }

    @GetMapping("/max1")
    public int max(@RequestParam("a") int a, @RequestParam("b") int b, @RequestParam("c") int c) {
        return Lesson1MathUtil.max(a, b, c);
    }

    @GetMapping("/viimaneveerand")
    public int viimaneveerand(@RequestParam("r") int r, @RequestParam("q") int q) {
        return Lesson3.viimaneveerand(r, q);
    }

    @GetMapping("/funct")
    public int funct(@RequestParam("t") int t) {
        return Lesson3.funct(t);
    }

    @GetMapping("/alg")
    public int alg(@RequestParam("n") int n) {
        return Lesson3.funct(n);
    }

    @GetMapping("/sum")
    public int sum(@RequestParam("x") int x, @RequestParam("y") int y) {
        return Lesson3.sum(x, y);
    }

    @GetMapping("/sum1")
    public int sum(@RequestParam("x") int[] x) {
        return Lesson3.sum(x);
        //http://localhost:8080/sum1?x=12,243,124,234
    }

    @GetMapping("/factorial")
    public int factorial(@RequestParam("x") int x) {
        return Lesson3.factorial(x);
    }

    @GetMapping("/sort")
    public int[] sort(@RequestParam("a") int[] a) {
        return Lesson3.sort(a);
    }

    @GetMapping("/isPrime")
    public boolean isPrime(@RequestParam("x") int x) {
        return Lesson3.isPrime(x);
    }

    @GetMapping("/reverseString")
    public String reverseString(@RequestParam("a") String a) {
        return Lesson3.reverseString(a);
    }

    @GetMapping("/exercise7")
    public BigDecimal exercise7(@RequestParam("g") BigDecimal g) {
        return Lesson2.exercise7();
        //http://localhost:8080/exercise7?g
    }

    @GetMapping("/dto")
    public Employee dtoTest() {
        Employee employee = new Employee();
        employee.setAge(2);
        employee.setName("assdf");
        return employee;
    }

    @GetMapping("/evenFibonacci")
    public int evenFibonacci(@RequestParam("x") int x) {
        return Lesson3Hard.evenFibonacci(x);
        //localhost:8080(/evenFibonacci?x
    }

    @PostMapping("/dto")
    public void postTest(@RequestBody Employee employee) {
        System.out.println(employee.getName());
        System.out.println(employee.getAge());

    }

    @GetMapping("employee")
    public List<Employee> getAllEmployee() {
        return employees;
    }

    @GetMapping("/employee/{midagi}")
    public Employee getEmployee(@PathVariable("midagi") int sisend) {
        return employees.get(sisend);
    }

    @PostMapping("employee")
    public void addEmployee(@RequestBody Employee employee) {
        employees.add(employee);
    }

    @PutMapping("/dto/{midagi}")
    public void putEmployee(@RequestBody Employee employee, @PathVariable("midagi") int sisend) {
        employees.set(sisend, employee);
    }

    @DeleteMapping("employee/{midagi}")
    public void deleteEmployee(@PathVariable("midagi") int sisend) {
        employees.remove(sisend);
        //localhost:8080/Employee/
    }

    private int fibo(int n) {
        int t1 = 0, t2 = 1;
        for (int i = 0; i <= n; i++) {
            System.out.println(t1 + " ");
            int sum = t1 + t2;
            t1 = t2;
            t2 = sum;
        }
        return t2;
    }

}
