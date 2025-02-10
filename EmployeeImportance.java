import java.util.*;

class Solution {
    private int totalImportance = 0; // Class-level variable to store importance

    public int getImportance(List<Employee> employees, int id) {
        // Create a map for quick lookup of Employee by id
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee emp : employees) {
            map.put(emp.id, emp);
        }

        // Start DFS
        dfs(map.get(id), map);
        return totalImportance;
    }

    private void dfs(Employee e, Map<Integer, Employee> map) {
        if (e == null) return;
        totalImportance += e.importance;
        
        for (int subId : e.subordinates) {
            dfs(map.get(subId), map);
        }
    }
}
