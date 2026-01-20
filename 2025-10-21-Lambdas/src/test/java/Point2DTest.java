
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import streams.Point2D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Point2DTest {

    private List<Point2D> points= new ArrayList<>();

    @BeforeEach
    public void setUp(){
        points = Arrays.asList(
                new Point2D(-4,-8),
                new Point2D(-2, 9),
                new Point2D(-1,-8),
                new Point2D( 0,-7),
                new Point2D( 1, 1),
                new Point2D( 2, 3),
                new Point2D( 2, 3),
                new Point2D( 2,-2),
                new Point2D( 4,-1) );
    }


    @Test
    public void test_sum_of_x_coordinate(){
        double sum = points.stream()
                .mapToDouble(Point2D::x) 	// map the x value to a DoubleStream
                .peek(value -> System.out.print(value + " ")) // trace the values
                .sum();

        //assert(true);
        assertEquals(4.0,sum);
    }

    @Test
    public void count() {
        long count = points.stream()
                .filter(p -> p.x() == 2)
                .count();

        assertEquals(3, count);
    }
    @Test
    public void test_sum_with_reduce() {
        //mit startwert beim reduce.
        double sum = points.stream()
                .mapToDouble(p -> p.x())             // map the x value to a DoubleStream
                .peek(x -> System.out.print(x + " "))   // trace the values
                .reduce(0.0, (x1, x2) -> x1 + x2);            // no initial value is used
        // .ifPresent(s -> System.out.print("\nsum=" + s));// in the case there is no empty list

        assertEquals(4.0, sum);

    }
    @Test
    public void test_sum_with_reduce_and_optional_double() {
        //ohne default wert/ohne start wert. wenn es eine leere liste ist gibt es kein ergebniss
        double sum;
        points.stream()
                .mapToDouble(p -> p.x())             // map the x value to a DoubleStream
                .reduce((x1, x2) -> x1 + x2)            // no initial value is used
                .ifPresent(s -> assertEquals(4.0,s)); // in the case there is no empty list
    }
    @Test
    void testXPositiveFilter() {
        long count = points.stream()
                .filter(p -> p.x() > 0)
                .count();
        assertEquals(5, count);
    }

    @Test
    void customFilter() {
        long count = points.stream()
                .filter(p -> (p.x() == 2 && p.y() > 0))
                .count();
        assertEquals(2, count);
    }

    @Test
    void customFilterNoStream() {
        long count = 0;
        for(Point2D p : points) {
            if(p.x() == 2 && p.y() > 0) {
                count++;
            }
        }
        assertEquals(2, count);
    }

    //wo x positiv ist --> set draus machen

    @Test
    void test_set_conversion_of_positive_x_points(){
        Set<Point2D> result = points.stream()
                .filter(p -> p.x() > 0)
                .collect(Collectors.toCollection(HashSet::new));  // creation of a new ArrayList

       assertEquals(4,result.size());
    }

}
