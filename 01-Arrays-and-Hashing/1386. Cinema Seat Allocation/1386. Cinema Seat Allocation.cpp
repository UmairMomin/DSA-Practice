class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int maxAssign = 2 * n;
        HashMap<Integer, boolean[]> affectedBlock = new HashMap<>(); 
        for (int i = 0; i < reservedSeats.length; i++){
            int row = reservedSeats[i][0];
            int col = reservedSeats[i][1];
            if (col < 2 || col > 9){
                continue;
            }
            boolean[] currBlocks = affectedBlock.getOrDefault(row, new boolean[3]);
            if (col > 1 && col < 4){
                currBlocks[0] = true;
            } else if (col > 3 && col < 6){
                currBlocks[0] = true;
                currBlocks[1] = true;
            } else if (col > 5 && col < 8){
                currBlocks[1] = true;
                currBlocks[2] = true;
            } else if (col > 7 && col < 10){
                currBlocks[2] = true;
            }
            affectedBlock.put(row, currBlocks);
        }
        for (Map.Entry<Integer, boolean[]> entry : affectedBlock.entrySet()) {
            boolean[] currBlocks = entry.getValue();
            if (currBlocks[0] && currBlocks[1] && currBlocks[2]){
                maxAssign -= 2;
            } else {
                maxAssign -= 1;
            }
        }
        return maxAssign;
    }
}