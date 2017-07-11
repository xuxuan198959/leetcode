public class Codec {
    String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Map<String, String> hash = new HashMap<>();
    
    private String randKey() {
        String key;
        do {
            key = "";
            for (int i = 0; i < 6; i++)
                key += alphabet.charAt((int) (Math.random()*62));
        } while (hash.containsKey(key));
        return key;
    }
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String key = randKey();
        hash.put(key, longUrl);
        return key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String longUrl = hash.get(shortUrl.replace("http://tinyurl.com/", ""));
        return longUrl;
    }
}
