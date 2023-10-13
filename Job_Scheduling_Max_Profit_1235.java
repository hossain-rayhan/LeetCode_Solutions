// Time: O(NlogN) for sort + O(NlogN) for searching in the TreeMap
// Space: O(N) + O(N) for jobs array and TreeMap

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int totalJob = startTime.length;
        int[][] jobs = new int[totalJob][3]; 

        for (int i = 0; i < totalJob; i++) {
            jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }

        Arrays.sort(jobs, (a, b) -> (a[1] - b[1])); // sort by end time
        TreeMap<Integer, Integer> timePointToMaxProfitMap = new TreeMap<>();
        timePointToMaxProfitMap.put(0, 0);

        for (int[] job: jobs) {
            // newMaxProfit = maxProfitAtThisTimeFromDP + ProfitForThisJob
            int newMaxProfitAtThisTime = timePointToMaxProfitMap.floorEntry(job[0]).getValue() + job[2];
            if (newMaxProfitAtThisTime > timePointToMaxProfitMap.lastEntry().getValue()) {
                timePointToMaxProfitMap.put(job[1], newMaxProfitAtThisTime);
            }
        }

        return timePointToMaxProfitMap.lastEntry().getValue();
    }
}
