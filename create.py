import sys
import os
import datetime

# -----------------------------------------------------
# 1. 설정 (Settings)
# -----------------------------------------------------
FILE_EXTENSION = ".java"
README_PATH = "README.md"

# 자바 기본 템플릿
JAVA_TEMPLATE = """import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // Code here
        
        bw.flush();
        bw.close();
    }
}
"""

# 사이트별 폴더명 매핑
SITE_MAP = {
    'boj': 'BOJ',
    'pgs': 'Programmers',
    'swea': 'SWEA'
}

# -----------------------------------------------------
# 2. URL 생성 로직 (URL Generators)
# -----------------------------------------------------
def get_problem_url(site_key, problem_num):
    """
    사이트별 문제 링크를 반환합니다.
    """
    if site_key == 'boj':
        return f"https://www.acmicpc.net/problem/{problem_num}"
    
    elif site_key == 'pgs':
        # 프로그래머스는 URL의 마지막 숫자가 문제 번호입니다.
        return f"https://school.programmers.co.kr/learn/courses/30/lessons/{problem_num}"
    
    elif site_key == 'swea':
        # SWEA는 링크 규칙이 복잡하므로 검색 링크로 대체합니다.
        return f"https://swexpertacademy.com/main/code/problem/problemList.do?searchWord={problem_num}"
    
    return ""

# -----------------------------------------------------
# 3. 핵심 로직 (Core Logic)
# -----------------------------------------------------
def update_readme(date_str, site_key, problem_num, problem_name, file_rel_path):
    """
    README.md에 테이블 행을 추가합니다.
    형식: | 날짜 | 사이트 | [문제이름](문제링크) | [풀이](코드링크) |
    """
    if not os.path.exists(README_PATH):
        print(f"⚠️ {README_PATH} not found. Skipping update.")
        return

    site_name = SITE_MAP[site_key]
    
    # 1. 문제 링크 생성
    problem_url = get_problem_url(site_key, problem_num)
    
    # 2. 문제 표시 텍스트 (번호_이름)
    display_name = f"{problem_num}_{problem_name}" if problem_name else problem_num
    
    # 3. 마크다운 링크 문법 적용
    # 문제 링크: [1000_A+B](https://...)
    # 풀이 링크: [Java](./BOJ/...)
    
    file_rel_path = file_rel_path.replace("\\", "/") # 윈도우 경로 호환
    
    # 최종 테이블 행 생성
    row = f"| {date_str} | {site_name} | [{display_name}]({problem_url}) | [Java]({file_rel_path}) |\n"

    with open(README_PATH, 'a', encoding='utf-8') as f:
        f.write(row)
    
    print(f"📝 README.md updated with link!")

def create_problem_file():
    # 인자 부족 시 도움말 출력
    if len(sys.argv) < 3:
        print("Usage: python create.py [site] [problem_num] [problem_name]")
        print("Example: python create.py boj 1000 A+B")
        return

    site_key = sys.argv[1].lower()
    problem_num = sys.argv[2]
    # 문제 이름은 선택사항 (없으면 공백)
    problem_name = sys.argv[3] if len(sys.argv) > 3 else ""

    if site_key not in SITE_MAP:
        print("Error: Invalid site. Use boj, pgs, or swea.")
        return

    root_folder = SITE_MAP[site_key]
    
    # 날짜 정보
    now = datetime.datetime.now()
    year_month = now.strftime("%y%m")
    day = now.strftime("%d")
    date_display = now.strftime("%y.%m.%d") 

    # 폴더 생성
    target_dir = os.path.join(root_folder, year_month)
    if not os.path.exists(target_dir):
        os.makedirs(target_dir)

    # 파일 생성
    full_name = f"{problem_num}_{problem_name}" if problem_name else problem_num
    file_name = f"{day}_{full_name}{FILE_EXTENSION}"
    file_path = os.path.join(target_dir, file_name)

    if not os.path.exists(file_path):
        with open(file_path, 'w', encoding='utf-8') as f:
            f.write(JAVA_TEMPLATE)
        print(f"✅ Created: {file_path}")
        
        # README 업데이트 호출
        rel_path = f"./{SITE_MAP[site_key]}/{year_month}/{file_name}"
        # 여기서 problem_num과 problem_name을 따로 넘겨줍니다.
        update_readme(date_display, site_key, problem_num, problem_name, rel_path)
    else:
        print(f"⚠️ File exists: {file_path}")

if __name__ == "__main__":
    create_problem_file()