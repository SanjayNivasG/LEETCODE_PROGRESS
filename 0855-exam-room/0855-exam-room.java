import java.util.*;

class ExamRoom {
    int n;
    TreeSet<Integer> seats;

    public ExamRoom(int n) {
        this.n = n;
        seats = new TreeSet<>();
    }

    public int seat() {
        if (seats.isEmpty()) {
            seats.add(0);
            return 0;
        }

        int best = 0;
        int maxDist = seats.first();

        Integer prev = null;

        for (int s : seats) {
            if (prev != null) {
                int dist = (s - prev) / 2;
                int pos = prev + dist;

                if (dist > maxDist) {
                    maxDist = dist;
                    best = pos;
                }
            }
            prev = s;
        }

        int lastDist = n - 1 - seats.last();

        if (lastDist > maxDist) {
            best = n - 1;
        }

        seats.add(best);
        return best;
    }

    public void leave(int p) {
        seats.remove(p);
    }
}