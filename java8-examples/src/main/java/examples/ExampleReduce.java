package examples;

import entity.Author;
import entity.Book;

import java.util.Arrays;
import java.util.Optional;

public class ExampleReduce {

    public static void main(String[] args) {
        reduceSum();
        reduceSumClass();
        reduceSumParallel();
        reduceSumIdentityValue();
        reduceMultiply();
        reduceMultiplyIdentityValue();
        reduceMultiplyParallel();
    }


    static void reduceSum(){
        final Optional<Integer> reduce = Arrays.asList(1, 2, 3, 4, 5, 6, 7)
                .stream()
                .reduce((n1, n2) -> n1 + n2);

        System.out.println("reduceSum "+reduce.get());
    }

    static void reduceSumIdentityValue(){
        // identity value
        final Integer reduce = Arrays.asList(1, 2, 3, 4, 5, 6, 7)
                .stream()
                .reduce(0, (n1, n2) -> n1 + n2);

        System.out.println("reduceSumIdentityValue "+reduce);
    }

    static void reduceSumClass(){
        final Book bookOne = new Book();
        final Book bookTwo = new Book();
        bookOne.setNumberPages(100);
        bookTwo.setNumberPages(400);

        final Optional<Integer> reduce = Arrays.asList(bookOne, bookTwo)
                .stream()
                .map(Book::getNumberPages)
                .reduce((n1, n2) -> n1 + n2);

        System.out.println("reduceSum class "+reduce.get());
    }

    static void reduceSumParallel(){
        final Optional<Integer> reduce = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .stream()
                .parallel()
                .reduce((n1, n2) -> n1 + n2);

        System.out.println("reduceSumParalel "+reduce.get());
    }

    static void reduceMultiply(){
        final Optional<Integer> reduce = Arrays.asList(1, 2, 3, 4, 5)
                .stream()
                .reduce((n1, n2) -> n1 * n2);

        System.out.println("reduceMultiply "+reduce.get());
    }

    static void reduceMultiplyIdentityValue(){
        final Integer reduce = Arrays.asList(1, 2, 3, 4, 5)
                .stream()
                .reduce(1, (n1, n2) -> n1 * n2);

        System.out.println("reduceMultiplyIdentityValue "+reduce);
    }

    static void reduceMultiplyParallel(){
        final Optional<Integer> reduce = Arrays.asList(1, 2, 3, 4, 5)
                .stream()
                .parallel()
                .reduce((n1, n2) -> n1 * n2);

        System.out.println("reduceMultiplyParallel "+reduce.get());
    }








}
