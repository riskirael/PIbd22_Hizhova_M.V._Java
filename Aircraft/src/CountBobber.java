public enum CountBobber {
    two, four, six;

    public static CountBobber getCount(int count) {
        switch (count) {
            case 2: {
                return CountBobber.two;
            }
            case 4: {
                return CountBobber.four;
            }
            case 6: {
                return CountBobber.six;
            }
        }
        return null;
    }
}