import sys
import os
import datetime

# -----------------------------------------------------
# 1. 설정 (Settings)
# -----------------------------------------------------
FILE_EXTENSION_JAVA = ".java"
FILE_EXTENSION_MD = ".md"
README_PATH = "README.md"

# [Java 템플릿] 중괄호 충돌 방지를 위해 {{ }} 사용
JAVA_TEMPLATE = """import java.util.*;
import java.io.*;

/**
 * 문제: {site} {problem_num} {problem_name}
 * 난이도: {tier}
 * 유형: {algorithm_type}
 */
public class Main {{
    public static void main(String[] args) throws IOException {{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // Code here
        
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
    
    # 윈도우 경로 치환
    java_rel_path = java_rel_path.replace("\\", "/")
    md_rel_path = md_rel_path.replace("\\", "/")

    # | 날짜 | 사이트 | 문제 | 난이도 | 유형 | 풀이 | 회고 |
    row = f"| {date_str} | {site_name} | [{display_name}]({problem_url}) | {tier} | {algo_type} | [Java]({java_rel_path}) | [Review]({md_rel_path}) |\n"

    with open(README_PATH, 'a', encoding='utf-8') as f:
        f.write(row)
    
    print(f"📝 README.md updated!")

# -----------------------------------------------------
# 4. 메인 로직
# -----------------------------------------------------
def create_problem_file():
    # 인자가 부족하면 종료
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
    
    now = datetime.datetime.now()
    year_month = now.strftime("%y%m")
    day = now.strftime("%d")
    date_display = now.strftime("%y.%m.%d")

    target_dir = os.path.join(root_folder, year_month)
    if not os.path.exists(target_dir):
        os.makedirs(target_dir)

    # 1. Java 파일 생성
    java_file_name = f"{day}_{problem_num}_{problem_name}{FILE_EXTENSION_JAVA}"
    java_path = os.path.join(target_dir, java_file_name)

    if not os.path.exists(java_path):
        content = JAVA_TEMPLATE.format(
            site=SITE_MAP[site_key],
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
    md_file_name = f"{day}_{problem_num}_{problem_name}{FILE_EXTENSION_MD}"
    md_path = os.path.join(target_dir, md_file_name)

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

    # 3. README 업데이트
    java_rel_path = f"./{SITE_MAP[site_key]}/{year_month}/{java_file_name}"
    md_rel_path = f"./{SITE_MAP[site_key]}/{year_month}/{md_file_name}"
    
    update_readme(date_display, site_key, problem_num, problem_name, tier, algo_type, java_rel_path, md_rel_path)

if __name__ == "__main__":
    create_problem_file()