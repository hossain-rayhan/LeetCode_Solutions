public class Codec {
    HashMap<String, String> longToShortMap = new HashMap<>();
    HashMap<String, String> shortToLongMap = new HashMap<>();
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int l = longUrl.length();
        if(!longToShortMap.containsKey(longUrl)){
            
            while(true){
                String begin = longUrl.substring(8,10);
                String end = longUrl.substring(l-2, l);
        
                long range = 1234567L;
                Random r = new Random();
                long number = (long)(r.nextDouble()*range);
                String tiny = begin + end + number;
                if(!shortToLongMap.containsKey(tiny)){
                    String shortUrl = "http://tinyurl.com/" + tiny;
                    longToShortMap.put(longUrl, shortUrl);
                    shortToLongMap.put(shortUrl, longUrl);
                    break;
                }
            }
        } 
        return longToShortMap.get(longUrl);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortToLongMap.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
