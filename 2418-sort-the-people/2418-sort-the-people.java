class Person {
    String name;
    int height;

    Person(String name, int height) {
        this.name = name;
        this.height = height;
    }
}

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Person[] persons = new Person[n];

        for(int i = 0; i < n; i++) {
            persons[i] = new Person(names[i], heights[i]);
        }

        Arrays.sort(persons, (a, b)->{
            return b.height - a.height;
        });

        for(int i = 0; i < n; i++) {
            names[i] = persons[i].name;
        }

        return names;
    }
}