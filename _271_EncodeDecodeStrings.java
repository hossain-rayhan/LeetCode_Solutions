public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            int length = s.length();
            sb.append(length).append(":").append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while(i < s.length()){
            int divider = s.indexOf(":", i);
            int length = Integer.parseInt(s.substring(i, divider));
            i = divider + length + 1;
            result.add(s.substring(divider+1, i));
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
