package proj4;

// Viktor Shkrivani
// CIS 2353
// Fall 2023
// Prof. John P. Baugh

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class TriageSimulator {
    private Queue<Patient> P1Queue;
    private Queue<Patient> P2Queue;
    private Queue<Patient> P3Queue;

    public TriageSimulator() {
        P1Queue = new PriorityQueue<>(new TriageComparator());
        P2Queue = new PriorityQueue<>(new TriageComparator());
        P3Queue = new PriorityQueue<>(new TriageComparator());
    }



    public void  add (String lineFromFile) {
        String[] categ = lineFromFile.split(" ");
        if (categ.length == 3) {
            Patient patient = new Patient(categ[0], categ[1], categ[2]);
            String triageCode = categ[2].toUpperCase();
            switch (triageCode) {
                case "AL":
                case "HA":
                case "ST":
                    P1Queue.offer(patient);
                    break;
                case "BL":
                case "SF":
                case "IW":
                case "KS":
                case "OT":
                    P2Queue.offer(patient);
                    break;
                default:
                    P3Queue.offer(patient);
            }
        }
    }

    public String remove() {
        if (!P1Queue.isEmpty()) {
            return P1Queue.poll().toString();
        } else if (!P2Queue.isEmpty()) {
            return P2Queue.poll().toString();
        } else if (!P3Queue.isEmpty()) {
            return P3Queue.poll().toString();
        }else {
            return "Queue has no patient";
        }
    }

    public boolean isEmpty(){
        return P1Queue.isEmpty() && P2Queue.isEmpty() && P3Queue.isEmpty();
    }

    private static class TriageComparator implements Comparator<Patient> {
        @Override
        public int compare(Patient p1, Patient p2) {
            return p1.getTriageCode().compareTo(p2.getTriageCode());
        }
    }

}

