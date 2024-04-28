package Queue;
public class Josephus {
    public static<T> T josephusWinner(CircularQueue<T> queue, int k) {
        if(queue.isEmpty()) return null;
        while(queue.size() > 1) {
            for(int i=0; i<k; i++)
                queue.rotate();
            T eliminated = queue.dequeue();
            System.out.println(" " + eliminated + " is out");
        }
        return queue.dequeue(); // return winner
    }

    public static<T> CircularQueue<T> buildQueue(T a[]) {
        CircularQueue<T> queue = new LinkedCircularQueue<>();
        for(int i=0; i<a.length; i++)
            queue.enqueue(a[i]);
        return queue;
    }

    public static void main(String[ ] args) {
        String[ ] a1 = {"Alice", "Bob", "Cindy", "Doug", "Ed", "Fred"};
        String[ ] a2 = {"Gene", "Hope", "Irene", "Jack", "Kim", "Lance"};
        String[ ] a3 = {"Mike", "Roberto"};
        System.out.println("First winner is " + josephusWinner(buildQueue(a1), 3));
        System.out.println("Second winner is " + josephusWinner(buildQueue(a2), 10));
        System.out.println("Third winner is " + josephusWinner(buildQueue(a3), 7));
    }
}
