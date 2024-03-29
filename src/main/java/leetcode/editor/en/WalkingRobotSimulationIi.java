//A width x height grid is on an XY-plane with the bottom-left cell at (0, 0) an
//d the top-right cell at (width - 1, height - 1). The grid is aligned with the fo
//ur cardinal directions ("North", "East", "South", and "West"). A robot is initia
//lly at cell (0, 0) facing direction "East". 
//
// The robot can be instructed to move for a specific number of steps. For each 
//step, it does the following. 
//
// 
// Attempts to move forward one cell in the direction it is facing. 
// If the cell the robot is moving to is out of bounds, the robot instead turns 
//90 degrees counterclockwise and retries the step. 
// 
//
// After the robot finishes moving the number of steps required, it stops and aw
//aits the next instruction. 
//
// Implement the Robot class: 
//
// 
// Robot(int width, int height) Initializes the width x height grid with the rob
//ot at (0, 0) facing "East". 
// void step(int num) Instructs the robot to move forward num steps. 
// int[] getPos() Returns the current cell the robot is at, as an array of lengt
//h 2, [x, y]. 
// String getDir() Returns the current direction of the robot, "North", "East", 
//"South", or "West". 
// 
//
// 
// Example 1: 
//
// 
//Input
//["Robot", "move", "move", "getPos", "getDir", "move", "move", "move", "getPos"
//, "getDir"]
//[[6, 3], [2], [2], [], [], [2], [1], [4], [], []]
//Output
//[null, null, null, [4, 0], "East", null, null, null, [1, 2], "West"]
//
//Explanation
//Robot robot = new Robot(6, 3); // Initialize the grid and the robot at (0, 0) 
//facing East.
//robot.move(2);  // It moves two steps East to (2, 0), and faces East.
//robot.move(2);  // It moves two steps East to (4, 0), and faces East.
//robot.getPos(); // return [4, 0]
//robot.getDir(); // return "East"
//robot.move(2);  // It moves one step East to (5, 0), and faces East.
//                // Moving the next step East would be out of bounds, so it tur
//ns and faces North.
//                // Then, it moves one step North to (5, 1), and faces North.
//robot.move(1);  // It moves one step North to (5, 2), and faces North (not Wes
//t).
//robot.move(4);  // Moving the next step North would be out of bounds, so it tu
//rns and faces West.
//                // Then, it moves four steps West to (1, 2), and faces West.
//robot.getPos(); // return [1, 2]
//robot.getDir(); // return "West"
//
// 
//
// 
// Constraints: 
//
// 
// 2 <= width, height <= 100 
// 1 <= num <= 105 
// At most 104 calls in total will be made to step, getPos, and getDir. 
// 
// Related Topics Design Simulation 
// 👍 84 👎 192


package leetcode.editor.en;

public class WalkingRobotSimulationIi {
    public static void main(String[] args) {
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Robot {

        private int width = 0;
        private int height = 0;
        private int face = 0;
        private int posx = 0;
        private int posy = 0;
        private final String[] navi = new String[]{
                "East", "North", "West", "South"
        };
        private int cycle = 0;


        public Robot(int width, int height) {
            this.width = width;
            this.height = height;
            this.cycle = (width + height) * 2 - 4;
        }

        public int getLong() {
            if (face == 2 || face == 3) return cycle - posx - posy;
            return posx + posy;
        }

        public void step(int num) {
            num = (getLong() + num) % cycle;
            if (num > 0 && num < width) {
                face = 0;
                posx = num;
                posy = 0;
            } else if (num >= width && num <= width + height - 2) {
                face = 1;
                posx = width - 1;
                posy = num - posx;
            } else if (num > width + height - 2 && num <= 2 * width + height - 3) {
                face = 2;
                posy = height - 1;
                posx = cycle - num - posy;
            } else if (num == 0) {
                face = 3;
                posx = 0;
                posy = 0;
            } else {
                face = 3;
                posx = 0;
                posy = cycle - num;
            }
        }

        public int[] getPos() {
            return new int[]{posx, posy};
        }

        public String getDir() {
            return this.navi[face];
        }
    }

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */
//leetcode submit region end(Prohibit modification and deletion)

}