class Pair {
    String first;
    int second;

    Pair(String first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class FoodRatings {
    HashMap<String, Pair> foodMap = new HashMap<>();
    HashMap<String, TreeMap<Integer, TreeSet<String>>> cuisineMap = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < cuisines.length; i++) {
            foodMap.put(foods[i], new Pair(cuisines[i], ratings[i]));

            cuisineMap.putIfAbsent(cuisines[i], new TreeMap<>());
            cuisineMap.get(cuisines[i]).putIfAbsent(ratings[i], new TreeSet<>());
            cuisineMap.get(cuisines[i]).get(ratings[i]).add(foods[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        // System.out.println(cuisineMap);

        String currCuisine = foodMap.get(food).first;
        int prevRating = foodMap.get(food).second;

        // change ratings
        foodMap.get(food).second = newRating;
        TreeMap<Integer, TreeSet<String>> currMap = cuisineMap.get(currCuisine);
        currMap.get(prevRating).remove(food);
        currMap.putIfAbsent(newRating, new TreeSet<>());
        currMap.get(newRating).add(food);
        if (currMap.get(prevRating).isEmpty()) {
            currMap.remove(prevRating);
        }

        // System.out.println(cuisineMap);
    }

    public String highestRated(String cuisine) {
        TreeMap<Integer, TreeSet<String>> currMap = cuisineMap.get(cuisine);
        Set<String> set = currMap.get(currMap.lastKey());
        if (set.isEmpty()) {
            return "";
        }
        return set.iterator().next();
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */