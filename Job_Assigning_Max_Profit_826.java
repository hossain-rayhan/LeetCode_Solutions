// Time: O(JlogJ) + O(WlogW) to sort jobs and workers
// Space: O(N), extra jobs array
class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int totalJob = difficulty.length;
        int[][] jobs = new int[totalJob][2]; // job = {difficulty, profit}
        for (int i = 0; i < totalJob; i++) {
            jobs[i] = new int[]{difficulty[i], profit[i]};
        }

        // Sort the jobs by difficulty (low to high)
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        // Sort the worker in terms of skill (low to high)
        Arrays.sort(worker);

        int totalProfit = 0, i = 0, best = 0;
        for (int workerSkill: worker) {
            while (i < totalJob && workerSkill >= jobs[i][0]) {
                best = Math.max(best, jobs[i++][1]);
            }
            totalProfit += best;
        }
        return totalProfit;
    }
}
