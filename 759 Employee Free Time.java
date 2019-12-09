/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/
class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        while (schedule.size() > 1) {
            List<List<Interval>> newSchedule = new ArrayList<>();
            for (int i = 0; i < schedule.size(); i+=2) {
                if (i == schedule.size() - 1) {
                    newSchedule.add(schedule.get(i));
                }
                else {
                    newSchedule.add(mergeTwo(schedule.get(i), schedule.get(i + 1)));
                }
            }
            schedule = newSchedule;
        }
        List<Interval> ans = new ArrayList<>();
        for (int i = 0; i < schedule.get(0).size() - 1; i++) {
            ans.add(new Interval(schedule.get(0).get(i).end, schedule.get(0).get(i + 1).start));
        }
        return ans;
    }
    
    private List<Interval> mergeTwo(List<Interval> s1, List<Interval> s2) {
        List<Interval> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < s1.size() || j < s2.size()) {
            Interval interval = null;
            if (i == s1.size()) interval = s2.get(j++);
            else if (j == s2.size())    interval = s1.get(i++);
            else {
                interval = 
                (s1.get(i).start <= s2.get(j).start ? 
                 s1.get(i++) : s2.get(j++));
            }     
            if (ans.size() == 0) {
                ans.add(interval);
            }
            else {
                Interval interval2 = ans.get(ans.size() - 1);
                Interval newInterval = union(interval, interval2);
                if (newInterval != null) {
                    ans.remove(ans.size() - 1);
                    ans.add(newInterval);
                }
                else {
                    ans.add(interval);
                }
            }
        }
        return ans;
    }
    
    private Interval union(Interval i1, Interval i2) {
        if (i1.start > i2.end || i2.start > i1.end) return null;
        return new Interval(Math.min(i1.start, i2.start), Math.max(i1.end, i2.end));
    }
}