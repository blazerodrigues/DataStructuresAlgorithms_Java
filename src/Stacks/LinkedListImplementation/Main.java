package Stacks.LinkedListImplementation;

public class Main {

    public static void main(String[] args) {

        Employee janeJones = new Employee("Jane","Jones",789);
        Employee johnDoe = new Employee("John","Doe",456);
        Employee marySmith = new Employee("Mary","Smith",123);
        Employee mikeWilson = new Employee("Mike","Wilson",741);
        Employee billEnd = new Employee("Bill","End",852);

        LinkedStack stack = new LinkedStack();
        stack.push(janeJones);
        stack.push(johnDoe);
        stack.push(marySmith);
        stack.push(mikeWilson);
        stack.push(billEnd);


        stack.printStack();

        System.out.println("======================");

        System.out.println(stack.peek());

        System.out.println("======================");

        stack.printStack();

        System.out.println("======================");

        System.out.println("Popped : "+stack.pop());

        System.out.println("======================");

        stack.printStack();



    }

}
