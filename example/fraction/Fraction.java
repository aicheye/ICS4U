public class Fraction {
    private int num;
    private int denum;

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return (gcd(b, a % b));
        }
    }

    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    private void reduce() {
        int gcd = gcd(Math.abs(num), denum);
        num = num / gcd;
        denum = denum / gcd;
    }

    public double magnitude() {
        return Math.abs((double) num / denum);
    }

    public double decimal() {
        return (double) num / denum;
    }

    public Fraction(int num, int denum) {
        this.num = Math.abs(num);
        this.denum = Math.abs(denum);

        if (denum == 0) {
            throw new ArithmeticException("Cannot divide by 0");
        }

        boolean sgn = !((num < 0) ^ (denum < 0));
        if (!sgn) {
            this.num *= -1;
        }

        reduce();
    }

    public String toString() {
        return "" + num + "/" + denum;
    }

    public void add(Fraction other) {
        int lcm = lcm(denum, other.denum);
        denum = lcm;
        num = num * (lcm / denum) + other.num * (lcm / other.denum);
        reduce();
    }

    public void subtract(Fraction other) {
        add(new Fraction(other.num * -1, other.denum));
        reduce();
    }

    public void multiply(Fraction other) {
        denum = denum * other.denum;
        num = num * other.num;
        reduce();
    }

    public static Fraction reciprocal(Fraction frac) {
        return new Fraction(frac.denum, frac.num);
    }

    public void divide(Fraction other) {
        multiply(reciprocal(other));
        reduce();
    }

    public boolean equals(Fraction other) {
        if (num == other.num && denum == other.num) {
            return true;
        }
        return false;
    }

    public int compareTo(Fraction other) {
        if (equals(other)) {
            return 0;
        }
        return (int) Math.ceil(decimal() - other.decimal());
    }

    public Fraction larger(Fraction other) {
        if (magnitude() > other.magnitude()) {
            return this;
        }
        return other;
    }

    public static void main(String[] args) {
        Fraction f1 = new Fraction(3, 2);
        Fraction f2 = new Fraction(2, 3);

        f1.add(f2);

        System.out.println(f1);

        System.out.println(f1.decimal());
        System.out.println(f2.decimal());

        f1.subtract(f2);

        System.out.println(f1.decimal());

        f2 = new Fraction(1, 2);

        f1.subtract(f2);

        System.out.println(f1);

        Fraction f3 = new Fraction(3, 2);

        System.out.println(f3.compareTo(f1));

        f3.divide(new Fraction(3, 10));

        System.out.println(f3);
    }
}
