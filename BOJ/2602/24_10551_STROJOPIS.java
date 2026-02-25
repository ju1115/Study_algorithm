import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 문제: BOJ 10551 STROJOPIS
 * 난이도: BRONZE2
 * 유형: 문자열
 */
class Main_10551 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    enum Finger {
        LEFT_PINKY, LEFT_RING, LEFT_MIDDLE, LEFT_INDEX,
        RIGHT_INDEX, RIGHT_MIDDLE, RIGHT_RING, RIGHT_PINKY
    }

    static final Map<Character, Finger> KEY_MAP = new HashMap<>();

    static {
        registerKeys("1QAZ", Finger.LEFT_PINKY);
        registerKeys("2WSX", Finger.LEFT_RING);
        registerKeys("3EDC", Finger.LEFT_MIDDLE);
        registerKeys("4RFV5TGB", Finger.LEFT_INDEX);
        registerKeys("6YHN7UJM", Finger.RIGHT_INDEX);
        registerKeys("8IK,", Finger.RIGHT_MIDDLE);
        registerKeys("9OL.", Finger.RIGHT_RING);
        registerKeys("0P;/-=[]'", Finger.RIGHT_PINKY);
    }

    private static void registerKeys(String keys, Finger finger) {
        for (char c : keys.toCharArray()) {
            KEY_MAP.put(c, finger);
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2602/24_10551_STROJOPIS.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        String input = br.readLine();

        Map<Finger, Integer> fingerCounts = new EnumMap<>(Finger.class);
        for (Finger f : Finger.values()) {
            fingerCounts.put(f, 0);
        }

        if (input != null) {
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                Finger finger = KEY_MAP.get(c);
                if (finger != null) {
                    fingerCounts.put(finger, fingerCounts.get(finger) + 1);
                }
            }
        }

        for (Finger f : Finger.values()) {
            bw.write(fingerCounts.get(f) + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
