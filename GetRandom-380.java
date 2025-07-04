class RandomizedSet {
    List<Integer> list;
    HashMap<Integer, Integer> map;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        list.add(val);
        map.put(val, list.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int valIndex = map.get(val);
        int lastIndex = list.size() - 1;
        int lastEle = list.get(lastIndex);
        list.set(valIndex, lastEle);
        map.put(lastEle, valIndex);
        list.remove(lastIndex);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        int randomIndex = (int)(Math.random() * list.size());
        return list.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
