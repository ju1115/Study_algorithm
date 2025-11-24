import sys
import os
import datetime

# -----------------------------------------------------
# 1. 설정 (Settings)
# -----------------------------------------------------
FILE_EXTENSION = ".java"
README_PATH = "README.md"

# [수정됨] Java 중괄호 { }를 {{ }}로 변경하여 충돌 방지
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
def update_readme(date_str, site_key, problem_num, problem_name, tier, algo_type, file_rel_path):
    if not os.path.exists(README_PATH):
        print(f"⚠️ {README_PATH} not found.")
        return

    site_name = SITE_MAP[site_key]
    problem_url = get_problem_url(site_key, problem_num)
    display_name = f"{problem_num}_{problem_name}" if problem_name else problem_num
    
    file_rel_path = file_rel_path.replace("\\", "/")

    row = f"| {date_str} | {site_name} | [{display_name}]({problem_url}) | {tier} | {algo_type} | [Java]({file_rel_path}) |\n"

    with open(README_PATH, 'a', encoding='utf-8') as f:
        f.write(row)
    
    print(f"📝 README.md updated!")

# -----------------------------------------------------
# 4. 메인 로직
# -----------------------------------------------------
def create_problem_file():
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

    file_name = f"{day}_{problem_num}_{problem_name}{FILE_EXTENSION}"
    file_path = os.path.join(target_dir, file_name)

    if not os.path.exists(file_path):
        # 여기서 .format()이 실행될 때 {{ }}는 { }로 변환됩니다.
        content = JAVA_TEMPLATE.format(
            site=SITE_MAP[site_key],
            problem_num=problem_num,
            problem_name=problem_name,
            tier=tier,
            algorithm_type=algo_type
        )
        
        with open(file_path, 'w', encoding='utf-8') as f:
            f.write(content)
        print(f"✅ Created: {file_path}")
        
        rel_path = f"./{SITE_MAP[site_key]}/{year_month}/{file_name}"
        update_readme(date_display, site_key, problem_num, problem_name, tier, algo_type, rel_path)
    else:
        print(f"⚠️ File exists: {file_path}")

if __name__ == "__main__":
    create_problem_file()