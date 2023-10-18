import java.util.HashSet;
class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> hashSet = new HashSet<String>();
        
        // hashSet에 추가
        for (String phone : phone_book) {
            hashSet.add(phone);
        }
        
        for (String phone: phone_book) {
            for (int i=0; i<phone.length(); i++) {
                if (hashSet.contains(phone.substring(0,i))){
                    return false;
                }
            }
        }
        
        return true;
    }
}