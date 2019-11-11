class SnakeGame {

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    private Deque<Integer> q;
    private Set<Integer> occupied;
    private int length;
    private int width;
    private int height;
    private int[][] food;
    private int foodIdx;
    
    
    public SnakeGame(int width, int height, int[][] food) {
        q = new LinkedList<>();
        q.offerFirst(0);
        occupied = new HashSet<>();
        occupied.add(0);
        length = 1;
        this.width = width;
        this.height = height;
        this.food = food;
        foodIdx = 0;
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int curLoc = q.peekFirst();
        int r = curLoc / width;
        int c = curLoc % width;
        switch (direction) {
            case "U":
                r--;
                break;
            case "L":
                c--;
                break;
            case "R":
                c++;
                break;
            case "D":
                r++;
                break;
        }
        if (r < 0 || c < 0 || r >= height || c >= width) {
            return -1;  
        }
        if (foodIdx < food.length && 
            r == food[foodIdx][0] && c == food[foodIdx][1]) {
            length++;
            foodIdx++;
        }
        if (q.size() == length) {
            int loc = q.pollLast();
            occupied.remove(loc);
        }
        if (occupied.contains(r * width + c)) {
            return -1;
        }
        q.offerFirst(r * width + c);
        occupied.add(r * width + c);
        return length - 1;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */