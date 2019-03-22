class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> emailSet = new HashSet<>();
        for(String s : emails){
            String[] arr = s.split("@");
            char[] name = arr[0].toCharArray();
            
            int i = 0, index = 0;
            while(i < name.length && name[i] != '+'){
                if(name[i] == '.'){
                    i++;
                }else{
                    name[index++] = name[i++];
                }
            }
            
            String validName = new String(name, 0, index);
            String validEmail = validName + "@" + arr[1];
            emailSet.add(validEmail);
        }
        return emailSet.size();
    }
}
