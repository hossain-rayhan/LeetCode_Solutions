class Solution {
    public int countPrimes(int n) {
        if(n <= 2){
            return 0;
        }
        
        boolean[] isPrime = new boolean[n];

		isPrime[0] = isPrime[1] = false;
		for(int i = 2; i < n; i++){
			isPrime[i] = true;
		}

		for(int factor = 2; factor*factor < n; factor++){
			if(isPrime[factor]){
				for(int j = factor; j * factor < n; j++){
					isPrime[j*factor] = false;
				}
			}
		}
        int counter = 0;
		for(int i = 1; i < n; i++){
			if(isPrime[i]){
				counter++;
			}
		}
        return counter;
    }
}
