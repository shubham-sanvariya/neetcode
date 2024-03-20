import java.util.List;

public class Encode_and_Decode_Strings {
    public static void main(String[] args) {
        Encode_and_Decode_Strings encodeAndDecodeStrings = new Encode_and_Decode_Strings();
        List<String > list = List.of("we", "say", ":", "yes");
        encodeAndDecodeStrings.encode(list);
        encodeAndDecodeStrings.decode("we:;say:;::;yes");
    }

    public String encode(List<String> strs) {
        String res = "";
        for (int i = 0; i < strs.size(); i++){
            res += strs.get(i);
            if (i +1 == strs.size()){
                break;
            }
            res += ":;";
        }
        System.out.println(res);
        return res;
    }

    public List<String> decode(String str) {
        List<String > list = List.of(str.split(":;"));
        System.out.println(list);
        return list;
    }
}
