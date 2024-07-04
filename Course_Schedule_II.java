import java.util.ArrayList;
import java.util.Arrays;

public class Course_Schedule_II {
    public static void main(String[] args) {
        Course_Schedule_II courseScheduleIi = new Course_Schedule_II();
        int numcourse = 2;
        int[][] prerequisites = {{1,0}};
        courseScheduleIi.findOrder(numcourse, prerequisites);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> order = new ArrayList<>();
        int ans[] = new int[numCourses];
        ArrayList<Integer> dependency[] = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            dependency[i] = new ArrayList<>();
        }
        for(int i =0;i<prerequisites.length;i++){
            dependency[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        boolean visited[] = new boolean[numCourses];
        boolean stack[] = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(!dfs(dependency,visited,stack,order,i)){
                    return new int[0];
                }
            }
        }
        for(int i=0;i<order.size();i++){
            ans[i] = order.get(i);
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }

    public boolean dfs(ArrayList<Integer> dependency[],boolean visited[],boolean stack[],ArrayList<Integer> order,int curr){
        stack[curr]=true;
        for(int i=0;i<dependency[curr].size();i++){
            int point = dependency[curr].get(i);
            if(!visited[point] && stack[point]){
                return false;
            }
            if(!visited[point]){
                if(!dfs(dependency,visited,stack,order,point)){
                    return false;
                }
            }
        }
        order.add(curr);
        visited[curr] = true;
        stack[curr] = false;
        return true;
    }
}
