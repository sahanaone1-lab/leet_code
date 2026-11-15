class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<list1.length;i++){
            for(int j=0;j<list2.length;j++){
                if(list1[i].equals(list2[j])){
                    map.put(list1[i],i+j);
                }

            }
        }
        int min = Collections.min(map.values());
        ArrayList<String> result = new ArrayList<>();
        for(String s: map.keySet()){
            if(map.get(s)==min){
                result.add(s);
            }
        }
        return result.toArray(new String[0]);
    }
}