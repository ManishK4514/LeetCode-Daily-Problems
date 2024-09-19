class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        int n = expression.length();
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            if(expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));

                for(int l : left) {
                    for(int r : right) {
                        switch(expression.charAt(i)) {
                            case '+': 
                                res.add(l + r);
                                break;
                            case '-':
                                res.add(l - r);
                                break;
                            default:
                                res.add(l * r); 
                        }
                    }
                }
            }
        }

        if(expression.length() <= 2) res.add(Integer.parseInt(expression));
        return res;
    }
}