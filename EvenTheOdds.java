class EvenTheOdds {
    public static void main(String[] args) {

        // boiler
        // int[] arr = { 7, 3, 9, 1, 5 };
        // int n = arr.length;

        int x = 3;
        int y = 5;
        int d = 0;

        boolean check = true;

        if (Math.abs(y - x) <= d) {
            check = false;
        }

        int newX = x;
        int newY = y;

        while (check) {

            if (Math.abs(newY - newX) <= d) {
                check = false;
            }

            if (newX < newY) {
                newX = newX + x;
            } else if (newX > newY) {
                newY = newY + y;
            }
        }

        System.out.println(newY);
    }
}