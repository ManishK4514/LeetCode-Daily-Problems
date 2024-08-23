class Solution {
    public String fractionAddition(String expression) {
        int n = expression.length();
        int c = 0;
        for(int i=0;i<n;i++){
            if(expression.charAt(i)=='/'){
                c++;
            }
        }
        int[] num = new int[c];
        int[] den = new int[c];
        int[] s = new int[c];
        int i = 0;
        if(expression.charAt(0)=='-'){
            s[0]=-1;
            i=1;
        }
        else{
            s[0]=1;
        }
        int j=0,k=0,l=1;
        while (i < n) {
            if (expression.charAt(i) == '-' || expression.charAt(i) == '+') {
                if (expression.charAt(i) == '-') {
                    s[l] = -1;
                } else {
                    s[l] = 1;
                }
                l++;
                i++;
            }
            int nu=0;
            while (i < n && Character.isDigit(expression.charAt(i))) {
                nu=nu*10+(expression.charAt(i)-'0');
                i++;
            }
            num[j++] = nu;
            i++; 
            int de = 0;
            while (i < n && Character.isDigit(expression.charAt(i))) {
                de=de* 10+(expression.charAt(i)-'0');
                i++;
            }
            den[k++]=de;
        }
        int lcm = den[0];
        for(i=1;i<c;i++){
            lcm = lcm*(den[i]/helper(lcm,den[i]));;
        }
        for(i=0;i<c;i++){
            int a = (lcm/den[i])*s[i];
            num[i]*=a;
        }
        int sum=0;
        for(i=0;i<c;i++){
            sum+=num[i];
        }
        int x = helper(Math.abs(sum),lcm);
        sum=sum/x;
        lcm=lcm/x;
        String str = Integer.toString(sum)+"/"+Integer.toString(lcm);
        return str;
    }
    public static int helper(int a,int b) {
        if (b==0)
            return a;
        return helper(b, a % b);
    }
}