import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 32187 급식_배식
 * 난이도: GOLD4
 * 유형: 구현
 */
class Main_32187 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class Request {
        int studentId;
        int value;

        public Request(int studentId, int value) {
            this.studentId = studentId;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2601/30_32187_급식_배식.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 1. 데이터 파싱: '음식'을 기준으로 데이터를 모은다.
        // foodRequests[i] = i번 음식을 원하는 학생들의 목록
        List<Request>[] foodRequests = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            foodRequests[i] = new ArrayList<>();
        }

        // 학생별 입력 정보를 음식별 정보로 변환 (Inverting the index)
        for (int studentId = 1; studentId <= m; studentId++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());

            for (int k = 0; k < count; k++) {
                int foodId = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());

                // 해당 음식을 원하는 학생 리스트에 추가
                foodRequests[foodId].add(new Request(studentId, value));
            }
        }

        long totalHappiness = 0;

        // 2. 각 음식별로 DP 수행 (독립 시행)
        for (int i = 1; i <= n; i++) {
            List<Request> requests = foodRequests[i];

            // 요청이 없는 음식은 패스
            if (requests.isEmpty())
                continue;

            // 학생 번호 순으로 처리가 되어야 하므로 정렬 필요
            // (입력 순서가 학생 1, 2... 순이라 이미 정렬되어 있지만, 안전하게 보장하려면 필요)
            // 여기서는 입력 루프가 학생 1부터 M까지 순서대로 돌았으므로 리스트는 이미 오름차순 정렬 상태임.

            totalHappiness += solveFoodDP(requests);
        }
        sb.append(totalHappiness);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    /**
     * 특정 음식 하나에 대한 최대 행복도를 계산하는 함수
     * 로직: 연속된 학생(j, j+1)은 동시에 선택 불가. 그 외는 선택 가능.
     */
    private static long solveFoodDP(List<Request> requests) {
        // dp[0]: 직전 학생이 이 음식을 '먹지 않았을 때'의 최대값
        // dp[1]: 직전 학생이 이 음식을 '먹었을 때'의 최대값
        long exclude = 0;
        long include = 0;

        int prevStudentId = -100; // 초기값 (갭을 만들기 위해)

        for (Request req : requests) {
            long currentExclude, currentInclude;

            if (req.studentId == prevStudentId + 1) {
                // 바로 앞 학생과 연속된 번호인 경우 (경쟁 관계)
                // 1. 이번 학생이 안 먹는 경우: 앞 학생이 먹든 안 먹든 상관 없이 최대값 가져옴
                currentExclude = Math.max(exclude, include);

                // 2. 이번 학생이 먹는 경우: 앞 학생은 반드시 안 먹었어야 함 (exclude + 현재가치)
                currentInclude = exclude + req.value;
            } else {
                // 앞 학생과 번호가 떨어져 있는 경우 (경쟁 관계 아님)
                // 앞 학생의 결과 중 가장 큰 값을 베이스로 가져감
                long base = Math.max(exclude, include);

                currentExclude = base;
                currentInclude = base + req.value;
            }

            // 상태 업데이트
            exclude = currentExclude;
            include = currentInclude;
            prevStudentId = req.studentId;
        }

        return Math.max(exclude, include);
    }
}
