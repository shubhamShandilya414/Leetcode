class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>>ans=new ArrayList<>();

        Map<String,List<String>>lookup=new HashMap<>();

        for(String token:strs){
            char []curr=token.toCharArray();
            //System.out.print(curr);
            Arrays.sort(curr);
            //System.out.print(curr);
            String now = new String(curr);
            if(lookup.containsKey(now)){
                List<String>lst=lookup.get(now);
                lst.add(token);

                lookup.put(now,lst);
                //lookup.get(now).add(token);
            }
            else{
                List<String>newList =new ArrayList<>();
                newList.add(token);
                lookup.put(now,newList);
            }
        }
              for(Map.Entry<String,List<String>> entry:lookup.entrySet()){
                System.out.println("value is"+entry.getValue().toString()+"key is"+entry.getKey()) ;
                ans.add(entry.getValue());
              }
        return ans;



        
    }
}