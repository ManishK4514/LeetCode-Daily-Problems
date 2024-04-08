class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<>();
        int zeros = 0, ones = 0, n = students.length;

        for(int student : students) {
            q.add(student);
            if(student == 0) zeros++;
            else ones++;
        } 

        for(int i = 0; i < n; i++) {
            int sandwich = sandwiches[i];

            if(sandwich == 0 &&  zeros == 0) return n - i;
            if(sandwich == 1 && ones == 0) return n - i;

            while(sandwich != q.peek()) q.add(q.remove());

            if(sandwich == 0) zeros -= 1;
            else ones -= 1;
        }

        return 0;
    }
}