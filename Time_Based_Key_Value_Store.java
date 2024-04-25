public class Time_Based_Key_Value_Store {
    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
        timeMap.get("foo", 1);         // return "bar"
        timeMap.get("foo", 3);         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
        timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
        timeMap.get("foo", 4);         // return "bar2"
        timeMap.get("foo", 5);
    }
}

class TimeMap {
    public class Time{
        String key;
        String value;
        int timestamp;
        Time prev;

        public Time(String key, String value, int timestamp){
            this.key = key;
            this.value = value;
            this.timestamp = timestamp;
            this.prev = null;
        }
    }
    Time timeMap;

    public TimeMap() {
        timeMap = null;
    }

    public void set(String key, String value, int timestamp) {
        Time temp = new Time(key,value,timestamp);
        temp.prev = timeMap;
        timeMap = temp;
    }

    public String get(String key, int timestamp) {
        return get(key, timestamp, timeMap);
    }
    private String get(String key, int timestamp, Time map){
        if (map == null){
            return "";
        }
        if (key.equals(map.key)){
            if (map.timestamp <= timestamp){
                return map.value;
            }
        }
        return get(key, timestamp, map.prev);
    }
}
