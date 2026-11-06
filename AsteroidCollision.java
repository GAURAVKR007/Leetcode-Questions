import java.util.Stack;

public class AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] < 0) {
                boolean flag = false;
                while (!stack.isEmpty()) {
                    
                    int prevAsteroid = stack.pop();
                    if(prevAsteroid < 0) {
                        stack.push(prevAsteroid);
                        break;
                    }

                    if (prevAsteroid == Math.abs(asteroids[i])) {
                        flag = true;
                        break;
                    }
                    if (prevAsteroid > Math.abs(asteroids[i])) {
                        stack.push(prevAsteroid);
                        flag = true;
                        break;
                    }
                }

                if(!flag){
                    stack.push(asteroids[i]);
                }
            } else {
                stack.push(asteroids[i]);
            }
        }

        int[] res = new int[stack.size()];
        int idx = 0;
        for (int x : stack) {
            res[idx++] = x;
        }

        return res;
    }

    public static void main(String[] args) {
        // boiler plate code
        int[] asteroids = { -2,-1, 1, 2 };
        int[] result = asteroidCollision(asteroids);
        for (int asteroid : result) {
            System.out.print(asteroid + " ");
        }
    }
}
