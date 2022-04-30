class Solution {
    public int solution(int n) {
        int answer = 0;

        String ternary = toTernary(n);
        String reversedTernary = reverseTernary(ternary);
        answer = toDecimal(reversedTernary);

        return answer;
    }

    public String toTernary(int n) {
        String str = "";
        int exponent = maxExponent(n);

        for(int exp = exponent; exp >= 0; exp--) {
            //계산 끝난 경우 0 append
            if(n == 0) {
                str += '0';
                continue;
            }

            //2, 1 순으로 3 ^ 지수 값에 곱해서 최대값 찾기
            for(int i = 2; i > 0; i--) {
                double num = Math.pow(3, exp);

                //현재 숫자보다 3 ^ 지수값이 더 크면 0 append하고 다음 지수값으로
                if(num > n && exp != exponent) {
                    str += '0';
                    break;
                }

                num *= i;
                if(n - num >= 0) {
                    str += Integer.toString(i);
                    n -= num;
                    break;
                }
            }
        }

        return str;
    }

    public int toDecimal(String ternary) {
        int decimal = 0;

        int idx = 0;
        for(int i = ternary.length() - 1; i >= 0; i--) {
            int n = ternary.charAt(idx++) - '0';
            decimal += Math.pow(3, i) * n;
        }

        return decimal;
    }

    public int maxExponent(int n) {
        double num = 3;
        int exponent = 0;
        while(num < n) {
            num = Math.pow(3, exponent);
            exponent++;
        }

        if(exponent == 0) exponent = 1;
        return exponent - 1;
    }

    public String reverseTernary(String str) {
        String reverse = "";
        for(int i = str.length() - 1; i >= 0; i--) {
            reverse += str.charAt(i);
        }

        return reverse;
    }
}