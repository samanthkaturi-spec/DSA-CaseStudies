/*Hospital Appointment Scheduling Using Greedy Algorithm*/
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {

    public static void main(String[] args) {

        int[][] activities = {
                {1, 2},
                {3, 4},
                {0, 6},
                {5, 7},
                {8, 9}
        };

        Arrays.sort(activities, Comparator.comparingInt(a -> a[1]));

        int lastEnd = 0;

        System.out.println("Selected Appointments:");

        for (int[] activity : activities) {
            if (activity[0] >= lastEnd) {
                System.out.println("(" + activity[0] + ", " + activity[1] + ")");
                lastEnd = activity[1];
            }
        }
    }
}
