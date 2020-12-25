public enum  AdditionalEnumBobbers {
    twoBobbers,

    fourBobbers,

    sixBobbers;

    public static AdditionalEnumBobbers countEnumBobbers(int countBobbers) {
        if (countBobbers == 2) {
            return twoBobbers;
        }
        if (countBobbers == 4) {
            return fourBobbers;
        }
        if (countBobbers== 6) {
            return sixBobbers;
        }
        return null;
    }
}

