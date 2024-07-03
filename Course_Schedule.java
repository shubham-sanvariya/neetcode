public class Course_Schedule {
    public static void main(String[] args) {
        Course_Schedule courseSchedule = new Course_Schedule();
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};
        courseSchedule.canFinish(numCourses,prerequisites);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0)
            return true;

        int[] reqPerCourse = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) // Stores the amunt of prerequisites per course
            reqPerCourse[prerequisites[i][1]]++;


        boolean visited[] = new boolean[prerequisites.length]; // Visited prerequisites

        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < prerequisites.length; i++) {
                if (!visited[i]) {
                    if (reqPerCourse[prerequisites[i][0]] == 0) {
                        visited[i] = true;
                        reqPerCourse[prerequisites[i][1]]--;
                        flag = true;
                    }
                }
            }
        }

        for(int i = 0; i < numCourses; i++){ // Verify if all prerequisited has been completed
            if(reqPerCourse[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
