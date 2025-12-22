import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 2015 수들의_합_4
 * 난이도: GOLD4
 * 유형: 누적합
 */
class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/22_2015_수들의_합_4.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        // key: 누적 합 값, value: 해당 누적 합이 등장한 횟수
        Map<Long, Long> map = new HashMap<>();

        long currentSum = 0; // 현재까지의 누적 합 (S[j])
        long count = 0; // 합이 K인 구간의 총 개수

        // 중요: 누적 합이 정확히 K일 때 (S[j] - K = 0),
        // 0이 이미 한 번 존재한다고 설정해야 맨 처음부터 현재까지의 합을 카운트함.
        map.put(0L, 1L);

        for (int i = 0; i < n; i++) {
            currentSum += arr[i];

            // 1. S[j] - K 가 이전에 나온 적이 있는지 확인
            if (map.containsKey(currentSum - k)) {
                count += map.get(currentSum - k);
            }

            // 2. 현재 누적 합을 맵에 갱신 (다음 탐색을 위해)
            map.put(currentSum, map.getOrDefault(currentSum, 0L) + 1);
        }
        sb.append(count);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
