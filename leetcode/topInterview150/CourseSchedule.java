package topInterview150;

import java.util.*;

public class CourseSchedule {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // [0,1]: 1 is pre for 0
        int[] indegree = new int[numCourses];
        int res = numCourses;

        // get number of prerequisites for each course
        // 0 means no prerequisites
        for(int[] pair : prerequisites) {
            indegree[pair[0]]++;
        }

        // BFS for order of taking the course
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<indegree.length; i++) {
            // no pre, just take the course!
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            // take current course
            int curr = queue.poll();

            for(int[] pair : prerequisites) {
                // this course has no pre, ady taken so no need take again
                if(indegree[pair[0]] == 0) {
                    continue;
                }

                // if the pre of any course is curr course:
                // reduce the pre of that course (as we take ady now)
                if(pair[1] == curr) {
                    indegree[pair[0]]--;
                }

                // if after reduce pre, it became 0
                // we can also take this course ady
                if(indegree[pair[0]] == 0) {
                    queue.offer(pair[0]);
                }
            }
        }

        for(int i=0; i<numCourses; i++) {
            if(indegree[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
