import sys
import os
import datetime

# -----------------------------------------------------
# 1. 설정 (Settings)
# -----------------------------------------------------
FILE_EXTENSION_JAVA = ".java"
FILE_EXTENSION_MD = ".md"
FILE_EXTENSION_TXT = ".txt"
README_PATH = "README.md"

# [Java 템플릿] 
# {{ }}는 Java의 중괄호를 표현하기 위한 이스케이프 문자입니다.
# System.setIn 부분은 자동 생성된 txt 파일을 읽도록 설정되어 있습니다.
# ★수정됨★: public class Main -> class Main (파일명 자동변경 방지)
JAVA_TEMPLATE = """import java.util.*;
import java.io.*;

/**
 * 문제: {site} {problem_num} {problem_name}
 * 난이도: {tier}
 * 유형: {algorithm_type}
 */
class Main {{
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {{
        // System.setIn(new FileInputStream("{site}/{year_month}/{day}_{problem_num}_{problem_name}.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }}
}}
"""

# [회고록(Review) 템플릿]
MD_TEMPLATE = """# 📝 {problem_name} ({site} {problem_num})

### 💡 접근 방식 (Idea)
- 

### ⚠️ 막혔던 부분 / 중요 포인트
- 

### 🗝️ 해결 코드 (Key Point)
```java
// 핵심 로직만 복사해서 기록해두기
```

### 📋 참고 자료
- 
"""

SITE_MAP = {
    'boj': 'BOJ',
    'pgs': 'Programmers',
    'swea': 'SWEA'
}

# -----------------------------------------------------
# 2. URL 생성 로직
# -----------------------------------------------------
def get_problem_url(site_key, problem_num):
    if site_key == 'boj':
        return f"https://www.acmicpc.net/problem/{problem_num}"
    elif site_key == 'pgs':
        return f"https://school.programmers.co.kr/learn/courses/30/lessons/{problem_num}"
    elif site_key == 'swea':
        return f"https://swexpertacademy.com/main/code/problem/problemList.do?searchWord={problem_num}"
    return ""

# -----------------------------------------------------
# 3. README 업데이트 로직
# -----------------------------------------------------
def update_readme(date_str, site_key, problem_num, problem_name, tier, algo_type, java_rel_path, md_rel_path):
    if not os.path.exists(README_PATH):
        print(f"⚠️ {README_PATH} not found.")
        return

    site_name = SITE_MAP[site_key]
    problem_url = get_problem_url(site_key, problem_num)
    display_name = f"{problem_num}_{problem_name}" if problem_name else problem_num
    
    # 윈도우 경로 치환 (\ -> /)
    java_rel_path = java_rel_path.replace("\\", "/")
    md_rel_path = md_rel_path.replace("\\", "/")

    # 표 행 추가: | 날짜 | 사이트 | 문제 | 난이도 | 유형 | 풀이 | 회고 |
    row = f"| {date_str} | {site_name} | [{display_name}]({problem_url}) | {tier} | {algo_type} | [Java]({java_rel_path}) | [Review]({md_rel_path}) |\n"

    with open(README_PATH, 'a', encoding='utf-8') as f:
        f.write(row)
    
    print(f"📝 README.md updated!")

# -----------------------------------------------------
# 4. 메인 로직
# -----------------------------------------------------
def create_problem_file():
    # 인자 확인
    if len(sys.argv) < 6:
        print("Usage: python create.py [site] [num] [name] [tier] [type]")
        return

    site_key = sys.argv[1].lower()
    problem_num = sys.argv[2]
    problem_name = sys.argv[3]
    tier = sys.argv[4]
    algo_type = sys.argv[5]

    if site_key not in SITE_MAP:
        print("Error: Invalid site.")
        return

    root_folder = SITE_MAP[site_key]
    
    # 날짜 계산
    now = datetime.datetime.now()
    year_month = now.strftime("%y%m")
    day = now.strftime("%d")
    date_display = now.strftime("%y.%m.%d")

    # 월별 폴더 생성
    target_dir = os.path.join(root_folder, year_month)
    if not os.path.exists(target_dir):
        os.makedirs(target_dir)

    # 기본 파일명
    base_filename = f"{day}_{problem_num}_{problem_name}"

    # 1. Java 파일 생성
    java_path = os.path.join(target_dir, base_filename + FILE_EXTENSION_JAVA)
    if not os.path.exists(java_path):
        content = JAVA_TEMPLATE.format(
            site=SITE_MAP[site_key],
            year_month=year_month,
            day=day,
            problem_num=problem_num,
            problem_name=problem_name,
            tier=tier,
            algorithm_type=algo_type
        )
        with open(java_path, 'w', encoding='utf-8') as f:
            f.write(content)
        print(f"✅ Java Created: {java_path}")
    else:
        print(f"⚠️ Java exists: {java_path}")

    # 2. Markdown(회고) 파일 생성
    md_path = os.path.join(target_dir, base_filename + FILE_EXTENSION_MD)
    if not os.path.exists(md_path):
        md_content = MD_TEMPLATE.format(
            site=SITE_MAP[site_key],
            problem_num=problem_num,
            problem_name=problem_name
        )
        with open(md_path, 'w', encoding='utf-8') as f:
            f.write(md_content)
        print(f"✅ Review Created: {md_path}")
    else:
        print(f"⚠️ Review exists: {md_path}")

    # 3. Input TXT 파일 생성
    txt_path = os.path.join(target_dir, base_filename + FILE_EXTENSION_TXT)
    if not os.path.exists(txt_path):
        with open(txt_path, 'w', encoding='utf-8') as f:
            f.write("") # 빈 파일
        print(f"✅ Input TXT Created: {txt_path}")
    else:
        print(f"⚠️ TXT exists: {txt_path}")

    # 4. README 업데이트
    java_rel_path = f"./{SITE_MAP[site_key]}/{year_month}/{base_filename}{FILE_EXTENSION_JAVA}"
    md_rel_path = f"./{SITE_MAP[site_key]}/{year_month}/{base_filename}{FILE_EXTENSION_MD}"
    
    update_readme(date_display, site_key, problem_num, problem_name, tier, algo_type, java_rel_path, md_rel_path)

if __name__ == "__main__":
    create_problem_file()