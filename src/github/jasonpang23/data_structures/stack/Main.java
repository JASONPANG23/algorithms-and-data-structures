package github.jasonpang23.data_structures.stack;



public class Main {
    public static void main(String[] args) {

        int opCount = (int)1e6 ;

        Stack<Integer> stack = new LinkedStack<>() ;
        double time = test(stack, opCount);
        System.out.println("linkedStack: "+time);

        stack = new ArrayStack<>((int)1e2) ;
        time =  test(stack,opCount) ;
        System.out.println("arrayStack: "+time);


    }

    private static double test(Stack<Integer> stack,int opCount){
        long startTime = System.nanoTime() ;
        for (int i = 0; i < opCount; i++) {
            stack.push(i);
        }

        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime() ;
        return (endTime - startTime) / 1e9 ;
    }


}

