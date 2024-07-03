package topInterview150;

import java.util.*;

public class MinimumGeneticMutation {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> validGenes = new HashSet<>();
        char[] choices = {'A', 'C', 'G', 'T'};
        Set<String> visited = new HashSet<>();

        for(String str : bank) {
            validGenes.add(str);
        }

        // not possible to form endGene
        if(!validGenes.contains(endGene)) return -1;

        // bfs
        int steps = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        while(!queue.isEmpty()) {
            int queueSize = queue.size();

            for(int count=0; count<queueSize; count++) {
                String curr = queue.poll();
                for(int i=0; i<8; i++) {
                    StringBuilder sb = new StringBuilder(curr);
                    for(char c : choices) {
                        sb.setCharAt(i, c);
                        String next = sb.toString();

                        if(next.equals(endGene)) return steps+1;
                        if(validGenes.contains(next) && !visited.contains(next)) {
                            queue.offer(next);
                            visited.add(next);
                        } 
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
