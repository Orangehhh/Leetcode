/*
 * @Author: Hao Liu
 * @Date: 2019-09-03 21:39:56
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-09-03 21:40:11
 * @Description: Swipe Line
 */

class Solution {
    
    class Event {
        int id;
        int x;
        int height;
        int type;
        Event(int id, int x, int height, int type) {
            this.id = id;
            this.x = x;
            this.height = height;
            this.type = type;
        }
    }
    
    private class MaxHeap {
        private List<int[]> list;
        private int[] idx;
        
        public MaxHeap(int size) {
            list = new ArrayList<>();
            idx = new int[size];
        }
        
        public boolean isEmpty() {
            return list.size() == 0;
        }
        
        public int size() {
            return list.size();
        }
        
        public int getMax() {
            return list.size() == 0 ? 0 : list.get(0)[0];
        }
        
        public void add(int height, int id) {
            list.add(new int[] {height, id});
            idx[id] = list.size() - 1;
            heapifyUp(id);
        }
        
        public void remove(int id) {
            int pos = idx[id];
            swapNode(pos, list.size() - 1);
            list.remove(list.size() - 1);
            if (pos < list.size()) {
                int lastId = list.get(pos)[1];
                heapifyUp(lastId);
                heapifyDown(lastId);
            }
        }
        
        public void heapifyUp(int id) {
            while (true) {
                int pos = idx[id];
                int prev = (pos - 1) / 2;
                if (prev < 0 || list.get(prev)[0] >= list.get(pos)[0]) {
                    break;
                }
                swapNode(pos, prev);
            }
        }
        
        public void heapifyDown(int id) {
            while (true) {
                int pos = idx[id];
                int next1 = pos * 2 + 1;
                int next2 = pos * 2 + 2;
                if (next1 >= list.size()) {
                    break;
                }
                else if (next2 >= list.size()) {
                    if (list.get(next1)[0] > list.get(pos)[0]) {
                        swapNode(pos, next1);
                    }
                    else {
                        break;
                    }
                }
                else {
                    int next = list.get(next1)[0] > list.get(next2)[0] ? next1 : next2;
                    if (list.get(next)[0] > list.get(pos)[0]) {
                        swapNode(pos, next);
                    }
                    else {
                        break;
                    }
                }
            }
        }
        
        private void swapNode(int pos1, int pos2) {
            int tmpIdx = idx[list.get(pos1)[1]];
            idx[list.get(pos1)[1]] = idx[list.get(pos2)[1]];
            idx[list.get(pos2)[1]] = tmpIdx;
            
            int[] tmpNode = list.get(pos1);
            list.set(pos1, list.get(pos2));
            list.set(pos2, tmpNode);
        }
    }
    
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Event> eventList = new ArrayList<>();
        for (int i = 0; i < buildings.length; i++) {
            int[] building = buildings[i];
            eventList.add(new Event(i, building[0], building[2], 1));
            eventList.add(new Event(i, building[1], building[2], -1));
        }
        Collections.sort(eventList, new Comparator<Event>() {
            @Override
            public int compare(Event e1, Event e2) {
                if (e1.x != e2.x) {
                    return e1.x - e2.x;
                }
                else {
                    return e2.type * e2.height - e1.type * e1.height;
                }
            }
        });
        MaxHeap maxHeap = new MaxHeap(buildings.length);
        List<List<Integer>> ans = new ArrayList<>();
        for (Event e : eventList) {
            if (e.type == 1) {
                if (e.height > maxHeap.getMax()) {
                    ans.add(Arrays.asList(e.x, e.height));
                }
                maxHeap.add(e.height, e.id);
            }
            else {
                maxHeap.remove(e.id);
                if (e.height > maxHeap.getMax()) {
                    ans.add(Arrays.asList(e.x, maxHeap.getMax()));
                }
            }
        }
        return ans;
    }
}